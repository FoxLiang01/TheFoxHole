<template>
  <view>
    <view class="title">微信公众号</view>
    <view class="container-null">
      <u-button type="success" size="default" @tap="login" style="margin-top: 20px;">
        微信公众号授权登录
      </u-button>
    </view>
  </view>
</template>

<script>
let that;

export default {
  data() {
    return {
    }
  },
  onLoad(option) {
    that = this;
    console.log(option.token);
    if (that.$validator.isNotEmpty(option.token)) {
      console.log(option.token);
      uni.setStorageSync(that.$config.cachePrefix + 'token', option.token);
      uni.$u.http.get('/au/defaultLogin/getInfo').then(result => {
        uni.setStorageSync(that.$config.cachePrefix + 'user', result.user);
        uni.setStorageSync(that.$config.cachePrefix + 'roles', result.roles);
        uni.setStorageSync(that.$config.cachePrefix + 'permissions', result.permissions);
        that.$msg('登录成功', function () {
          uni.$u.route({type: 'tab', url: '/pages/index/index'});
        });
      });
    }
  },
  methods: {
    login() {
      uni.$u.http.get('/au/weiXinMp/getLoginUrl').then(res => {
        window.location.href = res.data;
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
