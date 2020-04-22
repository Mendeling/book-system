package com.aichi.booksystem.controller;

import com.aichi.booksystem.bean.Readers;
import com.aichi.booksystem.mapper.ReadersMapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ReadersController {

    //自动注入
    @Autowired
    ReadersMapper readersMapper;

    //读者登录
    @PostMapping("/readers/login")
    public Map<String, Object> readerLogin(Readers readers){
        Map map = new HashMap();
        try {
            if (readersMapper.getReaderById(readers.getId()) != null) {
                String readerName = readersMapper.getReaderById(readers.getId()).getName();
                if (readerName.equals(readers.getName())) {
                    map.put("msg", "登录成功！");
                    map.put("reader", readersMapper.getReaderById(readers.getId()));
                }
                else {
                    map.put("msg", "登录失败，姓名与读者编号不符!");
                }
            }
            else {
                map.put("msg", "登录失败，姓名与读者编号不符或不存在读者信息！");
            }
        } catch (Exception e) {
            System.out.println(e);
            map.put("msg", "操作失败！登录失败！");
        }
        return map;
    }

    //插入读者信息
    @PostMapping("/readers/insert")
    public Map<String, Object> insertReader(Readers readers){
        Map map = new HashMap();
        try{
            readersMapper.insertReader(readers);
            map.put("msg", "插入成功！");
            map.put("data", readers);
        } catch (Exception e) {
            map.put("msg", "插入失败！");
        }
        return map;
    }

    //根据读者编号修改读者信息
    @PutMapping("/readers/updateById")
    public Map<String, Object> setReaderById(@RequestParam("id") Integer id, @RequestParam("name") String name, @RequestParam("gender") String gender){
        Map map = new HashMap();
        try{
            readersMapper.setReaderById(id, name, gender);
            map.put("msg", "修改成功！");
        } catch (Exception e) {
            map.put("msg", "修改失败！");
        }
        return map;
    }

    //根据读者编号查询读者信息
    @GetMapping("/readers/findById")
    public Map<String, Object> getReaderById(@RequestParam("id") Integer id){
        Map map = new HashMap();
        try{
            map.put("msg", "查询成功！");
            map.put("data", readersMapper.getReaderById(id));
        } catch (Exception e) {
            map.put("msg","查询失败！");
        }
        return map;
    }

    //查询所有读者信息
    @GetMapping("/readers/findAll")
    public Map<String, Object> getReaders(){
        Map map = new HashMap();
        try{
            map.put("msg", "查询成功！");
            map.put("data", readersMapper.getReaders());
        } catch (Exception e) {
            map.put("msg","查询失败！");
        }
        return map;
    }

}
