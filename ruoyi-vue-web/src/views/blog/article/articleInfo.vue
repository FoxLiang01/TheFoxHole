<template>
  <div class="app-container">
    <div class="content">
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-row>
          <el-col :span="24">
            <el-form-item label="标题" prop="title">
              <el-input v-model="form.title" placeholder="请输入标题"></el-input>
            </el-form-item>
            <el-form-item label="合集" prop="categoryPath">
              <el-cascader
                v-model="metaCategoryPath"
                :options="metaCategoryList"
                placeholder="请选择合集"
                :props="{checkStrictly: true }"
                style="width: 100%" clearable ></el-cascader>
            </el-form-item>
          </el-col>
          <el-col :xs="24" :sm="12">
            <el-form-item label="分级" prop="rating">
              <el-radio-group v-model="form.rating">
                <el-radio :label="'0'">全年龄</el-radio>
                <el-radio :label="'1'">18+</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :xs="24" :sm="12">
            <el-form-item label="评论区" prop="isComment">
              <el-switch v-model="form.isComment"></el-switch>
            </el-form-item>
          </el-col>

          <el-col :span="24">
            <el-form-item label="标签" prop="tag">
              <el-select
                v-model="form.tag"
                multiple
                filterable
                allow-create
                default-first-option
                placeholder="请选择标签"
                style="width: 100%">
                <el-option
                  v-for="item in options"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value">
                </el-option>
              </el-select>
              <span style="font-size: 0.8em">Tips：如果类型是同人，标签最好包括这些内容：Fandom、CP、AU、角色等等，上面选过的内容就不用加了</span>
            </el-form-item>

            <el-form-item label="概述" prop="summary">
              <el-input type="textarea" v-model="form.summary"></el-input>
            </el-form-item>

            <el-form-item label="笔记" prop="note">
              <el-switch v-model="addNote"></el-switch>
              <el-radio-group v-model="notePlace" v-if="addNote" style="margin-left: 30px">
                <el-radio :label="1">放在开头</el-radio>
                <el-radio :label="2">放在结尾</el-radio>
              </el-radio-group>
              <el-input type="textarea" v-model="form.note" v-if="addNote"></el-input>
            </el-form-item>
          </el-col>
        </el-row>
      </el-form>

      <tiptap :value="this.form.content" v-model="form.content" :editable="true"/>

    </div>
    <div class="btn-list">
      <el-button type="primary" round @click="handleSubmit('0')">发布</el-button>
      <el-button type="info" round @click="handleSubmit('1')">草稿</el-button>
      <el-button round @click="goBack">返回</el-button>
    </div>
  </div>
</template>

<script>
    import Tiptap from "../../../components/Tiptap/Tiptap";
    import {listCategory} from "../../../api/blog/category";
    import {addArticle, getArticle, updateArticle} from "../../../api/blog/article";

    export default {
      name: "articleInfo",
      components: {Tiptap},
      data(){
        return{
          // 表单参数
          form:{},
          // 表单校验
          rules: {
            title:[{ required: true, message: "文章标题不能为空", trigger: "blur" }],
            rating:[{ required: true, message: "请选择文章的分级", trigger: "change" }],
          },
          addNote:false,
          notePlace:'',
          type:'',
          tag:[],
          options:[],
          metaCategoryList:[], //所有合集的查询结果
          metaCategoryPath:[], //父级合集的路径
          key:'',
          id:null,
          content:'',
        }
      },
      computed:{
      },
      created() {
        this.key = this.$route.query.key;
        this.id = this.$route.query.id;
        this.getCategory();
        if(this.key === 'edit'){
          this.getArticleInfo();
        }else if(this.key === 'add'){
          this.reset();
        }
      },
      methods:{
        goBack(){
          this.$router.back();
        },
        getArticleInfo(){
          getArticle(this.id).then(res =>{
            this.form = res.data
            this.metaCategoryPath = res.data.categoryPath.split('/').map(Number);
            console.log(this.form)
          })
        },
        //获取合集主项
        getCategory(){
          listCategory().then(response => {
            this.metaCategoryList = response.rows.map(item => ({
              value:item.id,
              label:item.name,
              children: item.children ? this.getChildren(item.children) : null
            }))
          });
        },
        //获取合集子项
        getChildren(children){
          return children.map(child => ({
            value:child.id,
            label:child.name,
            children: child.children ? this.getChildren(child.children) : null
          }))
        },
        // 表单重置
        reset() {
          this.form = {
            id: null,
            remark: null,
            delFlag: null,
            title: null,
            summary: null,
            note: null,
            content: null,
            status: "0",
            isComment: null,
            isTop: null,
            categoryId: null,
            categoryPath:'',
            notePosition:'0',
            chapter: null
          };
        },
        handleSubmit(row){
          this.$refs["form"].validate(valid => {
            if (valid) {
              if(row === '0'){
                this.form.delFlag = '0';
              }else{
                this.form.delFlag = '1';
              }
              if(this.metaCategoryPath){
                this.form.categoryPath = this.metaCategoryPath.join('/');
                this.form.categoryId = this.metaCategoryPath[this.metaCategoryPath.length-1];
                if(this.key === "add"){
                  addArticle(this.form).then((res) =>{
                    if(res.code === 200){
                      this.$modal.msgSuccess("新增成功");
                      this.goBack();
                    }
                  })
                }else if(this.key === "edit"){
                  this.form.categoryPath = this.metaCategoryPath.join('/');
                  updateArticle(this.form).then(res => {
                    if(res.code === 200){
                      this.$modal.msgSuccess("修改成功");
                      this.goBack();
                    }
                  })
                }
              }else{
                this.$modal.msgError("请选择合集")
              }
            }
          })
        }
      }
    }
</script>

<style lang="scss" scoped>
  .app-container{
    padding: 40px 100px;
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
