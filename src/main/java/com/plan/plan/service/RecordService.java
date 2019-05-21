package com.plan.plan.service;

import com.plan.plan.model.AccountingRecord;
import com.plan.plan.repository.RecordRepository;
import com.plan.plan.repository.service_interface.RecordRepositoryAuto;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RecordService {
    @Resource
    private RecordRepositoryAuto recordRepositoryAuto;
    private RecordRepository recordRepository;
    /**
     * save、update、delete方法需要绑定事务. 使用@Transactional进行事务的绑定
     *
     * 保存对象
     * @param accountingRecord
     * @return 包含自动生成的id的User对象
     */
    @Transactional
    public AccountingRecord save(AccountingRecord accountingRecord){
        return recordRepositoryAuto.save(accountingRecord);
    }
    @Transactional
    public void delete(int id){
        recordRepositoryAuto.deleteById(id);
    }

    //查询所有数据
    public Iterable<AccountingRecord> getAll(){
        return recordRepositoryAuto.findAll();
    }

    //根据id查询数据
    public AccountingRecord getById(Integer id){
        Optional<AccountingRecord> op = recordRepositoryAuto.findById(id);
        return op.get();
    }

    //修改对象数据，持久化对象修改会自动更新到数据库
    @Transactional
    public void update(AccountingRecord accountingRead){
        //调用持久化对象的set方法修改对象的数据
    }

    /**RecordRepository
     *
     */
    public List<AccountingRecord> search(){
        return recordRepository.search();
    }

    public List<AccountingRecord> findAll(){
        return recordRepository.findAll();
    }
}
