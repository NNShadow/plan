package com.plan.plan.model;

import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
// 用于标记持久化类,Spring Boot项目加载后会自动根据持久化类建表
@Table(name = "record")
public class AccountingRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //金额 主键
    private double cash;
    //收入 支出
    private String type;
    //详细信息
    private String category;
    //修改时间
    private Date modifyTime;
    //产生时间
    private String createTime;

    public double getCash() {
        return cash;
    }

    public void setCash(@RequestParam("cash") double cash) {
        this.cash = cash;
    }

    public String getType() {
        return type;
    }

    public void setType(@RequestParam("type") String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(@RequestParam("category") String category) {
        this.category = category;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(@RequestParam("createTime") String createTime) {
        this.createTime = createTime;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
