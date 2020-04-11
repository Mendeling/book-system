package com.aichi.booksystem.mapper;

import com.aichi.booksystem.bean.Books;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BooksMapper {

    //插入书籍信息
    public void insertBook(Books books);

    //查询所有书籍信息
    public List<Books> getBooks();

    public List<Books> getBooksByName(String bName);
}
