import Vue from 'vue'
import VueRouter from 'vue-router'
import Index from '../views/Index.vue'
import BusinessInfo from '../views/BusinessInfo.vue'
import BusinessList from '../views/BusinessList.vue'
import Order from '../views/Order.vue'
import OrderList from '../views/OrderList.vue'
import Payment from '../views/Payment.vue'
import Register from '../views/Register.vue'
import UserAddress from '../views/UserAddress.vue'
import AddUserAddress from '../views/AddUserAddress.vue'
Vue.use(VueRouter)

const routes = [{
        path: '/',
        name: 'Home',
        component: Index
    },
    {
        path: '/index',
        name: 'Index',
        component: Index
    },
    {
        path: '/businessInfo',
        name: 'BusinessInfo',
        component: BusinessInfo
    },
    {
        path: '/businessList',
        name: 'BusinessList',
        component: BusinessList
    },
    {
        path: '/order',
        name: 'Order',
        component: Order
    },
    {
        path: '/orderList',
        name: 'OrderList',
        component: OrderList
    },
    {
        path: '/payment',
        name: 'Payment',
        component: Payment
    },
    {
        path: '/register',
        name: 'Register',
        component: Register
    },
    {
        path: '/userAddress',
        name: 'UserAddress',
        component: UserAddress
    },
    {
        path: '/addUserAddress',
        name: 'AddUserAddress',
        component: AddUserAddress
    },
    {
        path: '/login',
        redirect: '/login/email',
    },
    {
        path: '/login/email',
        component: () =>
            import ('@/views/login/LoginWithCode'),
    },
    {
        path: '/login/pwd',
        component: () =>
            import ('@/views/login/LoginWithPwd'),
    },
];

const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location){
    return originalPush.call(this,location).catch(err=>err)
}

const router = new VueRouter({
    // mode:'history',
    // base:process.env.BASE_URL,
    routes
});

export default router;