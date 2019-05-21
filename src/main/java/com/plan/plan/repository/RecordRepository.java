package com.plan.plan.repository;

import com.plan.plan.model.AccountingRecord;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
//持久化操作对象
public class RecordRepository {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public List<AccountingRecord> search(){
        String sql = "select * from record where display = 1";
        //声明结果集的映射rowMapper，将结果集的数据映射成User对象数据
        RowMapper<AccountingRecord> readRowMapper = new BeanPropertyRowMapper<>(AccountingRecord.class);
        return jdbcTemplate.query(sql, readRowMapper);
    }

    //根据收支类型（收入）查询数据
    public AccountingRecord selectByType(String type) {
        // 定义SQL语句
        String sql = "select * from record where type = '收入'";
        // 定义一个RowMapper
        RowMapper<AccountingRecord> rowMapper = new BeanPropertyRowMapper<>(AccountingRecord.class);
        // 执行查询方法
        AccountingRecord accountingRecord = jdbcTemplate.queryForObject(sql, new Object[] { type }, rowMapper);
        return accountingRecord;
    }

    /***
     * 根据id查询数据
     * @return User对象
     */
    public AccountingRecord findUserById(int id) {
        // 定义SQL语句
        String sql = "select * from record where id=?";
        RowMapper<AccountingRecord> rowMapper = new BeanPropertyRowMapper<>(AccountingRecord.class);
        // 执行查询方法
        return jdbcTemplate.queryForObject(sql, new Object[] { id }, rowMapper);
    }

    /***
     * 查询所有数据
     * @return 包含User对象的List集合
     */
    public List<AccountingRecord> findAll() {
        // 定义SQL语句
        String sql = "select * from record";
        // 申明结果集的映射rowMapper，将结果集的数据映射成User对象数据
        RowMapper<AccountingRecord> rowMapper = new BeanPropertyRowMapper<>(AccountingRecord.class);
        return jdbcTemplate.query(sql, rowMapper);
    }

    /***
     * 根据id删除数据
     */
    public void delete(final Integer id) {
        // 定义SQL语句
        String sql = "delete from record where id=?";
        // 执行
        jdbcTemplate.update(sql, new Object[] { id });
    }

    /***
     * 修改数据
     * 看看例子就好，懒的实现了
     */
//    public void update(final AccountingRecord accountingRecord) {
//        // 定义SQL语句
//        String sql = "update tb_user set username=?, login_name=? where id=?";
//        // 执行
//        jdbcTemplate.update(sql,
//                new Object[] { accountingRecord., AccountingRecord.getLoginName(), AccountingRecord.getId()});
//    }
}
