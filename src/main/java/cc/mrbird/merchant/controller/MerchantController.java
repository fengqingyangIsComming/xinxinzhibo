package cc.mrbird.merchant.controller;

import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.common.util.CodeUtil;
import cc.mrbird.common.util.GaoDeiUtils;
import cc.mrbird.common.util.MD5Utils;
import cc.mrbird.merchant.domain.DpInvitrRecord;
import cc.mrbird.merchant.domain.DpShop;
import cc.mrbird.merchant.domain.DpShopUser;
import cc.mrbird.merchant.domain.LiveUserInfo;
import cc.mrbird.merchant.service.*;
import cc.mrbird.shop.domain.DpShopReview;
import cc.mrbird.shop.service.DpShopReviewService;
import cc.mrbird.system.domain.User;
import cc.mrbird.system.service.RegisterService;
import cc.mrbird.system.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yxy
 * @date 2018/8/30 18:20
 */
@Controller
public class MerchantController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MerchantService merchantService;

    @Autowired
    private LiveUserInfoService liveUserInfoService;

    @Autowired
    private DpIntegralRecordService dpIntegralRecordService;

    @Autowired
    private DpShopUserService dpShopUserService;

    @Autowired
    private UserService userService;

    @Autowired
    private DpShopReviewService dpShopReviewService;

    @Autowired
    private RegisterService registerService;

    @Autowired
    private DpInvitrRecordService dpInvitrRecordService;




