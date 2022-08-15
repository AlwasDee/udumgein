<template>
  <div class="login-form">

    <van-row type="flex" justify="space-between">
      <van-col>
        <van-icon name="cross" size="25" @click="$router.go(-1)"/>
      </van-col>
      <van-col>
        <router-link to="/login/email" replace class="switching">
          邮箱登录
        </router-link>
      </van-col>
    </van-row>

    <van-row>
      <span>密码登录</span>
    </van-row>

    <van-field
        v-model="loginForm.username"
        placeholder="邮箱/用户名"
    />
    <van-field
        v-model="loginForm.password"
        type="password"
        placeholder="密码"
    >
    </van-field>

    <div style="margin: 16px;">
      <van-button
          round block
          type="info"
          :disabled="submitCheck"
          @click="onSubmit"
      >
        登录
      </van-button>
    </div>

    <a class="text">忘记密码</a>

    <van-checkbox v-model="checked" label-disabled>
      已阅读并同意<a>《用户服务协议》</a>、<a>《隐私政策》</a>
    </van-checkbox>

  </div>
</template>

<script>

import {Toast} from "vant";

export default {
  data() {
    return {
      loginForm: {
        username: '',
        password: '',
      },
      checked: false
    };
  },
  methods: {
    onSubmit() {
      Toast.loading({
        message: '正在登录',
        forbidClick: true,
      });
      this.$store.dispatch('user/loginPwd', this.loginForm).then(() => {
        this.$router.push({path: this.redirect || '/profile'})
      })
    },
  },
  computed: {
    emailCheck: function () {
      const regEmail = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
      return this.loginForm.username === '' || !regEmail.test(this.loginForm.username)
    },
    usernameCheck: function () {
      const regUsername = /^[a-zA-Z0-9_-]{4,16}$/;
      return this.loginForm.username === '' || !regUsername.test(this.loginForm.username)
    },
    submitCheck: function () {
      return (this.emailCheck && this.usernameCheck) || !this.checked || this.loginForm.password === ''
    },
  }
};
</script>

<style scoped lang="scss">
.login-form {
  padding: 10px;

  .van-row {
    padding-left: 16px;
    padding-right: 16px;

    &:first-child {
      padding-top: 20px;
      padding-bottom: 15px;
    }

    &:nth-child(2) {
      padding-bottom: 30px;
    }

    span {
      letter-spacing: 3px;
      font-size: 30px;
    }

    .switching {
      letter-spacing: 1px;
      color: black;
    }

  }

  .van-checkbox {
    padding-left: 16px;
    padding-right: 16px;
    font-size: 14px;
    position: absolute;
    bottom: 30px;
  }

  .text {
    letter-spacing: 1px;
    padding-left: 16px;
  }
}
</style>
