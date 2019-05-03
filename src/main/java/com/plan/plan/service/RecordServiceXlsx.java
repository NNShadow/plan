package com.plan.plan.service;

import com.plan.plan.model.AccountingRecord;

import java.util.List;

//不使用
public interface RecordServiceXlsx {
    //记录数据
    public void record(AccountingRecord record);
    //查询数据
    public List<AccountingRecord> details();
}
