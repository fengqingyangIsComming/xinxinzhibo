package cc.mrbird.merchant.dao;


import cc.mrbird.merchant.domain.DpShopUser;
import cc.mrbird.shop.domain.DpShopReview;

import java.util.List;
import java.util.Map;

public interface DpShopUserMapper {

    void insert(DpShopUser dpShopUser);

    void updateStatusByUserIdx(DpShopUser dpShopUser);

    DpShopUser findByShopUserId(DpShopUser  dpShopUser);

    DpShopUser findByUseridx(DpShopUser dpShopUser);


    List<Map> findByInvitedCode(DpShopUser dpShopUser);

    void updateByDpShopUser(DpShopUser dpShopUser);

    void updateShopUserOtherInfo(DpShopUser dpShopUser);


    List<Map> findByUseridxs(DpShopUser dpShopUser);

    void updateReviewStatus(Map dpShopReview);
}