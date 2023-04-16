<template>
  <div class="login">
    <el-form ref="loginForm" :model="loginForm" :rules="loginRules" class="login-form">
      <h1 class="title-cn">欢迎来到狐狸洞 UwU</h1>
      <h2 class="title-en">Welcome to The FoxHole</h2>

      <el-form-item prop="username" class="input-box" @hover="input">
        <i class="ri-map-pin-user-line icon"></i>
        <el-input
          v-model="loginForm.username"
          type="text"
          auto-complete="off"
          @input="input"
        ></el-input>
        <label class="label" :style="usernameIsEmpty === false? labelStyle : '' ">账号</label>
      </el-form-item>

      <el-form-item prop="password" class="input-box" @hover="input">
        <i class="ri-lock-line icon"></i>
        <el-input
          v-model="loginForm.password"
          type="password"
          auto-complete="off"
          @keyup.enter.native="handleLogin"
          @input="input"
          @hover="input"
        ></el-input>
        <label class="label" :style="passwordIsEmpty===false? labelStyle:''">密码</label>
      </el-form-item>

      <!--      <el-form-item prop="code" v-if="captchaEnabled" class="input-box" @hover="input">-->
      <!--        <el-input-->
      <!--          v-model="loginForm.code"-->
      <!--          auto-complete="off"-->
      <!--          style="width: 63%"-->
      <!--          @keyup.enter.native="handleLogin"-->
      <!--          @input="input"-->
      <!--        ></el-input>-->
      <!--        <div class="login-code">-->
      <!--          <img :src="codeUrl" @click="getCode" class="login-code-img"/>-->
      <!--        </div>-->
      <!--        <label class="label" :style="codeIsEmpty===false? labelStyle:'' ">验证码</label>-->
      <!--      </el-form-item>-->

      <div class="forget">
        <label>
          <input type="checkbox" v-model="loginForm.rememberMe">
          记住密码
        </label>
      </div>

      <el-button
        round
        :loading="loading"
        size="medium"
        type="primary"
        style="width:100%;"
        @click.native.prevent="handleLogin"
      >
        <span v-if="!loading">登 录</span>
        <span v-else>登 录 中...</span>
      </el-button>

<!--      <el-button-->
<!--        round-->
<!--        :loading="loading"-->
<!--        size="medium"-->
<!--        type="primary"-->
<!--        style="width:100%;margin:0 auto 30px auto"-->
<!--        @click.native.prevent="handleLogin"-->
<!--      >-->
<!--        <span v-if="!loading">读者访问</span>-->
<!--        <span v-else>登 录 中...</span>-->
<!--      </el-button>-->

      <div style="float: right;" v-if="register">
        <router-link class="link-type" :to="'/register'">立即注册</router-link>
      </div>
    </el-form>
    <!--  底部  -->
    <!--    <div class="el-login-footer">-->
    <!--      <span>Copyright © 2018-2023 ruoyi.vip All Rights Reserved.</span>-->
    <!--    </div>-->
  </div>
</template>

