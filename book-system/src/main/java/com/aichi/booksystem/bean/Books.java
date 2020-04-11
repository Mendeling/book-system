package com.aichi.booksystem.bean;

import lombok.Data;

import java.util.Date;

@Data
public class Books {

    private Integer bId;     //图书编号
    private String bName;    //书名
    private String author;  //作者
    private String pubComp;  //出版社
    private String pubDate;  //出版日期
    private Integer bCount;  //库存

}
