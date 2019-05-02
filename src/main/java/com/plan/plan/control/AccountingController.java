package com.plan.plan.control;

import com.plan.plan.model.AccountingRecord;
import com.plan.plan.service.RecordService;
import com.plan.plan.service.impl.RecordServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class AccountingController {
    private static List<AccountingRecord> records = new ArrayList<>();
    private static RecordService recordService = new RecordServiceImpl();

    //记录数据
    @RequestMapping(value = "/record")
    public String record(AccountingRecord accountingRecord){
        Date time = new Date();
        accountingRecord.setModifyTime(time);
        recordService.record(accountingRecord);
        return "recordReturn";
    }

    //返回记录
    @ResponseBody
    @RequestMapping(value = "/details")
    public List<AccountingRecord> details(){
        return recordService.details();
    }

}
