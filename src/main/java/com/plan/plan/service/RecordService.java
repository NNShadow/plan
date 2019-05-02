package com.plan.plan.service;

import com.plan.plan.model.AccountingRecord;

import java.util.List;

public interface RecordService {
    //记录数据
    public void record(AccountingRecord record);
    //查询数据
    public List<AccountingRecord> details();
}
