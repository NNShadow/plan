package com.plan.plan.control;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.plan.plan.model.AccountingRead;
import com.plan.plan.model.AccountingRecord;
import com.plan.plan.service.impl.RecordServiceImpl;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class AccountingController {

    @Resource
    private RecordServiceImpl userService;
    private static List<AccountingRecord> records = new ArrayList<>();

    //记录数据
    @RequestMapping(value = "/record")
    public String record(AccountingRecord user){
        Date time = new Date();
        user.setModifyTime(time);
        user.setDisplay(1);

        userService.save(user);
        return "recordReturn";
    }

    //查询所有数据
    @RequestMapping(value = "/search")
    @ResponseBody
    public String search(){
        String json = userService.getAll().toString();
        JSONObject jsonObject = new JSONObject(json);
        ArrayList<AccountingRead> records = new ArrayList<>();
        AccountingRead record = new AccountingRead();
        record.setId(jsonObject.getLong("id"));
        record.setModifyTime(jsonObject.getString("modifyTime"));
        record.setCreateTime(jsonObject.getString("createTime"));
        record.setType(jsonObject.getString("type"));
        record.setCategory(jsonObject.getString("category"));
        record.setCash(jsonObject.getDouble("cash"));
        record.setDisplay(jsonObject.getInt("display"));

//        List<AccountingRecord> filter = records.stream().filter(record -> record.getCash() > 0)
//                .collect(Collectors.toList());
//
//        StringBuffer sb = new StringBuffer();
//        sb.append("清单：</br>");
//        for (AccountingRecord item : filter){
//            sb.append("记录时间：" + item.getModifyTime() + "</br>"
//                    + "发生时间：" + item.getCreateTime() + "</br>"
//                    + "收支类型：" + item.getType() + "</br>"
//                    + "收支详情：" + item.getCategory() + "</br>"
//                    + "收支金额：" + item.getCash() + "</br></br>");
//        }
//        return sb.toString();
    }

//    正则匹配String
    public boolean check(String str, String regEx){
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
