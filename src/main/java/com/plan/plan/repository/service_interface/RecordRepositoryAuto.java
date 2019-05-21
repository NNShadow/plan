package com.plan.plan.repository.service_interface;

import com.plan.plan.model.AccountingRecord;
import org.springframework.data.repository.CrudRepository;

//数据访问层接口
public interface RecordRepositoryAuto extends CrudRepository<AccountingRecord, Integer> {
}
