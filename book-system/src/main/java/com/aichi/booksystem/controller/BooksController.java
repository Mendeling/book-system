package com.aichi.booksystem.controller;

import com.aichi.booksystem.bean.Books;
import com.aichi.booksystem.bean.Readers;
import com.aichi.booksystem.mapper.BooksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BooksController {

    @Autowired
    BooksMapper booksMapper;

    //插入书籍信息
    @PostMapping("/books/insert")
    public Map<String, Object> insertBook(Books books){
        Map map = new HashMap();
        try{
            booksMapper.insertBook(books);
            map.put("msg", "插入成功！");
            map.put("data", books);
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "插入失败！");
        }
        return map;
    }
}
