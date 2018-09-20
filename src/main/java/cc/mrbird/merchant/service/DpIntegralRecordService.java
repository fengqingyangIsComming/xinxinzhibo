package cc.mrbird.merchant.service;

import cc.mrbird.merchant.domain.DpIntegralRecord;

import java.util.List;
import java.util.Map;

public interface DpIntegralRecordService {

    void insert(DpIntegralRecord record);

    List<Map> findByIntegralRecord(Map map);

    List<Map> findByIntegralList(String startTime, String endTime);
}
