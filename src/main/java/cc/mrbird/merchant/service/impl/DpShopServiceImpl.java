package cc.mrbird.merchant.service.impl;

import cc.mrbird.merchant.dao.DpShopMapper;
import cc.mrbird.merchant.domain.DpShop;
import cc.mrbird.merchant.service.DpShopService;
import cc.mrbird.shop.domain.DpOfferReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Yxy
 * @date 2018/9/6 11:31
 */
@Service("dpShopService")
public class DpShopServiceImpl implements DpShopService {

    @Autowired
    private DpShopMapper dpShopMapper;



}
