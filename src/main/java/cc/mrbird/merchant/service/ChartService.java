package cc.mrbird.merchant.service;

import cc.mrbird.merchant.domain.DpShopUser;

import java.util.Map;

/**
 * Created by  AndyZhou
 * 2018/9/6   10:18
 */
public interface ChartService {

	Map<String,Object> findByChartID(DpShopUser dpShopUser);


}
