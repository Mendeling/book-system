package com.aichi.booksystem.controller;

import com.aichi.booksystem.bean.Books;
import com.aichi.booksystem.bean.Readers;
import com.aichi.booksystem.mapper.BooksMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    //查询所有书籍信息
    @GetMapping("/books/findAll")
    public Map<String, Object> getBooks(){
        Map map = new HashMap();
        try{

            map.put("msg", "查询成功！");
            map.put("data", booksMapper.getBooks());
        } catch (Exception e) {
            map.put("msg", "查询失败！");
        }
        return map;
    }

    //根据书名模糊查询
    @GetMapping("/books/findByName")
    public Map<String, Object> getBooksByName(@RequestParam("bName") String bName){
        Map map = new HashMap();
        try{

            map.put("msg", "查询成功！");
            map.put("data", booksMapper.getBooksByName(bName));
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "查询失败！");
        }
        return map;
    }

    //根据作者模糊查询
    @GetMapping("/books/findByAuthor")
    public Map<String, Object> getBooksByAuthor(@RequestParam("author") String author){
        Map map = new HashMap();
        try{

            map.put("msg", "查询成功！");
            map.put("data", booksMapper.getBooksByAuthor(author));
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "查询失败！");
        }
        return map;
    }
}
