package cc.mrbird.merchant.dao;


import cc.mrbird.merchant.domain.DpShop;
import cc.mrbird.merchant.domain.DpShopUser;
import cc.mrbird.shop.domain.DpOfferReview;
import cc.mrbird.shop.domain.DpShopReview;


import java.util.List;
import java.util.Map;

public interface DpShopMapper {

	void insert(DpShop dpShop);

	List<Map> findByMerchant(Map map);

	Map<String, Object> findByMerchantID(DpShopUser dpShopUser);

    void updateOfferInfo(DpOfferReview dpOfferReview);
	
	List<Map> findByChart(Map map);

	List<DpShop> findChartWithOrder(DpShop dpShop);

	Map<String,Object> findByChartID(DpShopUser dpShopUser);

	//int findCountByShopId(Integer ShopId);

	void updateByDpShop(DpShop dpShop);

	void updateOtherInfo(DpShop dpShop);

	Map findByShopId(DpShop dpShop);


	void updateReviewStatus(Map dpShopReview);
}