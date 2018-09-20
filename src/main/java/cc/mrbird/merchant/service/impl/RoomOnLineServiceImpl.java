package cc.mrbird.merchant.service.impl;

import cc.mrbird.common.cedatasource.TargetDataSource;
import cc.mrbird.merchant.dao.RoomOnLineUserMapper;
import cc.mrbird.merchant.service.RoomOnLineUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by  AndyZhou
 * 2018/9/19   10:02
 */
@Service("roomOnLineUserService")
public class RoomOnLineServiceImpl implements RoomOnLineUserService {
	@Autowired
	private RoomOnLineUserMapper roomOnLineUserMapper;

	@Override
	@TargetDataSource("upms")
	public List<Map> findAllIds() {

		List<Map> allIds = roomOnLineUserMapper.findAllIds();

		return allIds;

	}
}
