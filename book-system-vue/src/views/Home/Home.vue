<template>
    <div>
        <UserMain>
            <el-form>
                <el-row>
                    <el-col :span="12"><div class="grid-content">
                        <el-input v-model="input" placeholder="请输入内容" clearable></el-input>
                    </div></el-col>
                    <el-col :span="12"><div class="grid-content">
                        <el-radio v-model="radio" label="1">根据书名</el-radio>
                        <el-radio v-model="radio" label="2">根据作者</el-radio>
                        <el-button icon="el-icon-search" circle v-on:click="find"></el-button>
                    </div></el-col>
                </el-row>
            </el-form>
            <el-divider></el-divider>
            <div class="content">
                <el-table
                        :data="tableData"
                        :row-class-name="tableRowClassName"
                        style="width: 100%"
                        height="580">
                    <el-table-column
                            prop="bid"
                            label="图书编号"
                            width="100">
                    </el-table-column>
                    <el-table-column
                            prop="bname"
                            label="书名"
                            width="200">
                    </el-table-column>
                    <el-table-column
                            prop="author"
                            label="作者">
                    </el-table-column>
                    <el-table-column
                            prop="pubComp"
                            label="出版社">
                    </el-table-column>
                    <el-table-column
                            prop="pubDate"
                            label="出版日期">
                    </el-table-column>
                    <el-table-column
                            prop="bcount"
                            label="库存">
                    </el-table-column>
                    <el-table-column
                            fixed="right"
                            label="操作"
                            width="100"
                            v-show="">
                        <template slot-scope="scope">
                            <el-button @click="handleClick(scope.row)" type="text" size="small">借书</el-button>
                            <el-button @click="handleClick1(scope.row)" type="text" size="small">预定</el-button>
                        </template>
                    </el-table-column>
                </el-table>

                <el-pagination
                        background
                        layout="prev, pager, next"
                        :total="total"
                        @current-change="handleCurrentChange"
                        :current-page="current_page"
                        style="text-align: center;padding: 10px">
                </el-pagination>
            </div>
        </UserMain>

    </div>
</template>

<script>
    import UserMain from "~/components/UserMain";
    import axios from 'axios'

    export default {
        name: "Home",
        inject: ['reload'],
        components: {UserMain},
        data() {
            return {
                input: '',
                radio: '1',
                tableData: [{
                    bid:'',
                    bname:'',
                    author:'',
                    pubComp:'',
                    pubDate:'',
                    bcount:'',
                },{
                    bid:'',
                    bname:'',
                    author:'',
                    pubComp:'',
                    pubDate:'',
                    bcount:'',
                },{
                    bid:'',
                    bname:'',
                    author:'',
                    pubComp:'',
                    pubDate:'',
                    bcount:'',
                },{
                    bid:'',
                    bname:'',
                    author:'',
                    pubComp:'',
                    pubDate:'',
                    bcount:'',
                },{
                    bid:'',
                    bname:'',
                    author:'',
                    pubComp:'',
                    pubDate:'',
                    bcount:'',
                },{
                    bid:'',
                    bname:'',
                    author:'',
                    pubComp:'',
                    pubDate:'',
                    bcount:'',
                },{
                    bid:'',
                    bname:'',
                    author:'',
                    pubComp:'',
                    pubDate:'',
                    bcount:'',
                },{
                    bid:'',
                    bname:'',
                    author:'',
                    pubComp:'',
                    pubDate:'',
                    bcount:'',
                },{
                    bid:'',
                    bname:'',
                    author:'',
                    pubComp:'',
                    pubDate:'',
                    bcount:'',
                },{
                    bid:'',
                    bname:'',
                    author:'',
                    pubComp:'',
                    pubDate:'',
                    bcount:'',
                }],
                current_page: 1,
                total: 1
            }
        },
        mounted() {
            this.getData();
        },
        methods: {
            find() {
                this.$message({
                    message:'别点啦，没有你想要的操作！',
                    showClose:true,
                    center:true,
                    type:"success"
                });
            },
            getData() {
                axios.get("/api/books/findAll", {
                    params: {
                        page: this.current_page
                    }
                }).then( (res) => {
                    // console.log(res.data);
                    for (var i = 0; i < res.data.books.length; i++) {
                        this.tableData[i].bid = res.data.books[i].bid;
                        this.tableData[i].bname = res.data.books[i].bname;
                        this.tableData[i].author = res.data.books[i].author;
                        this.tableData[i].pubComp = res.data.books[i].pubComp;
                        this.tableData[i].pubDate = res.data.books[i].pubDate;
                        this.tableData[i].bcount = res.data.books[i].bcount;
                    }
                    for (var i = res.data.books.length; i < 10; i++) {
                        this.tableData[i].bid = null;
                        this.tableData[i].bname = null;
                        this.tableData[i].author = null;
                        this.tableData[i].pubComp = null;
                        this.tableData[i].pubDate = null;
                        this.tableData[i].bcount = null;
                    }
                    this.total = res.data.total;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            tableRowClassName({row, rowIndex}) {
                if (row.bid == null) {
                    return 'hidden-row';
                }
                return '';
            },
            handleClick(row) {
                if (this.$cookies.isKey("id")) {
                    if (row.bcount > 0) {
                        let param = new URLSearchParams();
                        param.append('bId',row.bid);
                        param.append('id', this.$cookies.get("id"));
                        axios.post("/api/borrowBooks",
                            param
                        ).then( (res)=> {
                            this.$message({
                                message:res.data.msg,
                                showClose:true,
                                center:true,
                                type:"success"
                            });
                            if ("借书成功！" == res.data.msg)
                                var that = this;
                                setTimeout(function () {
                                    that.reload();
                                },2000);
                        }).catch( function (error) {
                            this.$message({
                                message:"借书失败,请联系管理员！",
                                showClose:true,
                                center:true,
                                type:"error"
                            });
                            console.log(error);
                        });
                    }
                    else {
                        this.$message({
                            message:"库存不足，借书失败！",
                            showClose:true,
                            center:true,
                        });
                    }
                }
                else {
                    this.$message({
                        message:"请登录后再操作！",
                        showClose:true,
                        center:true
                    });
                }
            },
            handleClick1(row) {
                this.$message({
                    message:'小猿正在熬夜加载此功能···',
                    showClose:true,
                    center:true,
                    type:'warning'
                });
            },
            handleCurrentChange(val) {
                // console.log(`当前页: ${val}`);
                axios.get("/api/books/findAll", {
                    params: {
                        page: val
                    }
                }).then( (res) => {
                    for (var i = 0; i < res.data.books.length; i++) {
                        this.tableData[i].bid = res.data.books[i].bid;
                        this.tableData[i].bname = res.data.books[i].bname;
                        this.tableData[i].author = res.data.books[i].author;
                        this.tableData[i].pubComp = res.data.books[i].pubComp;
                        this.tableData[i].pubDate = res.data.books[i].pubDate;
                        this.tableData[i].bcount = res.data.books[i].bcount;
                    }
                    for (var i = res.data.books.length; i < 10; i++) {
                        this.tableData[i].bid = null;
                        this.tableData[i].bname = null;
                        this.tableData[i].author = null;
                        this.tableData[i].pubComp = null;
                        this.tableData[i].pubDate = null;
                        this.tableData[i].bcount = null;
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            }
        }
    }
</script>

<style lang="less">
    .el-input {
        width: 400px;
    }
    .content {
        margin: auto;
        width: 970px;
        height: 620px;
    }

    .el-table .hidden-row{
        display: none;
    }
</style>