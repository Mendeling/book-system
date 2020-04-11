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
