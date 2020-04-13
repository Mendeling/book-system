package com.aichi.booksystem.controller;

import com.aichi.booksystem.bean.BorrowRecords;
import com.aichi.booksystem.mapper.BorrowRecordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BorrowRecordsController {

    @Autowired
    BorrowRecordsMapper borrowRecordsMapper;

    //借书
    @PostMapping("/borrowBooks")
    public Map<String, Object> borrowBooks(BorrowRecords borrowRecords){
        Map map = new HashMap();
        try {
            if(borrowRecordsMapper.getBorrowCount(borrowRecords.getId()) > 2){
                map.put("msg", "借书额度到达上限3本，请先归还书籍！");
            }
            else if(borrowRecordsMapper.getbCount(borrowRecords.getBId()) > 0){
                borrowRecordsMapper.borrowBooks(borrowRecords);
                borrowRecordsMapper.setBooksCount(borrowRecords.getBId());
                map.put("msg", "借书成功！");
                map.put("borrowRecords", borrowRecords);
            }
            else {
                map.put("msg","库存不足，借书失败！");
            }
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "借书失败！");
        }

        return map;
    }

    //还书
    @PutMapping("/returnBooks")
    public Map<String, Object> returnBooks(@RequestParam("borrowId") Integer borrowId){
        Map map = new HashMap();
        try {
            borrowRecordsMapper.returnBooks(borrowId);
            map.put("msg", "还书成功！");
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "还书失败！");
        }

        return map;
    }
}
