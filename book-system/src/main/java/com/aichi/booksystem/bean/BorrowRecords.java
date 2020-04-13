package com.aichi.booksystem.bean;

import lombok.Data;


@Data
public class BorrowRecords {

    private Integer borrowId;   //借书编号
    private Integer bId;    //图书编号
    private Integer id;     //读者编号
    private String expReturnDate;     //期望归还日期
    private String borrowDate;        //借出日期
    private String returnDate;        //归还日期

}
