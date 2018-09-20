package cc.mrbird.shop.controller;

import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.CodeUtil;
import cc.mrbird.merchant.domain.DpShop;
import cc.mrbird.merchant.domain.DpShopUser;
import cc.mrbird.merchant.service.MerchantService;
import cc.mrbird.shop.domain.DpShopReview;
import cc.mrbird.shop.service.DpShopReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Yxy
 * @date 2018/9/4 17:00
 */
@Controller
public class ShopInfoController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private DpShopReviewService dpShopReviewService;

    /**
     * 商家基本信息
     * @return
     */
    @RequestMapping("shopBaseInfo")
    public String shopBaseInfo() {

        return "shop/store/baseInfo";
    }


    /**
     * 商家其他信息
     * @return
     */
    @RequestMapping("shopOtherInfo")
    public String shopOtherInfo() {

        return "shop/store/otherInfo";
    }


    /**
     * 根据用户id查询商家基本信息
     * @param dpShopUser
     * @return
     */
    @RequestMapping("shop/otherInfo")
    @ResponseBody
    public ResponseBo otherInfo(DpShopUser dpShopUser) {
        //
        return ResponseBo.ok();
    }

    /**
     * 获取该商家的基本信息
     * @param dpShopUser
     * @return
     */
    @RequestMapping("shop/getMerchantInfo")
    @ResponseBody
    public ResponseBo getMerchantInfo(DpShopUser dpShopUser) {
        dpShopUser.setStatus(2);
        List<Map> merchant = this.merchantService.findByMerchant(null, dpShopUser);
        Map map = merchant.get(0);
        Long useridx = (Long) map.get("useridx");
        String code = CodeUtil.getCodeById(useridx);
        map.put("inviteCode",code);
        map.put("reviewType",1);
        Integer shopId = (Integer) map.get("shopId");
        DpShopReview dpShopReview = new DpShopReview();
        //dpShopReview.setId(shopId);
        dpShopReview.setShopId(shopId);
        Map map1 = this.dpShopReviewService.findByShopId(dpShopReview);
        if (map1 != null && map1.size()>0){
            map1.put("reviewType",2);
            map1.put("useridx",map.get("useridx"));
            map.put("inviteCode",code);
            return ResponseBo.ok(map1);
        }
        return ResponseBo.ok(map);
    }


    /**
     * 获取商家其他信息
     * @param dpShopUser
     * @return
     */
    @RequestMapping("shop/getMerchantOtherInfo")
    @ResponseBody
    public ResponseBo getMerchantOtherInfo(DpShopUser dpShopUser) {
        dpShopUser.setStatus(2);
        List<Map> merchant = this.merchantService.findByMerchant(null, dpShopUser);
        Map map = merchant.get(0);

        return ResponseBo.ok(map);
    }

    @RequestMapping("baseInfo/review")
    @ResponseBody
    public ResponseBo review(DpShopReview dpShopReview) {
        try{
            dpShopReview.setStatus(1);
            dpShopReview.setCreated(new Date());

            //通过typeName查询typeId
//            Integer typeId = this.dpShopReviewService.findByTypeName(typeName);
//            dpShopReview.setTypeId(typeId);
            this.dpShopReviewService.insert(dpShopReview);
            return ResponseBo.ok("信息提交成功，正在审核中！");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseBo.error("信息提交失败，请联系管理员！");
        }
    }

    @RequestMapping("otherInfo/save")
    @ResponseBody
    public ResponseBo save(DpShop dpShop,DpShopUser dpShopUser,Integer shopId) {
        try{
            dpShop.setId(shopId);
            dpShopUser.setPid(shopId);
            this.merchantService.updateOtherInfo(dpShop,dpShopUser);
            return ResponseBo.ok("信息提交成功，正在审核中！");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseBo.error("信息提交失败，请联系管理员！");
        }
    }
}
