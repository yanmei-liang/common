<template>
  <div>
    <div class="header">
      <el-button type="primary" @click="handleGetClick">上传资料</el-button>
      <div style="display: flex">
        <el-input v-model="input" placeholder="请输入标题"></el-input>
        <el-button type="primary" @click="handleSub">查询</el-button>
        <el-button type="info">重置</el-button>
      </div>
    </div>
    <div v-loading="fullscreenLoading" class="content">
      <div class="content_title">
        <el-row>
          <el-col :span="4" :offset="1">序号</el-col>
          <el-col :span="10">标题</el-col>
          <el-col :span="5">上传人</el-col>
          <el-col :span="4">上传时间</el-col>
        </el-row>
        <el-row
          style="margin: 10px 0; font-size: 14px"
          v-for="item in 40"
          :key="item"
        >
          <el-col :span="4" :offset="1">{{ item }}</el-col>
          <el-col :span="10" class="el_col" style="color: #027db4">
            <div @click="handleClickTitle(item)">武当山赞颂诗集</div>
          </el-col>
          <el-col :span="5">张立强</el-col>
          <el-col :span="4">2024.10.3 16:27:21</el-col>
        </el-row>
      </div>
    </div>

    <!-- 弹框 -->
    <el-dialog title="上传资料" :visible.sync="dialogFormVisible">
      <el-form :model="form" label-position="top">
        <!-- <el-form-item label="留言内容" required prop="desc">
          <el-input
            type="textarea"
            v-model="form.desc"
            maxlength="300"
          ></el-input>
        </el-form-item> -->
        <el-form-item label="请输入验证码" required prop="desc">
          <el-input type="input" v-model="form.desc"></el-input>
        </el-form-item>
        <el-form-item label="内容" required>
          <Editor :height="150" />
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
import Editor from "@/components/Editor/index.vue";
export default {
  components: { Editor },
  data() {
    return {
      dialogFormVisible: false,
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
      fullscreenLoading: false,
    };
  },
  methods: {
    handleGetClick() {
      this.dialogFormVisible = true;
    },
    handleOpen() {
      this.$message({
        message: "提交成功，等待管理员审核",
        type: "success",
        offset: 200,
      });
      this.dialogFormVisible = false;
    },
    handleClickTitle(val) {
      //   console.log("val", val);
      const list = {
        title: "武当山赞颂诗集",
        date: "2024-09-20 16:45",
        pople: "张立强",
        zuan: "11",
        imgurl: "",
        content:
          "湖北十堰三张名片驰名中外 “仙山、秀水、汽车城”十堰市位于湖北省西北部，是鄂西生态文化旅游圈的中心城市。别称车城，中国卡车之都。独特的地理位置，使十堰自古有“南跨荆襄、北枕商洛、东抚南阳、西掖汉中”之誉，并“南船北马、川陕咽喉、四省通衢”之称。作为全国内陆地区唯一的国家级园林城市，山清水秀、景色迷人，拥有世界文化遗产、道教圣地——武当山，山上奇峰怪石、激湍飞流、云腾雾蒸，是典型的山岳风景旅游胜地。境内还有黄龙古镇、丹江口大坝、太极峡风景区、龙吟峡、虎豹峡景区、九华山森林公园和野人谷野人洞等景点。",
      };
      this.$router.push({ path: "tiaozhuan/publicViewDetail", query: list });
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
  .content_title {
    // display: flex;
    // justify-content: space-between;
    margin: 20px;
  }
  background-color: #ffffff;
  width: 100%;
  max-height: 40vh;
  height: auto;
  overflow: auto;
}
.el_col:hover {
  text-decoration: underline;
  cursor: pointer;
}
.dialog-footer {
  display: flex;
  justify-content: center;
}
</style>