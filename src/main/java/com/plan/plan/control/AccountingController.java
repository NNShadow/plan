package com.plan.plan.control;

import com.plan.plan.model.AccountingRecord;
import com.plan.plan.service.impl.RecordServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.Date;

@Controller
public class AccountingController {
//    private static List<AccountingRecord> records = new ArrayList<>();

    @Resource
    private RecordServiceImpl userService;

    //记录数据
    @RequestMapping(value = "/record")
    public String record(AccountingRecord user){
        Date time = new Date();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
//        String usertime = simpleDateFormat.format(time);
        user.setModifyTime(time);
        userService.save(user);
        return "保存成功";
    }

//    //返回记录
//    @ResponseBody
//    @RequestMapping(value = "/details")
//    public List<AccountingRecord> details(){
//        return recordService.details();
//    }

}
