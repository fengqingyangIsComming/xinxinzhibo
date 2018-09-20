package cc.mrbird.merchant.service.impl;

import cc.mrbird.merchant.dao.DpShopMapper;
import cc.mrbird.merchant.domain.DpShopUser;
import cc.mrbird.merchant.service.ChartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by  AndyZhou
 * 2018/9/6   10:19
 */
@Service
public class ChartServiceImpl implements ChartService{
	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DpShopMapper dpShopMapper;



	@Override
	public Map<String, Object> findByChartID(DpShopUser dpShopUser) {
		return this.dpShopMapper.findByChartID(dpShopUser);
	}
}
