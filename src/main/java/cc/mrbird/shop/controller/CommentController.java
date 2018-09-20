package cc.mrbird.shop.controller;

import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.merchant.domain.DpShopUser;
import cc.mrbird.merchant.domain.LiveUserInfo;
import cc.mrbird.merchant.service.DpShopService;
import cc.mrbird.merchant.service.DpShopUserService;
import cc.mrbird.merchant.service.LiveUserInfoService;
import cc.mrbird.merchant.service.MerchantService;
import cc.mrbird.shop.domain.DpComment;
import cc.mrbird.shop.service.CommentService;
import cc.mrbird.system.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author Yxy
 * @date 2018/9/5 11:23
 */
@Controller
public class CommentController extends BaseController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private LiveUserInfoService liveUserInfoService;

    @Autowired
    private DpShopUserService dpShopUserService;

    @Autowired
    private MerchantService merchantService;

    /**
     * 查询评论列表信息
     * @return
     */
    @RequiresPermissions("comment:list")
    @RequestMapping("comment")
    public String comment() {

        return "shop/comment/comment";
    }


    @RequestMapping("comment/list")
    @ResponseBody
    public Map<String, Object> commentList(QueryRequest request, DpComment dpComment) {
        User user = super.getCurrentUser();
        //dpComment.setShopId(Integer.valueOf(user.getUsername()));
        DpShopUser dpShopUser = new DpShopUser();
        dpShopUser.setUseridx(Long.valueOf(user.getUsername()));
        dpShopUser.setStatus(2);
        List<Map> merchant = this.merchantService.findByMerchant(null, dpShopUser);
        dpComment.setShopId((Integer) merchant.get(0).get("shopId"));
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Map> list = this.commentService.findByComment(dpComment);
        LiveUserInfo liveUserInfo = new LiveUserInfo();
        for (Map comment:list) {
            liveUserInfo.setUserIdx((Long) comment.get("userId"));
            LiveUserInfo userInfo = this.liveUserInfoService.findByUserIdx(liveUserInfo);
            if (userInfo != null && userInfo.getMyname()!=null){
                //comment.setUsername(userInfo.getMyname());
                comment.put("username",userInfo.getMyname());
            }

        }
        PageInfo<Map> pageInfo = new PageInfo<>(list);
        return getDataTable(pageInfo);
    }

    @RequestMapping("comment/viewDetail")
    @ResponseBody
    public ResponseBo findById(DpComment dpComment){

        try {
            DpComment comment = this.commentService.findById(dpComment);
            return ResponseBo.ok(comment);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseBo.error("查看评论详情失败，请联系管理员！");
        }


    }
}
