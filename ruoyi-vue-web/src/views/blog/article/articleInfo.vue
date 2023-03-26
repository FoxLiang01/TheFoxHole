<template>
  <div class="app-container">
    <div class="content">
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="标题">
          <el-input v-model="form.title"></el-input>
        </el-form-item>
        <el-form-item label="类型">
          <el-radio-group v-model="type">
            <el-radio :label="3">原创</el-radio>
            <el-radio :label="6">同人</el-radio>
            <el-radio :label="9">翻译</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="分级">
          <el-radio-group v-model="rating">
            <el-radio :label="3">清水</el-radio>
            <el-radio :label="6">18+</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="标签">
          <el-select
            v-model="tag"
            multiple
            filterable
            allow-create
            default-first-option
            style="width: 100%">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
          Tips：如果类型是同人，标签最好包括这些内容：Fandom、CP、AU、角色等等，上面选过的内容就不用加了
        </el-form-item>
        <el-form-item label="概述">
          <el-input type="textarea" v-model="form.summary"></el-input>
        </el-form-item>
        <el-form-item label="笔记">
          <el-checkbox v-model="addNote"></el-checkbox>
          <el-radio-group v-model="notePlace" v-if="addNote" style="margin-left: 30px">
            <el-radio :label="3">放在开头</el-radio>
            <el-radio :label="6">放在结尾</el-radio>
          </el-radio-group>
          <el-input type="textarea" v-model="form.note" v-if="addNote"></el-input>
        </el-form-item>
      </el-form>

      <tiptap />
    </div>
    <div class="btn-list">
      <el-button type="primary" round>发布</el-button>
      <el-button type="info" round>草稿</el-button>
      <el-button round @click="goBack">返回</el-button>
    </div>
  </div>
</template>

<script>
    import Tiptap from "../../../components/Tiptap/Tiptap";
    export default {
      name: "articleInfo",
      components: {Tiptap},
      data(){
        return{
          form:{},
          addNote:false,
          notePlace:'',
          type:'',
          tag:[],
          rating:'',
          options:[]

        }
      },
      created() {

      },
      methods:{
        goBack(){
          this.$router.back();
        }
      }
    }
</script>

<style lang="scss" scoped>
  .app-container{
    padding: 40px 200px;
  }

  .btn-list{
    display: flex;
    justify-content: center;
    margin-top: 40px;

    button{
      margin:0 20px;
    }
  }

</style>
