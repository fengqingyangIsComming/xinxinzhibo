package cc.mrbird.merchant.service;

import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.merchant.domain.LiveUserInfo;

import java.util.List;
import java.util.Map;


public interface LiveUserInfoService {

    LiveUserInfo findByUserIdx(LiveUserInfo liveUserInfo);

    LiveUserInfo findByInviteCode(LiveUserInfo liveUserInfo);

    LiveUserInfo findByUserIdAndPass(LiveUserInfo liveUserInfo);

}
