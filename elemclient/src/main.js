import Vue from 'vue';
import App from './App.vue';
import router from './router';
import store from './store';
import "font-awesome/css/font-awesome.min.css";
import axios from "axios";
import qs from "qs";

import Vant from 'vant';

import 'vant/lib/index.css';
import '@/assets/style/index.scss'

Vue.use(Vant);

//导入自定义模块
import {
    getCurDate,
    setSessionStorage,
    getSessionStorage,
    removeSessionStorage,
    setLocalStorage,
    getLocalStorage,
    removeLocalStorage,
} from "../common.js";

Vue.config.productionTip = false;

//设置axios请求url基础部分
axios.defaults.baseURL = "http://localhost:9090";

//将axios挂载到vue
Vue.prototype.$axios = axios;
Vue.prototype.$qs = qs;
Vue.prototype.$getCurDate = getCurDate;
Vue.prototype.$setSessionStorage = setSessionStorage;
Vue.prototype.$getSessionStorage = getSessionStorage;
Vue.prototype.$removeSessionStorage = removeSessionStorage;
Vue.prototype.$setLocalStorage = setLocalStorage;
Vue.prototype.$getLocalStorage = getLocalStorage;
Vue.prototype.$removeLocalStorage = removeLocalStorage;

// router.beforeEach(function (to, from, next){
//     let user=sessionStorage.getItem('user');
//     if(!(to.path=="/"||
//         to.path=="/index"||
//         to.path=="/businessList"||
//         to.path=="/businessInfo"||
//         to.path=="/login"||
//         to.path=="/register"
//     )){
//         if (user == null){
//             router.push("/login");
//             location.reload();
//         }
//     }
//     next();
// })

new Vue({
    router,
    store,
    render: function(h) { return h(App) }
}).$mount('#app')