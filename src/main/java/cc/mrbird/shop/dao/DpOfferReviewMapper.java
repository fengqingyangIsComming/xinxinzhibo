package cc.mrbird.shop.dao;


import cc.mrbird.shop.domain.DpOfferReview;

import java.util.List;
import java.util.Map;

public interface DpOfferReviewMapper {

    void insert(DpOfferReview dpOfferReview);


    List<Map> findByDpOfferReview(DpOfferReview dpOfferReview);

    DpOfferReview findById(Integer id);

    void updateStatus(DpOfferReview dpOfferReview);


}