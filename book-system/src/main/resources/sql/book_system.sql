CREATE TABLE `readers` (
`id` int NOT NULL AUTO_INCREMENT COMMENT '读者编号',
`name` varchar(255) NOT NULL COMMENT '姓名',
`gender` varchar(255) NULL DEFAULT NULL COMMENT '性别',
PRIMARY KEY (`id`)
);
CREATE TABLE `books` (
`bId` int(11) NOT NULL AUTO_INCREMENT COMMENT '图书编号',
`bName` varchar(255) NOT NULL COMMENT '书名',
`author` varchar(255) NOT NULL COMMENT '作者',
`pubComp` varchar(255) NOT NULL COMMENT '出版社',
`pubDate` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '出版日期',
`bCount` int NOT NULL COMMENT '库存',
PRIMARY KEY (`bId`) 
);
CREATE TABLE `borrowRecords` (
`borrowId` int(11) NOT NULL COMMENT '借书编号',
`bId` int(11) NOT NULL COMMENT '图书编号',
`id` int(11) NOT NULL COMMENT '读者编号',
`expReturnDate` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '期望归还日期',
`borrowDate` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '借出日期',
`returnDate` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '归还日期',
PRIMARY KEY (`borrowId`) 
);
CREATE TABLE `ordain` (
`ordainId` int(11) NOT NULL COMMENT '预定编号',
`ordainTime` datetime NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '预定时间',
`id` int(11) NULL COMMENT '读者编号',
`bId` int(11) NULL COMMENT '图书编号',
PRIMARY KEY (`ordainId`) 
);

ALTER TABLE `borrowRecords` ADD CONSTRAINT `fk_borrowRecords_books_1` FOREIGN KEY (`bId`) REFERENCES `books` (`bId`);
ALTER TABLE `borrowRecords` ADD CONSTRAINT `fk_borrowRecords_readers_1` FOREIGN KEY (`id`) REFERENCES `readers` (`id`);
ALTER TABLE `ordain` ADD CONSTRAINT `fk_ordain_readers_1` FOREIGN KEY (`id`) REFERENCES `readers` (`id`);
ALTER TABLE `ordain` ADD CONSTRAINT `fk_ordain_books_1` FOREIGN KEY (`bId`) REFERENCES `books` (`bId`);

