package com.aichi.booksystem.controller;

import com.aichi.booksystem.bean.BorrowRecords;
import com.aichi.booksystem.mapper.BooksMapper;
import com.aichi.booksystem.mapper.BorrowRecordsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    //根据读者编号分页查询借书记录
    @GetMapping("/getBorrowById")
    public Map<String, Object> getBorrowById(@RequestParam("id") Integer id, @RequestParam("page") Integer page){
        Map map = new HashMap();
        try {
            map.put("msg","查询成功！");
            map.put("BorrowRecords", borrowRecordsMapper.getBorrowById(id,page, borrowRecordsMapper.getBorrowCountById(id)));
            map.put("total", borrowRecordsMapper.getBorrowCountById(id));
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "查询失败！");
        }

        return map;
    }

    //还书
    @PutMapping("/returnBooks")
    public Map<String, Object> returnBooks(@RequestParam("borrowId") Integer borrowId){
        Map map = new HashMap();
        try {
            if(borrowRecordsMapper.getBorrow(borrowId).getReturnDate() == null) {
                borrowRecordsMapper.returnBooks(borrowId);
                borrowRecordsMapper.addBooks(borrowRecordsMapper.getBorrowIdByBooksId(borrowId));
                map.put("msg", "还书成功！");
            }
            else {
                map.put("msg", "请勿重复还书！");
            }
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "还书失败！");
        }

        return map;
    }

}
