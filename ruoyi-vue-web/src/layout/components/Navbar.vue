<template>
  <div class="navbar">
    <hamburger id="hamburger-container" :is-active="sidebar.opened" class="hamburger-container" @toggleClick="toggleSideBar" />

    <breadcrumb id="breadcrumb-container" class="breadcrumb-container" v-if="!topNav"/>
    <top-nav id="topmenu-container" class="topmenu-container" v-if="topNav"/>

    <div class="right-menu">
      <template v-if="device!=='mobile'">
        <router-link class="right-menu-item" to="/user/profile">
          <div>
            <span><i class="ri-user-3-line"></i>{{username}}</span>
          </div>
        </router-link>
        <div class="right-menu-item">
          <div>
            <span><i class="ri-settings-3-line"></i>设置</span>
          </div>
        </div>
        <div class="right-menu-item last-one" @click="logout">
          <div>
            <span ><i class="ri-logout-circle-r-line"></i>退出</span>
          </div>
        </div>
      </template>



<!--      <template v-if="device!=='mobile'">-->
<!--        <search id="header-search" class="right-menu-item" />-->

<!--        <screenfull id="screenfull" class="right-menu-item hover-effect" />-->

<!--        <el-tooltip content="布局大小" effect="dark" placement="bottom">-->
<!--          <size-select id="size-select" class="right-menu-item hover-effect" />-->
<!--        </el-tooltip>-->

<!--      </template>-->

<!--      <el-dropdown class="avatar-container right-menu-item hover-effect" trigger="click">-->
<!--        <div class="avatar-wrapper">-->
<!--          <img :src="avatar" class="user-avatar">-->
<!--          <i class="el-icon-caret-bottom" />-->
<!--        </div>-->
<!--        <el-dropdown-menu slot="dropdown">-->
<!--          <router-link to="/user/profile">-->
<!--            <el-dropdown-item>个人中心</el-dropdown-item>-->
<!--          </router-link>-->
<!--          <el-dropdown-item @click.native="setting = true">-->
<!--            <span>布局设置</span>-->
<!--          </el-dropdown-item>-->
<!--          <el-dropdown-item divided @click.native="logout">-->
<!--            <span>退出登录</span>-->
<!--          </el-dropdown-item>-->
<!--        </el-dropdown-menu>-->
<!--      </el-dropdown>-->
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import Breadcrumb from '@/components/Breadcrumb'
import TopNav from '@/components/TopNav'
import Hamburger from '@/components/Hamburger'
import Screenfull from '@/components/Screenfull'
import SizeSelect from '@/components/SizeSelect'
import Search from '@/components/HeaderSearch'
import RuoYiGit from '@/components/RuoYi/Git'
import RuoYiDoc from '@/components/RuoYi/Doc'
import {getUserProfile} from "../../api/system/user";

export default {
  components: {
    Breadcrumb,
    TopNav,
    Hamburger,
    Screenfull,
    SizeSelect,
    Search,
    RuoYiGit,
    RuoYiDoc
  },
  data(){
    return{
     username:''
    }
  },
  computed: {
    ...mapGetters([
      'sidebar',
      'avatar',
      'device'
    ]),
    setting: {
      get() {
        return this.$store.state.settings.showSettings
      },
      set(val) {
        this.$store.dispatch('settings/changeSetting', {
          key: 'showSettings',
          value: val
        })
      }
    },
    topNav: {
      get() {
        return this.$store.state.settings.topNav
      }
    }
  },
  created() {
    this.getUserName();
  },
  methods: {
    getUserName(){
      getUserProfile().then(response => {
        this.username = response.data.nickName;
      });
    },
    toggleSideBar() {
      this.$store.dispatch('app/toggleSideBar')
    },
    async logout() {
      this.$confirm('确定注销并退出系统吗？', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        this.$store.dispatch('LogOut').then(() => {
          location.href = '/ruoyi-vue-web/index';
        })
      }).catch(() => {});
    }
  }
}
</script>

<style lang="scss" scoped>
.navbar {
  height: 50px;
  overflow: hidden;
  position: relative;
  background: #fff;
  box-shadow: 0 1px 4px rgba(0,21,41,.08);

  .hamburger-container {
    line-height: 46px;
    height: 100%;
    float: left;
    cursor: pointer;
    transition: background .3s;
    -webkit-tap-highlight-color:transparent;

    &:hover {
      background: rgba(0, 0, 0, .025)
    }
  }

  .breadcrumb-container {
    float: left;
  }

  .topmenu-container {
    position: absolute;
    left: 50px;
  }

  .errLog-container {
    display: inline-block;
    vertical-align: top;
  }

  .right-menu {
    float: right;
    height: 100%;
    line-height: 50px;
    display: flex;

    &:focus {
      outline: none;
    }

    .right-menu-item {
      display: flex;
      /*padding: 0 8px;*/
      height: 100%;
      font-size: 18px;
      color: #cbb6af;
      vertical-align: text-bottom;
      /*margin: 0 10px;*/

      div{
        :hover{
          background-color: #d2c2b8;
          color: #967E76;
          transition: 0.5s ease all;
        }
      }

      span{
        font-size: 1rem;
        display: flex;
        vertical-align: top;
        cursor: pointer;
        width: 100px;
        justify-content: center;
        border-radius: 25px;

        i{
          font-size: 1.3rem;
          margin-right: 5px;
        }
      }
    }

    .last-one{
      margin-right: 30px;
    }

    .avatar-container {
      margin-right: 30px;

      .avatar-wrapper {
        margin-top: 5px;
        position: relative;

        .user-avatar {
          cursor: pointer;
          width: 40px;
          height: 40px;
          border-radius: 10px;
        }

        .el-icon-caret-bottom {
          cursor: pointer;
          position: absolute;
          right: -20px;
          top: 25px;
          font-size: 12px;
        }
      }
    }
  }
}
</style>
