package cc.mrbird.shop.service.impl;

import cc.mrbird.merchant.dao.DpShopMapper;
import cc.mrbird.shop.dao.DpOfferReviewMapper;
import cc.mrbird.shop.domain.DpOfferReview;
import cc.mrbird.shop.service.DpOfferReviewService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Yxy
 * @date 2018/9/6 10:44
 */
@Service("dpOfferReviewService")
public class DpOfferReviewServiceImpl implements DpOfferReviewService {

    @Autowired
    private DpOfferReviewMapper dpOfferReviewMapper;

    @Autowired
    private DpShopMapper dpShopMapper;

    /**
     * 插入优惠券审核的数据
     * @param dpOfferReview
     */
    @Override
    public void insert(DpOfferReview dpOfferReview) {
        dpOfferReview.setCreated(new Date());
        dpOfferReview.setStatus(1);
        this.dpOfferReviewMapper.insert(dpOfferReview);
    }

    /**
     * 根据条件查询优惠券信息
     * @param dpOfferReview
     * @return
     */
    @Override
    public List<Map> findByDpOfferReview(DpOfferReview dpOfferReview) {
        return this.dpOfferReviewMapper.findByDpOfferReview(dpOfferReview);
    }

    /**
     * 根据id查询优惠券信息
     * @param id
     * @return
     */
    @Override
    public DpOfferReview findById(Integer id) {
        return this.dpOfferReviewMapper.findById(id);
    }

    /**
     * 修改优惠券的审核状态
     * @param dpOfferReview
     */
    @Override
    @Transactional
    public void updateStatus(DpOfferReview dpOfferReview) {
        dpOfferReview.setReviewTime(new Date());
        this.dpOfferReviewMapper.updateStatus(dpOfferReview);
        if (dpOfferReview.getStatus()==2){
            DpOfferReview offerReview = this.dpOfferReviewMapper.findById(dpOfferReview.getId());
            this.dpShopMapper.updateOfferInfo(offerReview);
        }
    }
}
