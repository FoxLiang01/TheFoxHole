<template>
  <div class="header">
    <el-menu default-active="activeIndex"
             mode="horizontal"
             background-color="transparent"
             text-color="#fff"
             active-text-color="#fff">
      <el-menu-item index="1">首页</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
    export default {
        name: "blogHeader",
      props:{

      },
      data(){
        return{
          activeIndex:'1',

        }
      },
    }
</script>

<style lang="scss" scoped>
  ::v-deep .el-menu--horizontal > .el-menu-item.is-active{
    border-bottom: 2px solid #fff;
  }

  ::v-deep .el-menu.el-menu--horizontal{
    border: none;

    ::v-deep li{
      ::v-deep &:hover{
        background-color: transparent;
      }
    }
  }
</style>