//    @RequestMapping("shop/regist")
//    public String regist() {
//        return "system/regist/regist";
//    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/register/getCategory")
    @ResponseBody
    public ResponseBo getCategory() {
        return ResponseBo.ok(registerService.selectAll());
    }

    //@Log("商家注册")

    /**
     * 商家注册，提交材料
     * @param dpShop
     * @param dpShopUser
     * @return
     */
    @RequestMapping("merchant/regist")
    @ResponseBody
    public ResponseBo merchantRegist(DpShop dpShop, DpShopUser dpShopUser) {
        try {
            /*LiveUserInfo liveUserInfo = new LiveUserInfo();
            liveUserInfo.setUserIdx(dpShopUser.getUseridx());
            LiveUserInfo userInfo = this.liveUserInfoService.findByUserIdx(liveUserInfo);
            if (userInfo==null){
                return ResponseBo.warn("请使用宝兆账号注册！");
            }*/
            //根据id生成邀请码，判断与用户输入的邀请码是否相等
            /*if (dpShopUser.getInvitedCode().equals(CodeUtil.getCodeById(userInfo.getUserIdx()))){
                return ResponseBo.warn("禁止填写本人邀请码！");
            }*/
            //liveUserInfo.setInviteCode(dpShopUser.getInvitedCode());
            //LiveUserInfo info = this.liveUserInfoService.findByInviteCode(liveUserInfo);

            //用户填写的邀请码转化成id，通过id判断该用户信息是否存在
            Long codeId = CodeUtil.getIdByCode(dpShopUser.getInvitedCode());
            /*liveUserInfo.setUserIdx(codeId);
            LiveUserInfo info = this.liveUserInfoService.findByUserIdx(liveUserInfo);
            if (info==null){
                return ResponseBo.warn("邀请码填写错误，请输入正确的邀请码！");
            }*/

            //在t_user表中根据id（用户名）判断该用户是否是商家

            User byName = this.userService.findByName(codeId + "");
            if (byName==null){
                return ResponseBo.warn("该邀请码还没有入住商家！");
            }

            //判断用户是否已经注册
            DpShopUser user = new DpShopUser();
            user.setUseridx(dpShopUser.getUseridx());
            List<Map> merchants = this.dpShopUserService.findByUseridxs(user);
            //List<Map> merchants = this.merchantService.findByMerchant(null, user);
            if(merchants!=null && merchants.size()>0){
                for (Map map:merchants) {
                    Integer status = (Integer) map.get("status");
                    if ( status != null &&(status == 1 || status == 2)){
                        return ResponseBo.warn("该账号已被注册或者正在审核中，请不要重复提交！");
                    }
                }
            }
            Date date = new Date();
            dpShop.setCreated(date);
            dpShopUser.setStatus(1);

            GaoDeiUtils gaoDeiUtils=new GaoDeiUtils();
            double [] data = gaoDeiUtils.addressToGPS(dpShopUser.getpCDistrict());
            if(data==null){
                dpShop.setJingdu("120.075097");
                dpShop.setWeidu("30.293039");
            }else{
                dpShop.setJingdu(""+data[0]);
                dpShop.setWeidu(""+data[1]);
            }
            this.merchantService.merchantRegist(dpShop,dpShopUser);

            return ResponseBo.ok("材料提交成功,审核通过后会有短信通知请注意查收！");
        } catch (Exception e) {
            log.error("材料提交失败:"+ e);
            return ResponseBo.error("材料提交失败，请联系网站管理员！");
        }
    }

    @RequestMapping("merchantInfo")
    public String merchantInfo() {

        return "merchant/merchant/merchantInfo";
    }

    /**
     * 查询商家列表
     * @param request

     * @return
     */
    @RequestMapping("merchantInfo/list")
    @ResponseBody
    public Map<String, Object> merchantInfoList(QueryRequest request, DpShopReview dpShopReview) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
       /* List<Map> list = null;
        if ("1".equals(reviewType)){
            list = this.merchantService.findByMerchant(dpShop,dpShopUser);
        }else {
            DpShopReview dpShopReview = new DpShopReview();
            dpShopReview.setName(dpShop.getName());
            dpShopReview.setStatus(dpShopUser.getStatus());
            list = this.dpShopReviewService.findByDpShopReview(dpShopReview);
        }
        for (Map map:list) {
            map.put("reviewType",reviewType);
        }*/
        List<Map> maps = this.dpShopReviewService.findByDpShopReview(dpShopReview);
        PageInfo<Map> pageInfo = new PageInfo<>(maps);
        return getDataTable(pageInfo);
    }

    /**
     * 获取商家详情
     * @return
     */
    @RequestMapping("merchant/getMerchantInfo")
    @ResponseBody
    public ResponseBo getMerchant(DpShopReview dpShopReview) {
        try{
            Map map = this.dpShopReviewService.findById(dpShopReview);
            return ResponseBo.ok(map);
        }catch (Exception e){
            return ResponseBo.error("获取详情失败，请联系管理人员！");
        }

    }


    /**
     * 获取商家详情
     * @return
     */
    @RequestMapping("merchant/getMerchantInfo2")
    @ResponseBody
    public ResponseBo getMerchantInfo2(String useridx) {
        log.info("获取商家详情：{"+useridx+"}");
        Map map = dpShopReviewService.findShopInfoByUseridx(useridx);
        log.info("获取商家详情数据成功：{"+useridx+"}"+map);
        Map<String,Object> rdMap=new HashMap<>();
        if(map==null){
            log.error("获取商家详情为空：{"+useridx+"}");
            return ResponseBo.error("获取商家详情为空！");
        }
        rdMap.put("status",map.get("rstatus").toString());
        rdMap.put("useridx",useridx);
        rdMap.put("invitedCode",map.get("invitedCode"));
        rdMap.put("shopId",map.get("shopId"));
        if("1".equals(map.get("rstatus").toString()) || "2".equals(map.get("rstatus").toString())){
            rdMap.put("name",map.get("rname"));
            rdMap.put("username",map.get("rusername"));
            rdMap.put("typeId",map.get("rtype_id"));
            rdMap.put("phone",map.get("raddress"));
            rdMap.put("address",map.get("rphone"));
            rdMap.put("telephone",map.get("rtelephone"));
            rdMap.put("email",map.get("remail"));
            rdMap.put("country",map.get("rcountry"));
            rdMap.put("pCDistrict",map.get("rPCDistrict"));
            rdMap.put("address",map.get("raddress"));
            rdMap.put("registrationNumber",map.get("rregistrationNumber"));
            rdMap.put("businessProof",map.get("rbusiness_proof"));
            rdMap.put("storeImage",map.get("rstore_image"));
            rdMap.put("images",map.get("rimages"));
            log.info("返回商家详情：{"+useridx+"}"+rdMap);
            return ResponseBo.ok(rdMap);
        }else if("3".equals(map.get("rstatus").toString())){
            rdMap.put("name",map.get("name"));
            rdMap.put("username",map.get("username"));
            rdMap.put("typeId",map.get("type_id"));
            rdMap.put("phone",map.get("address"));
            rdMap.put("address",map.get("phone"));
            rdMap.put("telephone",map.get("telephone"));
            rdMap.put("email",map.get("email"));
            rdMap.put("country",map.get("country"));
            rdMap.put("pCDistrict",map.get("PCDistrict"));
            rdMap.put("address",map.get("address"));
            rdMap.put("registrationNumber",map.get("registrationNumber"));
            rdMap.put("businessProof",map.get("business_proof"));
            rdMap.put("storeImage",map.get("store_image"));
            rdMap.put("images",map.get("images"));
            log.info("返回商家详情：{"+useridx+"}"+rdMap);
            return ResponseBo.ok(rdMap);
        }else {
            log.error("返回商家详情出错：{"+useridx+"}");
            return ResponseBo.error("获取商家详情出错！");
        }
    }

    /**
     * 商家审核
     *
     * @return
     */
    @RequestMapping("merchant/review")
    @ResponseBody
    public ResponseBo reviewMerchant(DpShopReview dpShopReview,Long useridx) {
        try {

            this.dpShopReviewService.updateStatus(dpShopReview,useridx);

            /*if ("1".equals(reviewType)){
                dpShopUser.setId(shopUserId);
                this.dpShopUserService.updateStatusByUserIdx(dpShopUser);
                DpInvitrRecord dpInvitrRecord = new DpInvitrRecord();
                Long idByCode = CodeUtil.getIdByCode(inviteCode);
                dpInvitrRecord.setInviter(idByCode);
                dpInvitrRecord.setInvitee(dpShopUser.getUseridx());
                this.dpInvitrRecordService.insert(dpInvitrRecord);
            }else {
                //将数据修改到dp_shop表中
                //修改dp_shop_review中的状态
                dpShop.setId(shopId);
                dpShopUser.setPid(shopId);
                DpShopReview dpShopReview = new DpShopReview();
                //dpShopReview.setId(shopUserId);
                dpShopReview.setShopId(shopId);
                dpShopReview.setStatus(dpShopUser.getStatus());
                dpShopReview.setOperator(dpShopUser.getOperator());
                dpShopReview.setReviewTime(new Date());
                this.merchantService.updateDpShopReviewStatus(dpShop,dpShopUser,dpShopReview);

            }*/


            //this.merchantService.updateDpShopReviewStatus(dpShopReview);
            return ResponseBo.ok("已完成审核操作");
        }catch (Exception e){
            e.printStackTrace();
            return ResponseBo.ok("审核操作失败，请联系管理员！");
        }
    }



    @RequestMapping("user/findByUserIdAndPass")
    @ResponseBody
    public ResponseBo findByUserIdAndPass(String username,String password) {
        try {
            LiveUserInfo liveUserInfo = new LiveUserInfo();
            liveUserInfo.setUserIdx(Long.valueOf(username));

            LiveUserInfo byUserIdAndPass = this.liveUserInfoService.findByUserIdAndPass(liveUserInfo);
            if (byUserIdAndPass != null && byUserIdAndPass.getPass().equals(MD5Utils.md5Encode(password))) {

                User byName = this.userService.findByName(username);
                if (byName == null) {
                    Long[] roles = new Long[1];
                    roles[0] = Long.parseLong("66");
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);
                    this.userService.addUser(user, roles);

                    //添加dp_shop dp_shop_user
                    DpShop dpShop = new DpShop();
                    dpShop.setName(username);
                    DpShopUser dpShopUser = new DpShopUser();
                    dpShopUser.setUseridx(Long.valueOf(username));
                    dpShopUser.setStatus(1);
                    this.merchantService.merchantRegist(dpShop, dpShopUser);

                    return ResponseBo.ok("1");
                } else {
                    if (!byName.getPassword().equals(MD5Utils.md5Encode(password))) {
                        this.userService.updatePassword(password);
                    }
                }

                return ResponseBo.error("2");
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return ResponseBo.ok("2");
        }
        return ResponseBo.ok("2");
    }

}
