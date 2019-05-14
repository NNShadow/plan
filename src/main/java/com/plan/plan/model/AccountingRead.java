package com.plan.plan.model;

import java.util.ArrayList;
import java.util.Date;

public class AccountingRead {
    //主键
    private long id;
    //金额
    private double cash;
    //收入 支出
    private String type;
    //详细信息
    private String category;
    //修改时间
    private String modifyTime;
    //产生时间
    private String createTime;
    //是否显示
    private int display;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getDisplay() {
        return display;
    }

    public void setDisplay(int display) {
        this.display = display;
    }
}
