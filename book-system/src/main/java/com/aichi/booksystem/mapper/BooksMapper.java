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

    //查询所有书籍数量
    public Integer getBooksCount();

    //分页查询所有书籍信息
    public List<Books> getBooks(Integer page, Integer count);

    //根据书名模糊查询
    public List<Books> getBooksByName(String bName);

    //根据作者模糊查询
    public List<Books> getBooksByAuthor(String author);

}
