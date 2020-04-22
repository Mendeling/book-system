import Vue from 'vue'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import App from './App.vue'

import VueRouter from "vue-router";
import {routes} from "~/routes";
import VueCookies from 'vue-cookies'

Vue.use(ElementUI);
Vue.use(VueRouter);
Vue.use(VueCookies);

const router = new VueRouter({
  mode: 'history',
  routes:routes
});

new Vue({
  el: '#app',
  router,
  render: h => h(App)
});
