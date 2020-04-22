<template>
    <div>
        <UserMain>
            <div style="width: 1000px; text-align: center"><img src="../../assets/加载.gif"></div>
        </UserMain>
    </div>
</template>

<script>
    import UserMain from "~/components/UserMain";

    export default {
        name: "OrdainRecords",
        components:{UserMain},
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
        }
    }
</script>

<style scoped>

</style>