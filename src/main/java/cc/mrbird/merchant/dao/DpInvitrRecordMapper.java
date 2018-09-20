package cc.mrbird.merchant.dao;


import cc.mrbird.merchant.domain.DpInvitrRecord;

import java.util.List;
import java.util.Map;

public interface DpInvitrRecordMapper {

    void insert(DpInvitrRecord dpInvitrRecord);

    List<Map> findByUserIdx(DpInvitrRecord dpInvitrRecord);

    DpInvitrRecord findInvitee(DpInvitrRecord dpInvitrRecord);



    List<Map> findByRecord(DpInvitrRecord dpInvitrRecord);
 }