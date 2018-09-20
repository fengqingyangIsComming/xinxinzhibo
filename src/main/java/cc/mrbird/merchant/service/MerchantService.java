package cc.mrbird.merchant.service;
import cc.mrbird.merchant.domain.DpOrder;
import cc.mrbird.merchant.domain.DpShop;
import cc.mrbird.merchant.domain.DpShopUser;
import cc.mrbird.shop.domain.DpShopReview;

import java.util.List;
import java.util.Map;

public interface MerchantService {

    void merchantRegist(DpShop dpShop, DpShopUser dpShopUser);

    List<Map> findByMerchant(DpShop dpShop ,DpShopUser dpShopUser);

    Map<String,Object> findByMerchantID(DpShopUser dpShopUser);

    List<Map> findByChart(DpShop dpShop, DpOrder dpOrder);

	List<DpShop> findChartWithOrder(DpShop dpShop);

    void updateDpShopReviewStatus(DpShop dpShop, DpShopUser dpShopUser, DpShopReview dpShopReview);

    void updateOtherInfo(DpShop dpShop, DpShopUser dpShopUser);

    Map findByShopId(DpShop dpShop);
}
