package cc.mrbird.shop.controller;

import cc.mrbird.common.controller.BaseController;
import cc.mrbird.common.domain.QueryRequest;
import cc.mrbird.merchant.domain.DpInvitrRecord;
import cc.mrbird.merchant.domain.DpShopUser;
import cc.mrbird.merchant.domain.LiveUserInfo;
import cc.mrbird.merchant.service.DpInvitrRecordService;
import cc.mrbird.merchant.service.DpShopUserService;
import cc.mrbird.merchant.service.LiveUserInfoService;
import cc.mrbird.system.domain.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author Yxy
 * @date 2018/9/5 23:08
 */
@Controller
public class InvitationRecordController extends BaseController {

    @Autowired
    private LiveUserInfoService liveUserInfoService;

    @Autowired
    private DpShopUserService dpShopUserService;

    @Autowired
    private DpInvitrRecordService dpInvitrRecordService;

    @RequestMapping("invitationRecord")
    public String invitationRecord() {

        return "shop/invitationRecord/invitationRecord";
    }


    @RequestMapping("invitationRecord/list")
    @ResponseBody
    public Map<String, Object> commentList(QueryRequest request,DpShopUser dpShopUser) {
        User user = super.getCurrentUser();

        DpInvitrRecord dpInvitrRecord = new DpInvitrRecord();
        dpInvitrRecord.setInvitee(dpShopUser.getUseridx());
        dpInvitrRecord.setInviter(Long.valueOf(user.getUsername()));

        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        List<Map> maps = this.dpInvitrRecordService.findByUserIdx(dpInvitrRecord);
        PageInfo<Map> pageInfo = new PageInfo<>(maps);
        return getDataTable(pageInfo);
    }
}
