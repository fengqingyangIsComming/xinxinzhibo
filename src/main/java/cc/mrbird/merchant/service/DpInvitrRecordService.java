package cc.mrbird.merchant.service;

import cc.mrbird.merchant.domain.DpInvitrRecord;

import java.util.List;
import java.util.Map;

public interface DpInvitrRecordService {
    void insert(DpInvitrRecord dpInvitrRecord);


    List<Map> findByUserIdx(DpInvitrRecord dpInvitrRecord);

    List<Map> findByRecord(DpInvitrRecord dpInvitrRecord);
}
