package cc.mrbird.merchant.controller;

import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.merchant.domain.DpShop;
import cc.mrbird.merchant.service.DpShopService;
import cc.mrbird.shop.domain.DpOfferReview;
import cc.mrbird.shop.service.DpOfferReviewService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Yxy
 * @date 2018/9/6 15:16
 */
@Controller
public class OfferController extends BaseController {

    @Autowired
    private DpOfferReviewService dpOfferReviewService;

    @Autowired
    private DpShopService dpShopService;

    @RequestMapping("offerInfo")
    public String offerInfo() {

        return "merchant/offer/offerInfo";
    }

    /**
     * 查询优惠券列表信息
     * @param request
     * @return
     */
    @RequestMapping("offerInfo/list")
    @ResponseBody
    public Map<String, Object> offerInfoList(QueryRequest request,DpOfferReview dpOfferReview) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Map> list = this.dpOfferReviewService.findByDpOfferReview(dpOfferReview);
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return getDataTable(pageInfo);
    }

    /**
     * 修改优惠券状态
     * @param dpOfferReview
     * @return
     */
    @RequestMapping("offerInfo/review")
    @ResponseBody
    public ResponseBo review(DpOfferReview dpOfferReview){

        try{
            /*if (dpOfferReview.getStatus()==2){
                //审核通过，将优惠券信息存到商家表中
                DpShop dpShop = new DpShop();
                dpShop.setId(dpOfferReview.getShopId());
                dpShop.setMan(dpOfferReview.getMan());
                dpShop.setJian(dpOfferReview.getJian());
                dpShop.setSale(dpOfferReview.getSale());
                this.dpShopService.updateOffer(dpShop);
            }
            dpOfferReview.setReviewTime(new Date());*/
            this.dpOfferReviewService.updateStatus(dpOfferReview);
            return ResponseBo.ok("审核优惠券操作完成！");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseBo.error("审核优惠券失败，请联系管理员！");
        }
    }

}
