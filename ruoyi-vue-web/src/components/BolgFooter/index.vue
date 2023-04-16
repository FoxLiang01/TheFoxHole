<template>
<div class="footer">
  <el-row>
    <el-col :xs="24" :sm="24" :md="12" :lg="12" :xl="12">
      <h1 class="made-by">Made by Wandering Foxx</h1>
    </el-col>

    <el-col :xs="24" :sm="24" :md="12" :lg="12" :xl="12">
      <ul class="find-me">
        <h2>Find me</h2>
        <li><a href="https://archiveofourown.org/users/Wandering_Fox" target="_blank">AO3</a></li>
        <li><a href="https://wanderingfox.lofter.com" target="_blank">Lofter</a></li>
      </ul>
    </el-col>
  </el-row>
</div>
</template>

<script>
    export default {
      name: "blogFooter",
      data(){
        return{

        }
      }
    }
</script>

<style lang="scss" scoped>
.footer{
  width: 100%;
  background-color: #8c7851;
  margin-top: 50px;

  .made-by{
    margin-left: 40px;
    color: #fffffe;
  }

  .find-me{
    h2{
      color: #fffffe;
    }

    li{
      color: #fffffe;
      list-style-type: none;

      &:hover{
        color: #DDE4E9;
        transition: 0.3s all ease-out;
      }
    }
  }

}
</style>
