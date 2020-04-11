package com.aichi.booksystem.mapper;

import com.aichi.booksystem.bean.Readers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;


//@Mapper或者@MapperScan将接口扫描装配到容器中
@Mapper
@Repository
public interface ReadersMapper {

    //插入读者信息
    public void insertReader(Readers readers);

    //根据读者编号修改读者信息
    public void setReaderById(Integer id, String name, String gender);

    //根据读者编号查询读者
    public Readers getReaderById(Integer id);

    //查询所有读者
    public List<Readers> getReaders();


}
