<template>
  <div class="app-container">
    <h2>合集，也是目录</h2>
<!--    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">-->
<!--      <el-form-item label="合集名称" prop="name">-->
<!--        <el-input-->
<!--          v-model="queryParams.name"-->
<!--          placeholder="请输入合集名称"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="父级合集" prop="metaCategory">-->
<!--        <el-input-->
<!--          v-model="queryParams.metaCategory"-->
<!--          placeholder="请输入父级合集"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item>-->
<!--        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>-->
<!--        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>-->
<!--      </el-form-item>-->
<!--    </el-form>-->

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['business:category:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['business:category:remove']"
        >删除</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading"
              :data="categoryList"
              @selection-change="handleSelectionChange"
              row-key="id"
              :tree-props="{children: 'children', hasChildren: 'hasChildren'}">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="合集名称" align="left" prop="name" />
<!--      <el-table-column label="备注或描述" align="left" prop="remark" />-->
      <el-table-column label="状态" align="center" prop="status" width="100">
        <template scope="scope">
          <el-tag type="success" v-if="scope.row.status === '0'">启用</el-tag>
          <el-tag type="info" v-if="scope.row.status === '1'">停用</el-tag>
        </template>
      </el-table-column>
      <el-table-column label="排序" align="center" prop="listOrder" width="100"/>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width" width="200">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['business:category:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['business:category:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改合集对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="600px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="110px">
        <el-form-item label="合集名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入合集名称" />
        </el-form-item>
        <el-form-item label="父级合集" prop="metaCategory">
          <el-switch
            v-model="metaCategoryExist">
          </el-switch>
          <el-cascader
            v-model="metaCategoryPath"
            :options="metaCategoryList"
            placeholder="请选择父级合集"
            :props="{checkStrictly: true }"
            style="width: 80%;margin-left: 10%"
            v-if="metaCategoryExist" clearable ></el-cascader>
        </el-form-item>
        <el-form-item label="描述" prop="remark">
          <el-input v-model="form.remark"
                    type="textarea"
                    placeholder="如果是文章列表的话，描述会显示在文章描述中；如果不是那就不显示，只有后台能看得到"
                    :autosize="{minRows: 4}"/>
        </el-form-item>
        <el-form-item label="排序" prop="listOrder">
          <el-input-number v-model="form.listOrder" ></el-input-number>
        </el-form-item>
        <el-form-item label="是否为文章列表" prop="articleList">
          <el-switch
            v-model="form.articleList"
            active-value="1"
            inactive-value="0">
          </el-switch>
        </el-form-item>
        <el-form-item label="使用状态" prop="status">
          <el-switch
            v-model="form.status"
            active-value="0"
            inactive-value="1">
          </el-switch>
        </el-form-item>

      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listCategory, getCategory, delCategory, addCategory, updateCategory } from "@/api/blog/category";

export default {
  name: "Category",
  data() {
    return {
      // 根路径
      baseURL: process.env.VUE_APP_BASE_API,
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 合集表格数据
      categoryList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        status: null,
        metaCategory: null,
        remark: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        name: [
          { required: true, message: "合集名称不能为空", trigger: "blur" }
        ],
        listOrder: [
          { required: true, message: "排序不能为空", trigger: "change" }
        ],
      },
      metaCategoryExist:false,
      metaCategoryList:[], //所有合集的查询结果
      metaCategoryPath:[], //父级合集的路径
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询合集列表 */
    getList() {
      this.loading = true;
      listCategory(this.queryParams).then(response => {
        this.categoryList = response.rows;
        this.total = response.total;
        this.loading = false;
        this.metaCategoryList = response.rows.map(item => ({
          value:item.id,
          label:item.name,
          children: item.children ? this.getChildren(item.children) : null
        }))
      });
    },
    //获取子项
    getChildren(children){
      return children.map(child => ({
        value:child.id,
        label:child.name,
        children: child.children ? this.getChildren(child.children) : null
      }))
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        name: null,
        status: "0",
        metaCategory: null,
        remark: null,
        listOrder:"1"
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.form.delFlag = '0';
      this.form.articleList = '0';
      this.open = true;
      this.title = "新增合集";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getCategory(id).then(response => {
        this.form = response.data;
        this.metaCategoryExist = this.form.metaCategory !== 0;  //有父级合集时才打开级联选择器
        if(this.metaCategoryExist){
          this.metaCategoryPath = this.form.path.split('/').map(Number);
        }
        this.open = true;
        this.title = "修改合集信息";
        console.log(this.form)
        console.log(this.metaCategoryPath)
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if(this.metaCategoryExist === false){
            this.form.metaCategory = 0;
          }else{
            this.form.metaCategory= this.metaCategoryPath[this.metaCategoryPath.length-1];
            this.form.path = this.metaCategoryPath.join('/')
          }
          if (this.form.id != null) {
            updateCategory(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addCategory(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除合集【 ' + row.name + ' 】？').then(function() {
        return delCategory(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
  }
};
</script>
