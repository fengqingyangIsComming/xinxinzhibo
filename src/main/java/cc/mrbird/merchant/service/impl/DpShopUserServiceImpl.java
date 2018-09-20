package cc.mrbird.merchant.service.impl;

import cc.mrbird.merchant.dao.DpIntegralRecordMapper;
import cc.mrbird.merchant.dao.DpShopUserMapper;
import cc.mrbird.merchant.domain.DpIntegralRecord;
import cc.mrbird.merchant.domain.DpShopUser;
import cc.mrbird.merchant.service.DpShopUserService;
import cc.mrbird.system.dao.UserMapper;
import cc.mrbird.system.domain.User;
import cc.mrbird.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Yxy
 * @date 2018/9/3 20:19
 */
@Service("dpShopUserService")
public class DpShopUserServiceImpl implements DpShopUserService {

    @Autowired
    private DpShopUserMapper dpShopUserMapper;

    @Autowired
    private DpIntegralRecordMapper dpIntegralRecordMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    /**
     * 修改审核商家的状态，审核原因，添加审核人员
     * 并将该用户放进管理员表（t_user）表中
     * @param dpShopUser
     */
    @Override
    @Transactional
    public void updateStatusByUserIdx(DpShopUser dpShopUser) {
        if (dpShopUser.getStatus()==2){
//                LiveUserInfo liveUserInfo = new LiveUserInfo();
//                liveUserInfo.setInviteCode(inviteCode);
//                LiveUserInfo info = this.liveUserInfoService.findByInviteCode(liveUserInfo);
            DpIntegralRecord dpIntegralRecord = new DpIntegralRecord();
            //dpIntegralRecord.setPid(shopUserId);
            dpIntegralRecord.setCreatetime(new Date());
            dpIntegralRecord.setStatus(1);
            //this.dpIntegralRecordService.insert(dpIntegralRecord);
            this.dpIntegralRecordMapper.insert(dpIntegralRecord);
            //审核通过后，在管理员表中插入数据
            DpShopUser shopUser = this.dpShopUserMapper.findByShopUserId(dpShopUser);
            //DpShopUser shopUser = this.dpShopUserService.findByShopUserId(dpShopUser);
            User user = new User();
            user.setUsername(shopUser.getUseridx()+"");
            user.setPassword(shopUser.getPass());
            //this.userService.registUser(user);
            Long[] roles = new Long[1];
            roles[0] = Long.parseLong("66");
            this.userService.addUser(user,roles);
        }
        this.dpShopUserMapper.updateStatusByUserIdx(dpShopUser);
    }

    /**
     * 通过商家id查询商家信息
     * @param dpShopUser
     * @return
     */
    @Override
    public DpShopUser findByShopUserId(DpShopUser dpShopUser) {

        return this.dpShopUserMapper.findByShopUserId(dpShopUser);
    }

    /**
     * 根据邀请码查询该用户的邀请记录
     * @param dpShopUser
     * @return
     */
    @Override
    public List<Map> findByInvitedCode(DpShopUser dpShopUser) {
        return this.dpShopUserMapper.findByInvitedCode(dpShopUser);
    }

    @Override
    public List<Map> findByUseridxs(DpShopUser dpShopUser) {
        return this.dpShopUserMapper.findByUseridxs(dpShopUser);
    }
}
