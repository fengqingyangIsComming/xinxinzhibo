package cc.mrbird.shop.controller;

import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.merchant.domain.DpShopUser;
import cc.mrbird.merchant.service.MerchantService;
import cc.mrbird.shop.domain.DpOfferReview;
import cc.mrbird.shop.service.DpOfferReviewService;
import cc.mrbird.system.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author Yxy
 * @date 2018/9/5 10:35
 */
@Controller
public class OfferReleaseController extends BaseController {

    @Autowired
    private DpOfferReviewService dpOfferReviewService;

    @Autowired
    private MerchantService merchantService;

    @RequestMapping("offerRelease")
    public String offerRelease() {

        return "shop/offer/offerRelease";
    }


    @RequestMapping("offerRelease/review")
    @ResponseBody
    public ResponseBo review(DpOfferReview dpOfferReview) {
        try{
            //DpOfferReview offerReview = new DpOfferReview();
            User user = super.getCurrentUser();
            DpShopUser dpShopUser = new DpShopUser();
            dpShopUser.setUseridx(Long.valueOf(user.getUsername()));

            List<Map> merchant = this.merchantService.findByMerchant(null, dpShopUser);

            dpOfferReview.setShopId((Integer) merchant.get(0).get("shopId"));
            if ("1".equals(dpOfferReview.getType())){
                //满减优惠
                dpOfferReview.setSale(null);
            }else {
                dpOfferReview.setMan(null);
                dpOfferReview.setJian(null);
            }
            this.dpOfferReviewService.insert(dpOfferReview);
            return ResponseBo.ok("优惠发布已提交成功，正在审核！");
        }catch (Exception e){
            return ResponseBo.error("提交失败，请联系管理员");
        }
    }



}
