<template>
    <div class="wrapper">
        <!-- header部分 -->
        <header>
            <p>在线支付</p>
        </header>
        <!-- 订单信息部分 -->
        <h3>订单信息：</h3>
        <div class="order-info">
            <p>
                万家饺子（软件园E18店）
                <i class="fa fa-caret-down" id="showBtn"></i>
            </p>
            <p>&#165;49</p>
        </div>
        <!-- 订单明细部分 -->
        <ul class="order-detailet" id="detailetBox">
            <li>
                <p>纯肉鲜肉（水饺） x 2</p>
                <p>&#165;15</p>
            </li>
            <li>
                <p>玉米鲜肉（水饺） x 1</p>
                <p>&#165;16</p>
            </li>
            <li>
                <p>配送费</p>
                <p>&#165;3</p>
            </li>
        </ul>
        <!-- 支付方式部分 -->
        <ul class="payment-type">
            <li>
                <img src="../assets/alipay.png">
                 <input type="radio" name="pay" id="alipay" checked style="width:6vw;height: 3.2vw;">
            </li>
            <li>
                <img src="../assets/wechat.png">
                <input type="radio" name="pay" style="width:6vw;height: 3.2vw;">
            </li>
        </ul>
        <div class="payment-button">
            <button @click="toOrderList">确认支付</button>
        </div>
        <div class="payment-button">
            <button @click="toOrderList">取消支付</button>
        </div>
        <!-- 底部菜单部分 -->
      <Footer></Footer>
    </div>
</template>
<script>
//导入公共组件Footer
import Footer from '../components/Footer.vue';
export default {
    name:"Payment",
    data(){
        return{
            orderId:this.$router.query.orderId
        };
    },
    created(){

    },
    methods:{
        toOrderList(){
            this.$router.push({path:"/orderList"});
        }
    },
    components:{
        Footer
    }
}
</script>
<style scoped>
/****************** 总容器 ******************/

.wrapper {
    width: 100%;
    height: 100%;
}


/****************** header部分 ******************/

.wrapper header {
    width: 100%;
    height: 12vw;
    background-color: #0097FF;
    color: #fff;
    font-size: 4.8vw;
    position: fixed;
    left: 0;
    top: 0;
    z-index: 1000;
    display: flex;
    justify-content: center;
    align-items: center;
}


/****************** 订单信息部分 ******************/

.wrapper h3 {
    margin-top: 12vw;
    box-sizing: border-box;
    padding: 4vw 4vw 0;
    font-size: 4vw;
    font-weight: 300;
    color: #999;
}

.wrapper .order-info {
    box-sizing: border-box;
    padding: 4vw;
    font-size: 4vw;
    color: #666;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.wrapper .order-info p:last-child {
    color: orangered;
}


/****************** 订单明细部分 ******************/

.wrapper .order-detailet {
    width: 100%;
}

.wrapper .order-detailet li {
    width: 100%;
    box-sizing: border-box;
    padding: 1vw 4vw;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.wrapper .order-detailet li p {
    font-size: 3vw;
    color: #666;
}


/****************** 支付方式部分 ******************/

.wrapper .payment-type {
    width: 100%;
}

.wrapper .payment-type li {
    width: 100%;
    box-sizing: border-box;
    padding: 4vw;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.wrapper .payment-type li img {
    width: 33vw;
    height: 8.9vw;
}

.wrapper .payment-type li .fa-check-circle {
    font-size: 5vw;
    color: #38CA73;
}

.wrapper .payment-button {
    width: 100%;
    box-sizing: border-box;
    padding: 4vw;
}

.wrapper .payment-button button {
    width: 100%;
    height: 10vw;
    border: none;
    /*去掉外轮廓线*/
    outline: none;
    border-radius: 4px;
    background-color: #38CA73;
    color: #fff;
}
</style>