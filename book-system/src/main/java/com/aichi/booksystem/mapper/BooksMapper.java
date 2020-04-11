package com.aichi.booksystem.mapper;

import com.aichi.booksystem.bean.Books;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BooksMapper {

    //插入书籍信息
    public void insertBook(Books books);
}