<script>
  import { getCodeImg } from "@/api/login";
  import Cookies from "js-cookie";
  import { encrypt, decrypt } from '@/utils/jsencrypt'

  export default {
    name: "Login",
    data() {
      return {
        codeUrl: "",
        loginForm: {
          username: "",
          password: "",
          rememberMe: false,
          code: "",
          uuid: ""
        },
        loginRules: {
          username: [
            { required: true, trigger: "blur", message: "请输入您的账号" }
          ],
          password: [
            { required: true, trigger: "blur", message: "请输入您的密码" }
          ],
          // code: [
          //   { required: true, trigger: "blur", message: "请输入验证码" }
          // ]
        },
        loading: false,
        // 验证码开关
        captchaEnabled: false,
        // 注册开关
        register: false,
        redirect: undefined,
        usernameIsEmpty:true,
        passwordIsEmpty:true,
        codeIsEmpty:true,
        labelStyle:{
          top: '-5px'
        }
      };
    },
    watch: {
      $route: {
        handler: function(route) {
          this.redirect = route.query && route.query.redirect;
        },
        immediate: true
      }
    },
    created() {
      this.getCode();
      this.getCookie();
      this.input();
    },
    methods: {
      getCode() {
        getCodeImg().then(res => {
          this.captchaEnabled = res.captchaEnabled === undefined ? true : res.captchaEnabled;
          if (this.captchaEnabled) {
            this.codeUrl = "data:image/gif;base64," + res.img;
            this.loginForm.uuid = res.uuid;
          }
        });
      },
      getCookie() {
        const username = Cookies.get("username");
        const password = Cookies.get("password");
        const rememberMe = Cookies.get('rememberMe')
        this.loginForm = {
          username: username === undefined ? this.loginForm.username : username,
          password: password === undefined ? this.loginForm.password : decrypt(password),
          rememberMe: rememberMe === undefined ? false : Boolean(rememberMe)
        };
      },
      handleLogin() {
        this.$refs.loginForm.validate(valid => {
          if (valid) {
            this.loading = true;
            if (this.loginForm.rememberMe) {
              Cookies.set("username", this.loginForm.username, { expires: 30 });
              Cookies.set("password", encrypt(this.loginForm.password), { expires: 30 });
              Cookies.set('rememberMe', this.loginForm.rememberMe, { expires: 30 });
            } else {
              Cookies.remove("username");
              Cookies.remove("password");
              Cookies.remove('rememberMe');
            }
            this.$store.dispatch("Login", this.loginForm).then(() => {
              this.$router.push({ path: this.redirect || "/" }).catch(()=>{});
            }).catch(() => {
              this.loading = false;
              if (this.captchaEnabled) {
                this.getCode();
              }
            });
          }
        });
      },
      input(){
        this.usernameIsEmpty = this.loginForm.username === null || this.loginForm.username === "";
        this.passwordIsEmpty = this.loginForm.password === null || this.loginForm.password === "";
        this.codeIsEmpty = this.loginForm.code === null || this.loginForm.code === "";
      }
    }
  };
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
  .login {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%;
    background-image: url("../assets/images/login-background-01.jpg");
    background-size: cover;
  }
  .title-cn {
    margin: 30px auto 20px auto;
    text-align: center;
    font-weight: bold;
    color: #ffffff;
    text-shadow: #324431 5px 5px 5px;
  }

  .title-en {
    margin: 10px auto 50px auto;
    text-align: center;
    font-weight: normal;
    color: #ffffff;
    text-shadow: #324431 5px 5px 5px;
  }

  .login-form::v-deep {
    background: transparent;
    border: 2px solid rgba(255,255,255,0.5);
    border-radius: 50px;
    backdrop-filter: blur(7px);
    width: 400px;
    padding: 25px 25px 5px 25px;

    .input-box{
      position: relative;
      margin: 30px 0;
      border-bottom: 2px solid #fff;
      width: 100%;

      :hover~label{
        top:-5px;
      }

      label{
        position: absolute;
        top: 50%;
        left: 5px;
        transform: translateY(-50%);
        color: #fff;
        font-size: 1.2em;
        pointer-events: none;
        transition: .5s;
      }

      input{
        width: 100%;
        height: 50px;
        background: transparent;
        border: none;
        outline: none;
        font-size: 1em;
        padding:0 35px 0 5px;
        color: #fff;
      }
    }

    .icon{
      position: absolute;
      right: 8px;
      font-size: 1.5em;
      color: #ffffff;
    }

    .el-input__inner{
      background-color: transparent;
      border: none;
      border-bottom: 2px solid #fff;
    }

    .el-input {
      height: 38px;
      input {
        height: 38px;
      }
    }

    .el-form-item__error{
      color: #ffffff;
    }
  }

  .forget{
    margin: 10px auto 0 auto;
    font-size: .9em;
    color: #fff;
    display: flex;
    justify-content: space-between;

    label input{
      margin-right: 3px;
      accent-color: #8cc980;
    }
  }

  .login-tip {
    font-size: 13px;
    text-align: center;
    color: #bfbfbf;
  }
  .login-code {
    width: 33%;
    height: 38px;
    float: right;
    img {
      cursor: pointer;
      vertical-align: middle;
    }
  }

  .el-login-footer {
    height: 40px;
    line-height: 40px;
    position: fixed;
    bottom: 0;
    width: 100%;
    text-align: center;
    color: #fff;
    font-family: Arial;
    font-size: 12px;
    letter-spacing: 1px;
  }
  .login-code-img {
    height: 38px;
  }

  .el-button--primary{
    background-color: transparent;
    border-color: #ffffff;
    transition: all 0.5s ease-out;
    margin:20px auto 30px auto;
  }
  .el-button--primary:hover,
  .el-button--primary:focus{
    background: #8cc980;
    border-color: #8cc980;
  }

</style>
