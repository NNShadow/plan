package com.plan.plan.api;

import com.plan.plan.model.AccountingRecord;
import com.plan.plan.repository.service_interface.RecordRepositoryCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/use")
public class usetest {
    private static final String MAX_LONG_AS_STRING="9223372036854775807";
    private RecordRepositoryCrud recordRepositoryCrud;

    @Autowired
    public usetest(RecordRepositoryCrud recordRepositoryCrud){
        this.recordRepositoryCrud = recordRepositoryCrud;
    }

    @RequestMapping(value = "/uu", method = RequestMethod.GET)
    public List<AccountingRecord> accountingRecords(){
    }
}
