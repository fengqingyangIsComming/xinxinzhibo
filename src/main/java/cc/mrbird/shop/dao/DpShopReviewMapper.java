package cc.mrbird.shop.dao;


import cc.mrbird.shop.domain.DpShopReview;

import java.util.List;
import java.util.Map;

public interface DpShopReviewMapper {


    void insert(DpShopReview dpShopReview);

    List<Map> findByDpShopReview(DpShopReview dpShopReview);

    Map findById( DpShopReview dpShopReview);

    void updateStatus(DpShopReview dpShopReview);

    Map findByShopId(DpShopReview dpShopReview);



    Integer findByTypeName(String typeName);


    Map findShopInfoByUseridx(String useridx);

    DpShopReview findInfoById(DpShopReview dpShopReview);
}