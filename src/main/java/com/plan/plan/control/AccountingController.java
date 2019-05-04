package com.plan.plan.control;

import com.plan.plan.model.AccountingRecord;
import com.plan.plan.service.impl.RecordServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class AccountingController {
//    private static List<AccountingRecord> records = new ArrayList<>();

    @Resource
    private RecordServiceImpl userService;

    //记录数据
    @RequestMapping(value = "/record")
    public String record(AccountingRecord user){
        Date time = new Date();
        user.setModifyTime(time);
        user.setDisplay(1);

        //以下信息可以前端写，忘了，懒的改了

        //验证金额
        if(!check(user.getCash() + "",  "^(\\d+)(\\.\\d{1,2})?$")){
            System.out.println("金额输入错误");
            return "error/recordError";
        }

        //验证详细信息
        //double类型无法存储字符串，可以重写400页面
        if(check(user.getCategory(), "^(\\s+)?$")){
            System.out.println("缺少内容");
            return "error/recordError";
        }
        //验证产生时间
        if(!check(user.getCreateTime(), "^(\\d{4})(-)(\\d{2})(-)(\\d{2})$")){
            System.out.println("日期输入错误");
            return "error/recordError";
        }

        userService.save(user);
        return "recordReturn";
    }

//    //返回记录
//    @ResponseBody
//    @RequestMapping(value = "/details")
//    public List<AccountingRecord> details(){
//        return recordService.details();
//    }

    public boolean check(String str, String regEx){
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
