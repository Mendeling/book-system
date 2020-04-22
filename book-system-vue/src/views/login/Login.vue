<template>
    <div>
        <UserMain>
            <p style="text-align: center; color: red">请登录！</p>
            <el-form
                :model="loginForm"
                ref="loginForm"
                label-width="100px"
            >
                <el-form-item
                        label="读者编号"
                        prop="id"
                        :rules="[
                            { required: true, message: '编号不能为空'},
                        ]"
                >
                    <el-input v-model.number="loginForm.id" placeholder="请输入您的读者编号"></el-input>
                </el-form-item>
                <el-form-item
                        label="姓名"
                        prop="name"
                        :rules="[
                            { required: true, message: '姓名不能为空'},
                        ]"
                >
                    <el-input type="name" v-model.string="loginForm.name" placeholder="请输入您的名字"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="submitForm('loginForm')">登录</el-button>
                </el-form-item>
            </el-form>
        </UserMain>
    </div>
</template>

<script>
    import UserMain from "~/components/UserMain";
    import axios from "axios"

    export default {
        name: "Login",
        components:{UserMain},
        data() {
            return {
                loginForm: {
                    name:'',
                    id:''
                }
            }
        },
        methods: {
            submitForm(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        let param = new URLSearchParams();
                        param.append('name', this.loginForm.name);
                        param.append('id', this.loginForm.id);
                        axios.post("/api/readers/login",
                            param
                        ).then( (response) => {
                            // console.log(response.data);
                            if (response.data.reader != null) {
                                console.log(response.data.reader);
                                this.$message({
                                    message:'登录成功！',
                                    type:"success",
                                    duration: 2000
                                });
                                this.$cookies.set("id", response.data.reader.id, 0);
                                this.$cookies.set("name", response.data.reader.name, 0);
                                this.$cookies.set("gender", response.data.reader.gender, 0);
                                this.$router.replace('/Logined');
                            }
                            else {
                                console.log("查无此人");
                                this.$message({
                                    message: response.data.msg,
                                    type: "error"
                                });
                            }
                        }).catch(function (error) {
                            console.log(error);
                        });
                    } else {
                        console.log('登录失败！');
                        return false;
                    }
                });
            },
        }
    }
</script>

<style lang="less">
    .el-form {
        width: 450px;
        margin: auto;
    }
    .el-form-item {
        margin: auto;
        padding: 10px;
        .el-input {
            width: 300px;
        }
    }
</style>