<template>
  <view>
    <view style="font-size: 20px; line-height: 50px; text-align: center;">若依MybatisPlus纯净版</view>
    <view class="container">
      <u-cell-group>
        <u-cell title="账号密码登录" :isLink="true" @click="toPage('/pages/login/login-default')"></u-cell>
        <u-cell title="微信公众号授权登录" :isLink="true" @click="toPage('/pages/login/login-weixin-mp')"></u-cell>
        <u-cell title="微信小程序授权登录" :isLink="true"></u-cell>
      </u-cell-group>
    </view>
    <view style="font-size: 16px; line-height: 30px; padding: 20px;">
      <view>1、为什么模板没有内容？</view>
      <view>通常情况下，都是根据用户提供的项目模板，或者公司UI小姐姐提供的UI界面开发的，所以这里没有页面模板。</view>
      <view>2、这里有什么？</view>
      <view>例如：账号密码登录、微信公众号授权登录、小程序授权登录完整流程等</view>
      <view>3、为什么我的眼里常含泪水？</view>
      <view>因为我对这片土地爱的深沉！</view>
    </view>
  </view>
</template>

<script>
let that;
export default {
  data() {
    return {}
  },
  onLoad() {
    that = this;
  },
  methods: {
    toPage(pageName) {
      uni.$u.route(pageName);
    }
  }
}
</script>

<style scoped>

</style>
