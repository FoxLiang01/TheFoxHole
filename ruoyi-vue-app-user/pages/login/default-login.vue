<template>
  <view>
    <view class="title">账号密码登录</view>
    <view class="container-radius">
      <u--form :model="form" :rules="rules" ref="uForm" label-width="80">
        <u-form-item label="登录账号" prop="username" borderBottom>
          <u--input v-model="form.username" border="none" placeholder="请填写登录账号" />
        </u-form-item>
        <u-form-item label="登录密码" prop="password" borderBottom>
          <u--input type="password" v-model="form.password" border="none" placeholder="请填写登录密码" />
        </u-form-item>
      </u--form>
    </view>
    <view class="container-null">
      <u-button type="primary" size="default" @tap="login" style="margin-top: 20px;">
        登录
      </u-button>
    </view>
  </view>
</template>

<script>
let that;

export default {
  data() {
    return {
      form: {
        username: '18386474459',
        password: '123456',
      },
      rules: {
        username: {required: true, message: '请填写登录账号', trigger: ['blur', 'change']},
        password: {required: true, message: '请填写登录密码', trigger: ['blur', 'change']},
      }
    }
  },
  onReady() {
    this.$refs.uForm.setRules(this.rules);
  },
  onLoad() {
    that = this;
  },
  methods: {
    login() {
      that.$refs.uForm.validate().then(res => {
        uni.$u.http.post('/au/defaultLogin/login', that.form).then(res => {
          uni.setStorageSync(that.$config.cachePrefix + 'token', res.data);
          uni.$u.http.get('/au/defaultLogin/getInfo').then(result => {
            uni.setStorageSync(that.$config.cachePrefix + 'user', result.user);
            uni.setStorageSync(that.$config.cachePrefix + 'roles', result.roles);
            uni.setStorageSync(that.$config.cachePrefix + 'permissions', result.permissions);
            that.$msg('登录成功', function () {
              uni.$u.route({type: 'tab', url: '/pages/index/index'});
            });
          });
        });
      });
    },
  },
}
</script>

<style lang="scss" scoped>
.title {
  font-size: 18px;
  text-align: center;
  line-height: 200px;
}

.container-box {
  color: $u-main-color;
  line-height: 35px;
}
</style>
