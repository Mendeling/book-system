package com.aichi.booksystem.mapper;

import com.aichi.booksystem.bean.BorrowRecords;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    //根据读者编号查询借书记录
    public List<BorrowRecords> getBorrowById(Integer id, Integer page, Integer count);

    //还书
    public void returnBooks(Integer borrowId);

    //根据借书编号查询图书编号
    public Integer getBorrowIdByBooksId(Integer borrowId);

    //还书，书籍数量+1
    public void addBooks(Integer bId);

    //根据借书编号查询借书记录
    public BorrowRecords getBorrow(Integer borrowId);

    public Integer getBorrowCountById(Integer id);
}
