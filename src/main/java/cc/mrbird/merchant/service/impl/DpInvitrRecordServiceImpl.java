package cc.mrbird.merchant.service.impl;

import cc.mrbird.merchant.dao.DpInvitrRecordMapper;
import cc.mrbird.merchant.domain.DpIntegralRecord;
import cc.mrbird.merchant.domain.DpInvitrRecord;
import cc.mrbird.merchant.service.DpIntegralRecordService;
import cc.mrbird.merchant.service.DpInvitrRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Yxy
 * @date 2018/9/7 20:46
 */
@Service("dpInvitrRecordService")
public class DpInvitrRecordServiceImpl implements DpInvitrRecordService {

    @Autowired
    private DpInvitrRecordMapper dpInvitrRecordMapper;

    @Override
    public void insert(DpInvitrRecord dpInvitrRecord) {
        this.dpInvitrRecordMapper.insert(dpInvitrRecord);
    }


    /**
     * 查询该用户的邀请记录
     * @param dpInvitrRecord
     * @return
     */
    @Override
    public List<Map> findByUserIdx(DpInvitrRecord dpInvitrRecord) {
        return this.dpInvitrRecordMapper.findByUserIdx(dpInvitrRecord);
    }

    @Override
    public List<Map> findByRecord(DpInvitrRecord dpInvitrRecord) {
        return this.dpInvitrRecordMapper.findByRecord(dpInvitrRecord);
    }
}
