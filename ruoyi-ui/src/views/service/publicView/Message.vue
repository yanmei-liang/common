<template>
  <div>
    <div class="header">
      <el-button type="primary" @click="handleGetClick">留言咨询</el-button>
      <div style="display: flex">
        <el-input
          v-model="input"
          placeholder="请输入提问内容或者提问码"
        ></el-input>
        <el-button type="primary" @click="handleSub">查询</el-button>
        <el-button type="info">重置</el-button>
      </div>
    </div>
    <div class="content" v-loading="fullscreenLoading">
      <!-- <div style="height:20px"></div> -->
      <div v-for="item in messageList" :key="item" style="width: 90%; margin: 20px">
        <div v-if="!!item.ispublic"
          style="
            background-color: #f2f2f2;
            padding: 5px 20px;
            border-radius: 5px;
          "
        >
          <div style="display: flex; justify-content: space-between">
            <div class="flex">
              <div class="wenzi">
                <span>问</span>
              </div>
              <p>张立强：{{item.content}}</p>
            </div>
            <p>{{item.recivetime}}</p>
          </div>
          <div style="display: flex; justify-content: space-between">
            <div class="flex">
              <div class="wenzi" style="background-color: rgba(2, 167, 240, 1)">
                <span>答</span>
              </div>
              <p>{{item.recivedepart}}：{{item.reccontent}}</p>
            </div>
            <p>{{item.recivetime}}</p>
          </div>
        </div>
      </div>
    </div>
    <Pagination :total="10" />

    <!-- 弹框 -->
    <el-dialog title="留言发起" :visible.sync="dialogFormVisible">
      <el-form :model="form" label-position="top">
        <el-form-item label="留言内容" required prop="desc">
          <el-input
            type="textarea"
            v-model="form.desc"
            maxlength="300"
          ></el-input>
        </el-form-item>
        <el-form-item label="请输入验证码" required prop="desc">
          <el-input
            type="input"
            v-model="form.desc"
            style="width: 70%"
          ></el-input>
          <el-button>验证码</el-button>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="handleOpen">提 交</el-button>
        <el-button type="info" @click="dialogFormVisible = false"
          >取 消</el-button
        >
      </div>
    </el-dialog>
  </div>
</template>
<script>
import Pagination from "@/components/Pagination/index.vue";
import {
  listMessage,
  getMessage,
  delMessage,
  addMessage,
  updateMessage,
} from "@/api/system/message";
export default {
  props: ["dataList"],
  components: { Pagination },
  data() {
    return {
      input: "",
      form: {
        name: "",
        region: "",
        date1: "",
        date2: "",
        delivery: false,
        type: [],
        resource: "",
        desc: "",
      },
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        content: null,
        ipaddress: null,
        status: null,
        recivedepart: null,
        reccontent: null,
        createtime: null,
        recivetime: null,
        ispublic: null,
        isdel: null,
      },
      dialogFormVisible: false,
      fullscreenLoading: false,
      messageList:[]
    };
  },
  created() {
    this.getList();
  },
  mounted() {
    const { dataList } = this.$props;
    console.log(dataList);
  },
  methods: {
    getList() {
      this.loading = true;
      listMessage(this.queryParams).then((res) => {
        console.log(res.rows);
        this.messageList = res.rows;
        // this.total = response.total;
        this.loading = false;
      });
    },
    handleGetClick() {
      this.dialogFormVisible = true;
    },
    handleOpen() {
      this.$alert(
        "您的查询码为  YDH89398KIUVJ8KI",
        " 提示：可通过查询码快速查询留言结果 ",
        {
          confirmButtonText: "复制查询码",
          callback: (action) => {
            navigator.clipboard.writeText("YDH89398KIUVJ8KI");
            this.$message({
              type: "success",
              message: `复制成功`,
            });
          },
        }
      );
    },
    handleSub() {
      this.fullscreenLoading = true;
      setTimeout(() => {
        this.fullscreenLoading = false;
      }, 2000);
    },
  },
};
</script>
<style scoped lang="scss">
.header {
  display: flex;
  justify-content: space-between;
  margin: 0 40px;
  margin-top: 20px;
}
.content {
  background-color: #ffffff;
  width: 100%;
  //   height: auto;
  //   min-height: 10vh;
  //   max-height: 110vh;
  max-height: 40vh;
  height: auto;
  margin: 20px 0;
  overflow: auto;
  .wenzi {
    padding: 4px;
    width: 22px;
    height: 24px;
    line-height: 20px;
    background-color: rgba(245, 154, 35, 1);
    border-radius: 2px;
    color: #ffffff;
    font-size: 13px;
    margin: 0 10px;
  }
}

.flex {
  display: flex;
  align-items: center;
}
.dialog-footer {
  display: flex;
  justify-content: center;
}
</style>