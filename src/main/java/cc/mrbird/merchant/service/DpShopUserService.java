package cc.mrbird.merchant.service;

import cc.mrbird.merchant.domain.DpShopUser;

import java.util.List;
import java.util.Map;

public interface DpShopUserService {

    void updateStatusByUserIdx(DpShopUser dpShopUser);

    DpShopUser findByShopUserId(DpShopUser  dpShopUser);

    List<Map> findByInvitedCode(DpShopUser dpShopUser);

    List<Map> findByUseridxs(DpShopUser dpShopUser);
}
