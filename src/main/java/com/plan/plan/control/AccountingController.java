package com.plan.plan.control;

import com.plan.plan.model.AccountingRecord;
import com.plan.plan.repository.service_interface.RecordRepositoryPageAndSort;
import com.plan.plan.service.RecordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.java2d.pipe.AAShapePipe;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class AccountingController {

    @Resource
    private RecordService userService;
    @Resource
    private RecordRepositoryPageAndSort recordRepositoryPageAndSort;

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
    @RequestMapping(value = "/searchAll")
    @ResponseBody
    public Iterable<AccountingRecord> getAll(){
        return userService.getAll();
//        List<AccountingRecord> filter = records.stream().filter(record -> record.getDisplay() == 1)
//                .collect(Collectors.toList());

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

    @RequestMapping(value = "/searchNormal")
    @ResponseBody
    public List<AccountingRecord> search(){
        return userService.search();
    }

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public List<AccountingRecord> findAll(){
        return userService.findAll();
    }

    //排序
    @RequestMapping(value = "/sort")
    @ResponseBody
    public Iterable<AccountingRecord> sortRecord(){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Iterable<AccountingRecord> recordDatas = recordRepositoryPageAndSort.findAll(sort);
        return recordDatas;
    }

    //分页
    @RequestMapping(value = "/pager")
    @ResponseBody
    public List<AccountingRecord> sortPagerArticle(int pageIndex){
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable page = PageRequest.of(pageIndex - 1, 2, sort);

        Page<AccountingRecord> recordDatas = recordRepositoryPageAndSort.findAll(page);
        System.out.println("查询总页数:" + recordDatas.getTotalPages());
        System.out.println("查询总记录数:" + recordDatas.getTotalElements());
        System.out.println("查询当前第几页:" + recordDatas.getNumber() + 1);
        System.out.println("查询当前页面的记录数:" + recordDatas.getNumberOfElements());
        // 查询出的结果数据集合
        List<AccountingRecord> accountingRecords = recordDatas.getContent();
        System.out.println("查询当前页面的集合:" + accountingRecords);
        return accountingRecords;
    }

//    正则匹配String
    public boolean check(String str, String regEx){
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
