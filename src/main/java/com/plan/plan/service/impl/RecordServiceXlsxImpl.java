package com.plan.plan.service.impl;

import com.plan.plan.model.AccountingRecord;
import com.plan.plan.service.RecordServiceXlsx;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//不使用
public class RecordServiceXlsxImpl implements RecordServiceXlsx {
    public void record(AccountingRecord record){
        File file = new File("./record.xlsx");
        Workbook wb = null;
        Sheet sheet = null;
        if(file.exists()){
            try {
                wb = new XSSFWorkbook(file);
                sheet = wb.getSheetAt(0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            wb = new XSSFWorkbook();
            sheet = wb.createSheet();
        }
        try {
            int rows = sheet.getPhysicalNumberOfRows();
            Row row = sheet.createRow(rows);
            //把记账时间 记录在第一列上
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
            String time = simpleDateFormat.format(record.getModifyTime());
            //把记账时间 记录在第二列上
            row.createCell(0).setCellValue(record.getCreateTime());
            row.createCell(1).setCellValue(time);
            row.createCell(2).setCellValue(record.getType());
            row.createCell(3).setCellValue(record.getCategory());
            row.createCell(4).setCellValue(record.getCash());

            //创建临时文件
            File newFile = new File(file + ".bak");
            OutputStream out = new FileOutputStream(newFile);
            wb.write(out);
            wb.close();
            out.close();
            //删除老的文件
            file.deleteOnExit();
            //把新的文件更名为老的文件名
            newFile.renameTo(file);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public List<AccountingRecord> details() {
        File file = new File("./record.xlsx");
        List<AccountingRecord> records = new ArrayList<>();
        if(!file.exists()){
            return records;
        }
        try{
            Workbook wb = new XSSFWorkbook(file);
            Sheet sheet = wb.getSheetAt(0);
            int rows = sheet.getPhysicalNumberOfRows();
            for(int i=0;i<rows;i++){
                Row row = sheet.getRow(i);
                AccountingRecord record = new AccountingRecord();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                Date time = simpleDateFormat.parse(row.getCell(1).getStringCellValue());
                record.setCreateTime(row.getCell(0).getStringCellValue());
                record.setModifyTime(time);
                record.setType(row.getCell(2).getStringCellValue());
                record.setCategory(row.getCell(3).getStringCellValue());
                record.setCash(row.getCell(4).getNumericCellValue());
                records.add(record);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return records;
    }
}
