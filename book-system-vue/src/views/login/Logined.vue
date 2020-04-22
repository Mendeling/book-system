<template>
    <div>
        <UserMain>
            <div class="content">
                <h1>读者编号：{{this.id}}</h1>
                <h1>姓名：{{this.name}}</h1>
                <h1>性别：{{this.gender}}</h1>
            </div>
            <div class="loginOut" >
                <el-link :underline="false" type="danger" v-on:click="LoginOut">
                    退出登录
                </el-link>
            </div>
            <el-calendar v-model="value">
            </el-calendar>
        </UserMain>
    </div>
</template>

<script>
    import UserMain from "~/components/UserMain";

    export default {
        name: "Logined",
        components:{UserMain},
        data() {
            return {
                id: '',
                name: '',
                gender: '',
                value: new Date()
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
        },
        methods: {
            LoginOut: function () {
                this.$cookies.remove("id");
                this.$cookies.remove("name");
                this.$cookies.remove("gender");
                this.$router.replace("/Login");
            }
        }
    }
</script>

<style lang="less">
    .content {
        margin: auto;
        width: 500px;
        border-radius: 4px;
        background: white;
        h1 {
            text-align: center;
        }
    }
    .el-calendar {
        margin: auto;
        width: 990px;
    }
    .loginOut {
        width: 60px;
        margin: 10px auto;
    }
</style>