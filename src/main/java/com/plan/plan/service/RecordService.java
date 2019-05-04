package com.plan.plan.service;

import com.plan.plan.model.AccountingRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


//数据访问层接口
public interface RecordService extends CrudRepository<AccountingRecord, Integer> {
    //记录数据
//    public void record(AccountingRecord recording);
    //查询数据
//    public List<AccountingRecord> ();
}
