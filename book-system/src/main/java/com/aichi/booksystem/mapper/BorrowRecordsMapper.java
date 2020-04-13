package com.aichi.booksystem.mapper;

import com.aichi.booksystem.bean.BorrowRecords;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BorrowRecordsMapper {

    //建立借书记录
    public void borrowBooks(BorrowRecords borrowRecords);

    //根据图书编号查看库存
    public Integer getbCount(Integer bId);

    //查询借书未还次数
    public Integer getBorrowCount(Integer id);

    //借书
    public void setBooksCount(Integer bId);

    //还书
    public void returnBooks(Integer borrowId);
}
