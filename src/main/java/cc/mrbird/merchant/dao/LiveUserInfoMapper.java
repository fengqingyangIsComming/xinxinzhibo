package cc.mrbird.merchant.dao;

import cc.mrbird.merchant.domain.LiveUserInfo;

import java.util.List;
import java.util.Map;


/**
 * @author Yxy
 * @date 2018/7/28 15:10
 */
public interface LiveUserInfoMapper {

    LiveUserInfo findByUserIdx(LiveUserInfo liveUserInfo);

    LiveUserInfo findByInviteCode(LiveUserInfo liveUserInfo);

    LiveUserInfo findByUserIdAndPass(LiveUserInfo liveUserInfo);
}
