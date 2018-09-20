package cc.mrbird.merchant.service.impl;

import cc.mrbird.common.cedatasource.TargetDataSource;
import cc.mrbird.common.domain.ResponseBo;
import cc.mrbird.merchant.dao.LiveUserInfoMapper;
import cc.mrbird.merchant.domain.LiveUserInfo;
import cc.mrbird.merchant.service.LiveUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * @author Yxy
 * @date 2018/8/31 18:31
 */
@Service("liveUserInfoService")
public class LiveUserInfoServiceImpl implements LiveUserInfoService {

	Logger logger = (Logger) LoggerFactory.getLogger(LiveUserInfoServiceImpl.class);

	@Autowired
	private LiveUserInfoMapper liveUserInfoMapper;

	@Override
	@TargetDataSource("upms")
	public LiveUserInfo findByUserIdx(LiveUserInfo liveUserInfo) {
		return this.liveUserInfoMapper.findByUserIdx(liveUserInfo);
	}


	@Override
	@TargetDataSource("upms")
	public LiveUserInfo findByInviteCode(LiveUserInfo liveUserInfo) {
		return this.liveUserInfoMapper.findByInviteCode(liveUserInfo);
	}

	/**
	 * 根据用户id和密码查询
	 *
	 * @param liveUserInfo
	 * @return
	 */
	@Override
	@TargetDataSource("upms")
	public LiveUserInfo findByUserIdAndPass(LiveUserInfo liveUserInfo) {
		return this.liveUserInfoMapper.findByUserIdAndPass(liveUserInfo);
	}
}
