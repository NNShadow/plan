package com.plan.plan.service;

import com.plan.plan.model.AccountingRead;
import org.springframework.data.repository.CrudRepository;

//数据访问层接口
public interface RecordRead extends CrudRepository<AccountingRead, Integer> {

}
