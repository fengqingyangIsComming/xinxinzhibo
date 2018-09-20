package cc.mrbird.merchant.service.impl;
import cc.mrbird.merchant.dao.DpShopMapper;
import cc.mrbird.merchant.dao.DpShopUserMapper;
import cc.mrbird.merchant.domain.DpOrder;
import cc.mrbird.merchant.domain.DpShop;
import cc.mrbird.merchant.domain.DpShopUser;
import cc.mrbird.merchant.service.MerchantService;
import cc.mrbird.shop.dao.DpShopReviewMapper;
import cc.mrbird.shop.domain.DpShopReview;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yxy
 * @date 2018/8/31 13:34
 */
@Service("shopService")
public class MerchantServiceImpl implements MerchantService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DpShopMapper dpShopMapper;

	@Autowired
	private DpShopUserMapper dpShopUserMapper;

	@Autowired
	private DpShopReviewMapper dpShopReviewMapper;


	@Override
	@Transactional
	public void merchantRegist(DpShop dpShop, DpShopUser dpShopUser) {

		this.dpShopMapper.insert(dpShop);
		dpShopUser.setPid(dpShop.getId());
		this.dpShopUserMapper.insert(dpShopUser);
	}

	@Override
	public List<Map> findByMerchant(DpShop dpShop, DpShopUser dpShopUser) {
		Map map = new HashMap();
		if (dpShop == null) {
			map.put("name", "");
		} else {
			map.put("name", dpShop.getName());
		}
		if (dpShopUser == null) {
			map.put("useridx", "");
			map.put("status", "");
		} else {
			if (dpShopUser.getStatus()==null){
				map.put("status", "");
			}else {
				map.put("status", dpShopUser.getStatus());
			}
			if (dpShopUser.getUseridx()==null){
				map.put("useridx", "");
			}else {
				map.put("useridx", dpShopUser.getUseridx());
			}


		}

		return this.dpShopMapper.findByMerchant(map);
	}

	@Override
	public Map<String, Object> findByMerchantID(DpShopUser dpShopUser) {
		return this.dpShopMapper.findByMerchantID(dpShopUser);
	}



	@Override
	public List<Map> findByChart(DpShop dpShop, DpOrder dpOrder) {
		Map map = new HashMap();
		if (dpShop == null) {
			map.put("name", "");
		} else {
			map.put("name", dpShop.getName());
		}
		if(dpOrder ==null){
			map.put("shop_price","");
		}else{
			map.put("shop_price",dpOrder.getShopPrice());
		}
		return this.dpShopMapper.findByChart(map);
	}

	@Override
	public List<DpShop> findChartWithOrder(DpShop dpShop) {
		try {
			return this.dpShopMapper.findChartWithOrder(dpShop);
		} catch (Exception e) {
			log.error("error", e);
			return new ArrayList<>();
		}
	}

	/**
	 * 修改商家审核状态
	 * @param dpShop
	 * @param dpShopUser
	 * @param dpShopReview
	 */
	@Override
	@Transactional
	public void updateDpShopReviewStatus(DpShop dpShop, DpShopUser dpShopUser, DpShopReview dpShopReview) {
		this.dpShopMapper.updateByDpShop(dpShop);
		this.dpShopUserMapper.updateByDpShopUser(dpShopUser);
		this.dpShopReviewMapper.updateStatus(dpShopReview);
	}

	/**
	 * 修改商家其他信息
	 * @param dpShop
	 * @param dpShopUser
	 */
	@Override
	@Transactional
	public void updateOtherInfo(DpShop dpShop, DpShopUser dpShopUser) {
		this.dpShopMapper.updateOtherInfo(dpShop);
		this.dpShopUserMapper.updateShopUserOtherInfo(dpShopUser);
	}

	@Override
	public Map findByShopId(DpShop dpShop) {
		return this.dpShopMapper.findByShopId(dpShop);
	}

}
