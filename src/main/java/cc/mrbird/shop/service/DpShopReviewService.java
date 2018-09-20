package cc.mrbird.shop.service;

import cc.mrbird.shop.domain.DpShopReview;

import java.util.List;
import java.util.Map;

public interface DpShopReviewService {

    void insert(DpShopReview dpShopReview);

    List<Map> findByDpShopReview(DpShopReview dpShopReview);

    Map findById(DpShopReview dpShopReview);

    Map findByShopId(DpShopReview dpShopReview);


    Integer findByTypeName(String typeName);

    Map findShopInfoByUseridx(String useridx);


    void updateStatus(DpShopReview dpShopReview,Long useridx);
}
