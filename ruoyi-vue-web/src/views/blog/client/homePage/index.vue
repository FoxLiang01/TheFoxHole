<template>
  <div class="content">
    <blog-header/>
    <div class="banner-box">
      <img :src="bannerOne" alt="" class="banner-1">
      <img :src="bannerTwo" alt="" class="banner-2">
      <img :src="bannerThree" alt="" class="banner-3">
      <div class="icons">
        <i class="ri-arrow-down-s-line"></i>
        <i class="ri-arrow-down-s-line"></i>
        <i class="ri-arrow-down-s-line"></i>
      </div>
    </div>

    <div class="cards">
      <el-row :gutter="40">
        <el-col :xs="24" :sm="24" :md="16" :lg="16" :xl="16">
          <div class="bulletin-board">
            <h2>公告</h2>
            <Tiptap :editable="false" :value="content"/>
          </div>
          <div class="bulletin-board">
            <h2>Tags</h2>

          </div>
        </el-col>
        <el-col :xs="24" :sm="24" :md="8" :lg="8" :xl="8">
          <div class="bulletin-board">
            <h2>订阅</h2>

          </div>
          <div class="bulletin-board">
            <h2>最新文章</h2>

          </div>
        </el-col>
      </el-row>
    </div>

    <blog-footer/>
  </div>
</template>

<script>
    import BlogHeader from "../../../../components/BlogHeader/index";
    import Tiptap from "../../../../components/Tiptap/Tiptap";
    import BlogFooter from "../../../../components/BolgFooter/index";

    export default {
      name: "homePage",
      components: {BlogFooter, Tiptap, BlogHeader},
      data(){
          return{
            content:'ε＝ε＝ε＝(#>д<)ﾉ',
            bannerOne:require('@/assets/images/banner-1.png'),
            bannerTwo:require('@/assets/images/banner-2.png'),
            bannerThree:require('@/assets/images/banner-3.png'),
          }
      },
      methods:{

      }
    }
</script>

<style lang="scss" scoped>
.content{
  background-color: #ECC67C;

  .banner-box{
    margin-top: 30px;

    .banner-1{
      position: absolute;
      display: block;
      width: 300px;
      margin-left: 100px;
    }

    .banner-2{
      display: block;
      margin: 0 auto;
      width: 900px;
    }

    .banner-3{
      position: absolute;
      width: 500px;
      right: 0;
      top: 300px;
    }

    .icons{
      display: flex;
      justify-content: center;
      flex-direction: column;
      line-height: 2em;
      margin-top: 70px;

      .ri-arrow-down-s-line{
        color: #fff;
        font-size: 5em;
        margin: 0 auto;
        z-index: 100;
      }
    }
  }

  .cards{
    margin: 60px auto 0 auto;
    width: 70%;

    .bulletin-board{
      background-color: #EEE3CB;
      padding: 20px;
      border-radius: 35px;
      margin-top: 40px;

      h2{
        margin-top: 0;
        font-weight: bolder;
        color: #716040;
      }
    }
  }
}
</style>
