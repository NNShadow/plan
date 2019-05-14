package com.plan.plan.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.plan.plan.model.AccountingRecord;
import com.plan.plan.service.RecordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class RecordServiceImpl {
    //注入UserRepository
    @Resource
    private RecordService recordService;
    /**
     * save、update、delete方法需要绑定事务. 使用@Transactional进行事务的绑定
     *
     * 保存对象
     * @param accountingRecord
     * @return 包含自动生成的id的User对象
     */
    @Transactional
    public AccountingRecord save(AccountingRecord accountingRecord){
        return recordService.save(accountingRecord);
    }
    @Transactional
    public void delete(int id){
        recordService.deleteById(id);
    }

    //查询所有数据
    public Iterable<AccountingRecord> getAll(){
        return recordService.findAll();
    }

    //根据id查询数据
    public AccountingRecord getById(Integer id){
        Optional<AccountingRecord> op = recordService.findById(id);
        return op.get();
    }

    //修改对象数据，持久化对象修改会自动更新到数据库
    @Transactional
    public void update(AccountingRecord accountingRead){
        //调用持久化对象的set方法修改对象的数据
    }
}
