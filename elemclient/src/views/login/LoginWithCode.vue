<template>
  <div class="login-form">

    <van-row type="flex" justify="space-between">
      <van-col>
        <van-icon name="cross" size="25" @click="$router.go(-1)"/>
      </van-col>
      <van-col>
        <router-link to="/login/pwd" replace class="switching">
          密码登录
        </router-link>
      </van-col>
    </van-row>

    <van-row>
      <span>邮箱登录</span>
    </van-row>

    <van-field
        v-model="loginForm.email"
        placeholder="请输入邮箱"
    />
    <van-field
        v-model="loginForm.code"
        type="digit"
        maxlength="6"
        placeholder="验证码"
    >
      <template #button>
        <van-button
            size="small"
            type="info"
            round plain
            :disabled="emailCheck"
            @click="sendCode"
        >
          <span>{{sendMsg}}</span>
        </van-button>
      </template>
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

    <van-checkbox v-model="checked" label-disabled>
      未注册邮箱登录后将自动生成账号、且代表你已阅读并同意<a>《用户服务协议》</a>、<a>《隐私政策》</a>
    </van-checkbox>

  </div>
</template>

<script>
import {sendCode} from "@/api/login";
import {Toast} from "vant";

export default {
  data() {
    return {
      loginForm: {
        email: '',
        code: '',
      },
      sendMsg: '发送验证码',
      isSend: false,
      checked: false,
    };
  },
  methods: {
    onSubmit() {
      Toast.loading({
        message: '正在登录',
        forbidClick: true,
      });
      this.$store.dispatch('user/loginEmail', this.loginForm).then(() => {
        this.$router.push({path: this.redirect || '/profile'})
      })
    },
    sendCode() {
      sendCode(this.loginForm.email).then(res => {
        let timer = 60;
        this.isSend = true;
        this.sendMsg = '已发送(' + timer + 's)'
        this.timeFun = setInterval(() => {
          --timer;
          this.sendMsg = '已发送(' + timer + 's)'
          if (timer === 0) {
            this.isSend = false
            this.sendMsg = '重新发送'
            clearInterval(this.timeFun)
          }
        }, 1000)
        Toast.success(res.data.msg)
      })
    }
  },
  computed: {
    emailCheck: function () {
      const regEmail = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
      return this.loginForm.email === '' || !regEmail.test(this.loginForm.email) || this.isSend
    },
    submitCheck: function () {
      return this.loginForm.code.length !== 6 || !this.checked || this.emailCheck
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
  }
}
</style>
