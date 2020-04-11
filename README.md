## 图书馆管理系统(books_manage_system)



[TOC]

### 抽象模型分析

1. 读者表（readers）：

   - 读者编号（id）
   - 姓名（name）
   - 性别（gender）**/男（male）/女（female） 

2. 书籍表（books）：

   - 图书编号（bId）
   - 书名（bName）
   - 作者（author）
   - 出版社（pubComp）
   - 出版日期（pubDate）
   - 库存（bCount）

3. 操作（operations）

   1. 借书记录表（borrowRecords）:

      - 借书编号（borrowId）

      - 图书编号（bId）
      - 读者编号（id）
      - 期望归还日期（expReturnDate）
      - 借出日期（borrowDate）
      - 归还日期（returnDate）

   2. 预定记录表（ordainRecords）:

      - 预定编号（ordainId）

      - 预定时间（ordainTime）

      - 读者编号（id）
      - 图书编号（bId）

------



### 基本业务功能

- **借书**	/borrow

  ​	请求方式：POST。入参：

  ​		读者编号（id）

  ​		图书编号（bId）

  ​	出参：

  ​		{

  ​			"msg":"借书成功",

  ​			"borrowId":借书编号

  ​		}

- **还书**    /return

  ​	请求方式：POST。入参：

  ​		借书编号（borrowId）

  ​	出参：

  ​		{

  ​			"msg":"还书成功"

  ​		}

- **预定**    /ordain

  ​	请求方式：POST。入参：

  ​		读者编号（id）

  ​		图书编号（bId）

  ​	出参：

  ​		{

  ​			“msg”:"预定成功",

  ​			"ordainId":预定编号

  ​		}

------



### 基本数据录入功能（同数据库管理功能）

- **书籍信息录入** 
- **读者信息录入**

------

### 信息查询功能

- #### **书籍信息查询**

  - **根据书名模糊查询**    /findBybName

    ​	请求方式：GET。入参：bName

    ​		出参：

    ​		{

    ​  		"msg": "查询成功！",

    ​    		"data": [

    ​    		    {

    ​     		       "author": "罗贯中",

    ​    		        "pubComp": "人民文学出版社",

    ​    		        "pubDate": "2010-01-01",

    ​    		        "bid": 3,

    ​    		        "bcount": 2,

    ​    		        "bname": "三国演义"

    ​   		     },

    ​		       {

    ​		           "author": "刘慈欣",

    ​ 		           "pubComp": "重庆出版社",

    ​		           "pubDate": "2008-01-01",

    ​		            "bid": 4,

    ​		            "bcount": 3,

    ​		            "bname": "三体"	

    ​   		     }

    ​		    ]	

    ​		}

  - **根据作者模糊查询**    /findByAuthor

    ​	请求方式：GET。入参：

    ​		作者（author）

    ​	出参：

    ​		{

    ​			"bId":图书编号,

    ​			"bName":书名,

    ​			"author":作者,

    ​			"pubComp":出版社,

    ​			"pubDate":出版日期,

    ​			"bCount":库存

    ​		}

- #### **读者信息查询**    /readers/findById

  ​	请求方式：GET。入参：id

  ​	出参：

	​	{

	​		"msg": "查询成功！",

	​		"data": {

	​			"id": 1,

	​			"name": "戴嘉雄",

	​			"gender": "男"

	​		}

	​	}

------

### 数据库管理功能

- #### 借阅信息管理    /borrowRecords

  - 查询借阅信息    /findAllBorrow

    ​	请求方式：GET。入参：无

    ​	出参：

    ​		{

    ​			"borrowId":借书编号,

    ​			"bId":图书编号,

    ​			"id":读者编号,

    ​			"expReturnDate":期望归还日期,

    ​			"borrowDate":借出日期,

    ​			"returnDate":归还日期

    ​		}

- #### **读者信息管理**

  - **插入读者信息**   /readers/insert

    ​	请求方式：POST。入参：id(自动递增)，name，gender

    ​		出参：

    ​		{

    ​   		 "msg": "插入成功！",

    ​   		 "data": {

    ​        		"id": 21,

    ​        		"name": "曾小贤",

    ​       		 "gender": "男"

    ​    		}

    ​		}

  - **根据读者编号修改读者信息**	/readers/updateById

    ​	请求方式：PUT。入参：id，name，gender

    ​		出参：

    ​		{

    ​    		"msg": "修改成功！"

    ​		}

  - **查询所有读者信息**   /readers/findAll

    ​	请求方式：GET。入参：无

    ​		出参：

    ​		{

    ​   		 "msg": "查询成功！",

    ​    		"data": [

    ​      		  {

    ​           		 "id": 1,

    ​           		 "name": "戴嘉雄",

    ​           		 "gender": "男"

    ​        		},

    ​      		  {

    ​           		 "id": 2,

    ​           		 "name": "黄俊民",

    ​            		"gender": "男"

    ​        		}

    ​   		 ]	

    ​		}

- #### 书籍信息管理    /books

  - 查询所有书籍信息   /books/findAll

    ​	请求方式：GET。入参：无

    ​	出参：

    ​		{

    ​    		"msg": "查询成功！",

    ​   		 "data": [

    ​       	 	{

    ​           		 "author": "吴承恩",

    ​           		 "pubComp": "浙江教育出版社",

    ​            		"pubDate": "2016-01-01",

    ​            		"bid": 3,

    ​           	 	"bname": "西游记",

    ​            		"bcount": 1

    ​        		}

    ​    		]

    ​		}

  - 插入书籍信息    /books/insert

    ​	请求方式：POST。入参：bName，author，pubComp，pubDate，bCount
    
    ​	出参：
    
    ​	{
    
    ​		"msg": "插入成功！",
    
    ​        "data": {
    
    ​       	 "author": "吴承恩",
    
    ​      	  "pubComp": "浙江教育出版社",
    
    ​      	  "pubDate": "2016",
    
    ​      	  "bid": 3,
    
    ​    	    "bname": "西游记",
    
    ​     	   "bcount": 1
    
    ​			}	
    
    ​	}

- #### 预定信息管理    /ordain

  - 查询预定信息    /findAllOrdain

    ​	请求方式：GET。入参：无

    ​	出参：

    ​		{

    ​			"ordainId":预定编号,

    ​			"ordainTime":预定时间,

    ​			"id":读者编号,

    ​			"bId":图书编号

    ​		}

------

### 帮助功能