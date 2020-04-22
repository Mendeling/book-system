<template>
    <div class="main">

        <el-container>
            <el-header>
                <h1>欢迎来到图书馆</h1>
            </el-header>
            <el-divider></el-divider>
            <el-main>

                <el-menu class="el-menu-demo" mode="horizontal" @select="handleSelect">
                    <el-menu-item index="1"><el-link href="/Home">主页</el-link></el-menu-item>
                    <el-submenu index="2">
                        <template slot="title">个人中心</template>
                        <el-menu-item index="2-1"><el-link href="/BorrowRecords">借书记录</el-link></el-menu-item>
                        <el-menu-item index="2-2"><el-link href="/OrdainRecords">预定记录</el-link></el-menu-item>
                    </el-submenu>
                    <el-menu-item index="3">
                        <el-link href="/Login" v-if="login==0">登录</el-link>
                        <el-link href="/Logined" v-else>{{this.$cookies.get("name")}}</el-link>
                    </el-menu-item>
                    <el-menu-item index="4"><el-link href="/Help">帮助</el-link></el-menu-item>
                </el-menu>

            </el-main>
        </el-container>

        <slot></slot>

    </div>

</template>

<script>
    export default {
        name: "UserMain",
        data() {
            return {
                login: 0,
                // activeIndex: '',
            }
        },
        mounted() {
            this.CheckLogin();
        },
        methods: {
            CheckLogin() {
                if (this.$cookies.get("id") != null) {
                    this.login = 1;
                }
            },
            handleSelect(key, keyPath) {
                // console.log(key, keyPath);
            }
        }
    }
</script>

<style lang="less">

    .main {
        margin: auto;
        width: 1000px;
        height: 100%;
        top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        background: #fdf6ec;
    }

    h1 {
        color: #303133;
        font: 20px Extra large;
        font-weight: bolder;
    }

    .el-header {
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-row {
        margin-bottom: 20px;
        &:last-child {
            margin-bottom: 0;
        }
    }
    .el-col {
        border-radius: 4px;

        div {
            font-size: 20px;
            text-align: center;
        }
    }
    .bg-purple-dark {
        background: #99a9bf;
    }
    .bg-purple {
        background: #d3dce6;
    }
    .bg-purple-light {
        background: #e5e9f2;
    }
    .bg-white-smoke {
        background: whitesmoke;
    }
    .grid-content {
        border-radius: 4px;
        min-height: 33px;
    }
    .row-bg {
        padding: 10px 0;
        background-color: #f9fafc;
    }

</style>