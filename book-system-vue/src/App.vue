<template>
<!--  <div id="app">-->
<!--    <img src="./assets/logo.png">-->
<!--    <div>-->
<!--      <el-button @click="startHacking">Start</el-button>-->
<!--    </div>-->
<!--  </div>-->
  <router-view v-if="isRouterAlive"></router-view>
</template>

<script>
export default {
  // methods: {
  //   startHacking () {
  //     this.$notify({
  //       title: 'It works!',
  //       type: 'success',
  //       message: 'We\'ve laid the ground work for you. It\'s time for you to build something epic!',
  //       duration: 5000
  //     })
  //   }
  // }
  name: 'app',
  provide() {
    return {
      reload: this.reload
    }
  },
  data() {
    return {
      isRouterAlive: true
    }
  },
  methods: {
    reload() {
      this.isRouterAlive = false;
      this.$nextTick(function () {
        this.isRouterAlive = true;
      })
    }
  }
}
</script>

<style>
/*#app {*/
/*  font-family: Helvetica, sans-serif;*/
/*  text-align: center;*/
/*}*/
</style>
