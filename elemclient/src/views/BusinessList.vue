<template>
    <div class="wrapper">
        <!-- header部分 -->
        <header>
            <p>商家列表</p>
        </header>
        <!-- 商家列表部分 -->
        <ul class="business">
            <li v-for="item in businessArr" @click="toBusinessInfo(item.shopId)" :key="item.shopId">
                <div class="business-img">
                    <img :src="item.storeImg">
                    <div class="business-img-quantity">3</div>
                </div>
                <div class="business-info">
                    <h3>{{item.shopname}}</h3>
                    <p>&#165;{{item.floorSendCost}}起送 | &#165;{{item.sendCost}}配送</p>
                    <p>{{item.tag}}</p>
                </div>
            </li>
        </ul>
        <!-- 底部菜单部分 -->
      <Footer></Footer>
    </div>
</template>
<script>
//导入公共组件Footer
import Footer from '../components/Footer.vue';
export default {
    name:"BusinessList",
    data(){
        return{
          orderTypeId:this.$route.query.orderTypeId,
          businessArr:[]
        };
    },
    created() {
      this.$axios
          .post(
              'shop/listByCate',
              this.$qs.stringify({
                cateid: parseInt(this.orderTypeId)
              })
          )
          .then(response=>{
            console.log(response.data);
            this.businessArr = response.data;
      });
    },
  methods:{
        toBusinessInfo(businessId){
            this.$router.push({path:'/businessInfo',query:{businessId:businessId}});
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
/****************** 商家列表部分 ******************/

.wrapper .business {
    width: 100%;
    margin-top: 12vw;
    margin-bottom: 14vw;
}

.wrapper .business li {
    width: 100%;
    box-sizing: border-box;
    padding: 2.5vw;
    border-bottom: solid 1px #DDD;
    user-select: none;
    cursor: pointer;
    display: flex;
    align-items: center;
}

.wrapper .business li .business-img {
    /*这里设置为相当定位，成为business-img-quantity元素的父元素*/
    position: relative;
}

.wrapper .business li .business-img img {
    width: 20vw;
    height: 20vw;
}

.wrapper .business li .business-img .business-img-quantity {
    width: 5vw;
    height: 5vw;
    background-color: red;
    color: #fff;
    font-size: 3.6vw;
    border-radius: 2.5vw;
    display: flex;
    justify-content: center;
    align-items: center;
    /*设置成绝对定位，不占文档流空间*/
    position: absolute;
    right: -1.5vw;
    top: -1.5vw;
}

.wrapper .business li .business-info {
    margin-left: 3vw;
}

.wrapper .business li .business-info h3 {
    font-size: 3.8vw;
    color: #555;
}

.wrapper .business li .business-info p {
    font-size: 3vw;
    color: #888;
    margin-top: 2vw;
}
</style>