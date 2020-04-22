<template>
    <div>
        <UserMain><div class="content">
            <el-table
                    :data="tableData"
                    :row-class-name="tableRowClassName"
                    style="width: 100%"
                    height="618">
                <el-table-column
                        prop="borrowId"
                        label="借书编号">
                </el-table-column>
                <el-table-column
                        prop="bId"
                        label="图书编号">
                </el-table-column>
                <el-table-column
                        prop="borrowDate"
                        label="借出日期">
                </el-table-column>
                <el-table-column
                        prop="expReturnDate"
                        label="期望归还日期">
                </el-table-column>
                <el-table-column
                        prop="returnDate"
                        label="归还日期">
                </el-table-column>
                <el-table-column
                        fixed="right"
                        label="操作"
                        width="100"
                        v-show="">
                    <template slot-scope="scope">
                        <el-button @click="handleClick(scope.row)" type="text" size="small">还书</el-button>
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

        </div></UserMain>
    </div>
</template>

<script>
    import UserMain from "~/components/UserMain";
    import axios from "axios";

    export default {
        name: "BorrowRecords",
        inject: ['reload'],
        components:{UserMain},
        data() {
            return {
                tableData: [{
                    borrowId:null,
                    bId:null,
                    borrowDate:null,
                    expReturnDate:null,
                    returnDate:null,
                },{
                    borrowId:null,
                    bId:null,
                    borrowDate:null,
                    expReturnDate:null,
                    returnDate:null,
                },{
                    borrowId:null,
                    bId:null,
                    borrowDate:null,
                    expReturnDate:null,
                    returnDate:null,
                },{
                    borrowId:null,
                    bId:null,
                    borrowDate:null,
                    expReturnDate:null,
                    returnDate:null,
                },{
                    borrowId:null,
                    bId:null,
                    borrowDate:null,
                    expReturnDate:null,
                    returnDate:null,
                },{
                    borrowId:null,
                    bId:null,
                    borrowDate:null,
                    expReturnDate:null,
                    returnDate:null,
                },{
                    borrowId:null,
                    bId:null,
                    borrowDate:null,
                    expReturnDate:null,
                    returnDate:null,
                },{
                    borrowId:null,
                    bId:null,
                    borrowDate:null,
                    expReturnDate:null,
                    returnDate:null,
                },{
                    borrowId:null,
                    bId:null,
                    borrowDate:null,
                    expReturnDate:null,
                    returnDate:null,
                },{
                    borrowId:null,
                    bId:null,
                    borrowDate:null,
                    expReturnDate:null,
                    returnDate:null,
                }],
                current_page: 1,
                total: 1
            }
        },
        mounted() {
            if (this.$cookies.isKey("id")) {
                this.id = this.$cookies.get("id");
                this.name = unescape(this.$cookies.get('name'));
                this.gender = unescape(this.$cookies.get('gender'));
            }
            else {
                alert("请登录！");
                this.$router.replace('/Login');
            }
            this.getData();
        },
        methods: {
            tableRowClassName({row, rowIndex}) {
                if (row.borrowId == null) {
                    return 'hidden-row';
                }
                return '';
            },
            getData() {
                axios.get("/api/getBorrowById", {
                    params: {
                        id: this.$cookies.get("id"),
                        page: this.current_page
                    }
                }).then( (res) => {
                    for (var i = 0; i < res.data.BorrowRecords.length; i++) {
                        this.tableData[i].borrowId = res.data.BorrowRecords[i].borrowId;
                        this.tableData[i].bId = res.data.BorrowRecords[i].bid;
                        this.tableData[i].borrowDate = res.data.BorrowRecords[i].borrowDate;
                        this.tableData[i].expReturnDate = res.data.BorrowRecords[i].expReturnDate;
                        this.tableData[i].returnDate = res.data.BorrowRecords[i].returnDate;
                    }
                    this.total = res.data.total;
                }).catch(function (error) {
                    console.log(error);
                });
            },
            handleClick(row) {
                let param = new URLSearchParams();
                param.append('borrowId', row.borrowId);
                axios.put("/api/returnBooks",
                    param
                ).then( (res)=> {
                    this.$message({
                        message:res.data.msg,
                        showClose:true,
                        center:true,
                        type:"success"
                    });
                    if ("还书成功！" == res.data.msg)
                        var that = this;
                    setTimeout(function () {
                        that.reload();
                    },2000);
                }).catch( function (error) {
                    this.$message({
                        message:"还书失败,请联系管理员！",
                        showClose:true,
                        center:true,
                        type:"error"
                    });
                    console.log(error);
                });
            },
            handleCurrentChange(val) {
                // console.log(`当前页: ${val}`);
                axios.get("/api/getBorrowById", {
                    params: {
                        id: this.$cookies.get("id"),
                        page: val
                    }
                }).then( (res) => {
                    for (var i = 0; i < res.data.BorrowRecords.length; i++) {
                        this.tableData[i].borrowId = res.data.BorrowRecords[i].borrowId;
                        this.tableData[i].bId = res.data.BorrowRecords[i].bid;
                        this.tableData[i].borrowDate = res.data.BorrowRecords[i].borrowDate;
                        this.tableData[i].expReturnDate = res.data.BorrowRecords[i].expReturnDate;
                        this.tableData[i].returnDate = res.data.BorrowRecords[i].returnDate;
                    }for (var i = res.data.BorrowRecords.length; i < 10; i++) {
                        this.tableData[i].borrowId = null;
                        this.tableData[i].bId = null;
                        this.tableData[i].borrowDate = null;
                        this.tableData[i].expReturnDate = null;
                        this.tableData[i].returnDate = null;
                    }
                }).catch(function (error) {
                    console.log(error);
                });
            }
        }
    }
</script>

<style lang="less">
    .el-table .hidden-row{
        display: none;
    }
</style>