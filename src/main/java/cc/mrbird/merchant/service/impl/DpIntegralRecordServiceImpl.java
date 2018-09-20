package cc.mrbird.merchant.service.impl;

import cc.mrbird.merchant.dao.DpIntegralRecordMapper;
import cc.mrbird.merchant.domain.DpIntegralRecord;
import cc.mrbird.merchant.service.DpIntegralRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yxy
 * @date 2018/9/3 13:14
 */
@Service("dpIntegralRecordService")
public class DpIntegralRecordServiceImpl implements DpIntegralRecordService {

	@Autowired
	private DpIntegralRecordMapper dpIntegralRecordMapper;

	/**
	 * 添加积分记录
	 *
	 * @param record
	 */
	@Override
	public void insert(DpIntegralRecord record) {
		this.dpIntegralRecordMapper.insert(record);
	}

	/**
	 * 查询积分记录列表
	 *
	 * @param map
	 * @return
	 */
	@Override
	public List<Map> findByIntegralRecord(Map map) {
		return this.dpIntegralRecordMapper.findByIntegralRecord(map);
	}

	/**
	 * 根据某个时间段查询信息
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	@Override
	public List<Map> findByIntegralList(String startTime, String endTime) {
		Map map = new HashMap();
		if (startTime == null) {
			map.put("startTime", "");
		} else {
			map.put("startTime", startTime);
		}
		if (endTime == null) {
			map.put("endTime", "");
		} else {
			map.put("endTime", endTime);
		}
		return dpIntegralRecordMapper.findByIntegralList(startTime, endTime);

	}
}
