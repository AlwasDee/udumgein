<template>
<div>
    <van-nav-bar title="添加用户地址" left-text="返回" left-arrow @click-left=" $router.go(-1);"></van-nav-bar>
    <van-address-edit
  :area-list="areaList"
  show-delete
  show-set-default
  show-search-result
  :search-result="searchResult"
  :area-columns-placeholder="['请选择', '请选择', '请选择']"
  @save="onSave"
  @delete="onDelete"
  @change-detail="onChangeDetail"
/>
</div>
</template>
<script>

import { Toast } from 'vant';
import { areaList } from '@vant/area-data';
export default { 
    name:"AddUserAddress",
  data() {
    return {
      areaList,
      searchResult: [],
    };
  },
  methods: {
    onSave() {
      Toast('save');
    },
    onDelete() {
      Toast('delete');
    },
    onChangeDetail(val) {
      if (val) {
        this.searchResult = [
          {
            name: '黄龙万科中心',
            address: '杭州市西湖区',
          },
        ];
      } else {
        this.searchResult = [];
      }
    },
  },
};
</script>
