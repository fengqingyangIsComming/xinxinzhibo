package cc.mrbird.shop.service.impl;

import cc.mrbird.common.util.CodeUtil;
import cc.mrbird.common.util.GaoDeiUtils;
import cc.mrbird.merchant.dao.DpInvitrRecordMapper;
import cc.mrbird.merchant.dao.DpShopMapper;
import cc.mrbird.merchant.dao.DpShopUserMapper;
import cc.mrbird.merchant.domain.DpInvitrRecord;
import cc.mrbird.merchant.domain.DpShop;
import cc.mrbird.shop.dao.DpShopReviewMapper;
import cc.mrbird.shop.domain.DpShopReview;
import cc.mrbird.shop.service.DpShopReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Yxy
 * @date 2018/9/6 17:08
 */
@Service("dpShopReviewService")
public class DpShopReviewServiceImpl implements DpShopReviewService {

    @Autowired
    private DpShopMapper dpShopMapper;

    @Autowired
    private DpShopUserMapper dpShopUserMapper;

    @Autowired
    private DpInvitrRecordMapper dpInvitrRecordMapper;

    @Autowired
    private DpShopReviewMapper dpShopReviewMapper;

    /**
     * 插入要修改的商家审核信息
     * @param dpShopReview
     */
    @Override
    public void insert(DpShopReview dpShopReview) {
        this.dpShopReviewMapper.insert(dpShopReview);
    }

    /**
     * 根据条件查询修改注册的商家信息
     * @param dpShopReview
     * @return
     */
    @Override
    public List<Map> findByDpShopReview(DpShopReview dpShopReview) {
        return this.dpShopReviewMapper.findByDpShopReview(dpShopReview);
    }

    /**
     * 根据id查询商家修改的信息
     * @param dpShopReview
     * @return
     */
    @Override
    public Map findById( DpShopReview dpShopReview) {
        return this.dpShopReviewMapper.findById(dpShopReview);
    }


    /**
     * 根据shopId查询商家审核表信息
     * @param dpShopReview
     * @return
     */
    @Override
    public Map findByShopId(DpShopReview dpShopReview) {

        return this.dpShopReviewMapper.findByShopId(dpShopReview);
    }

    @Override
    public Integer findByTypeName(String typeName) {
        return this.dpShopReviewMapper.findByTypeName(typeName);
    }

    @Override
    public Map findShopInfoByUseridx(String useridx) {
        return dpShopReviewMapper.findShopInfoByUseridx(useridx);
    }


    //修改状态
    @Override
    @Transactional
    public void updateStatus(DpShopReview dpShopReview,Long useridx) {
        this.dpShopReviewMapper.updateStatus(dpShopReview);

        dpShopReview.setReviewTime(new Date());
        //DpShopReview shopReview = this.dpShopReviewMapper.findInfoById(dpShopReview);

        Map map = new HashMap();
        map.put("shopId",dpShopReview.getShopId());
        map.put("name",dpShopReview.getName());
        map.put("username",dpShopReview.getUsername());
        map.put("typeId",dpShopReview.getTypeId());
        map.put("phone",dpShopReview.getPhone());
        map.put("telephone",dpShopReview.getTelephone());
        map.put("email",dpShopReview.getEmail());
        map.put("country",dpShopReview.getCountry());
        map.put("pCDistrict",dpShopReview.getpCDistrict());
        map.put("address",dpShopReview.getAddress());
        map.put("registrationNumber",dpShopReview.getRegistrationNumber());
        map.put("status",dpShopReview.getStatus());
        map.put("businessProof",dpShopReview.getBusinessProof());
        map.put("storeImage",dpShopReview.getStoreImage());
        map.put("images",dpShopReview.getImages());
        map.put("invitedCode",dpShopReview.getInvitedCode());

        GaoDeiUtils gaoDeiUtils=new GaoDeiUtils();
        double [] data = gaoDeiUtils.addressToGPS(dpShopReview.getCountry()+dpShopReview.getpCDistrict());
        if(data==null){
            map.put("jingdu","120.075097");
            map.put("weidu","30.293039");
        }else{
            map.put("jingdu",""+data[0]);
            map.put("weidu",""+data[1]);
        }

        this.dpShopReviewMapper.updateStatus(dpShopReview);

        this.dpShopMapper.updateReviewStatus(map);

        this.dpShopUserMapper.updateReviewStatus(map);

        DpInvitrRecord dpInvitrRecord = new DpInvitrRecord();
        Long idByCode = CodeUtil.getIdByCode(dpShopReview.getInvitedCode());
        dpInvitrRecord.setInviter(idByCode);
        dpInvitrRecord.setInvitee(useridx);
        dpInvitrRecord.setCreatTime(new Date());

        DpInvitrRecord record =this.dpInvitrRecordMapper.findInvitee(dpInvitrRecord);
        if (record==null){
            this.dpInvitrRecordMapper.insert(dpInvitrRecord);
        }
    }

}
