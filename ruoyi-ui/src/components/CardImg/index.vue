<template>
  <div style="width: 100%">
    <div v-for="item in cardVal" :key="item.id">
      <div class="content">
        <el-row style="width: 90%; height: 100px">
          <el-col :span="16">
            <div class="flex_align">
              <h3 style="font-weight: 700">{{ item.name }}</h3>
              <div
                class="flex_align realistic"
                v-if="item.scene"
                @click="realistic(item)"
              >
                <img
                  style="width: 25px; padding: 5px"
                  src="../../assets/images/5.png"
                  alt=""
                />
                <p style="color: rgb(24, 128, 182); font-size: 14px">实景</p>
              </div>
            </div>
            <p
              style="
                margin-top: 5px;
                margin-left: 10px;
                font-size: 13px;
                color: rgb(127, 127, 127);
              "
            >
              {{ item.place }}
            </p>
          </el-col>
          <el-col :span="8" class="col1">
            <!-- {{item.img}} -->
            <div v-if="!!item.img">
              <img src="../../assets/images/login-background.jpg" alt="" />
              <div class="readImg" @click="handRead(item)">查看图片</div>
            </div>
            <div v-else>
              <img src="../../assets/images/login-background.jpg" alt="" />
            </div>
          </el-col>
        </el-row>
      </div>
      <el-divider class="divider"></el-divider>
    </div>

    <el-dialog
      title=""
      :visible="dialogVisible"
      width="100%"
      :before-close="handleClose"
      :fullscreen="true"
      :modal="false"
    >
      <el-row style="display: flex; align-items: center">
        <el-col :span="5">
          <h1>武当山风景区售票处</h1>
        </el-col>
        <el-col :span="4">
          <el-button type="primary" @click="handImg">
            <!-- <img
              style="width: 25px; padding: 5px"
              src="../../assets/images/5.png"
              alt=""
            /> -->
            <span>实景查看</span>
          </el-button>
        </el-col>
      </el-row>
      <el-row>
        <el-col :span="16">
          <img src="../../assets/images/login-background.jpg" alt=""
        /></el-col>
        <el-col :span="8">
          <div>
            <SearchLoad :dataList="dataList" class="search-load">
              <template>
                <img src="@/assets/images/login-background.jpg" alt="" />
                <img src="@/assets/images/login-background.jpg" alt="" />
                <img src="@/assets/images/login-background.jpg" alt="" />
                <img src="@/assets/images/login-background.jpg" alt="" />
                <img src="@/assets/images/login-background.jpg" alt="" />
                <img src="@/assets/images/login-background.jpg" alt="" />
              </template>
            </SearchLoad>
          </div>
        </el-col>
      </el-row>
    </el-dialog>
  </div>
</template>
<script>
import SearchLoad from "@/views/service/searchLoad/index.vue";
export default {
  components: { SearchLoad },
  props: ["cardVal"],
  data() {
    return {
      dialogVisible: false,
      dataList: null,
    };
  },
  methods: {
    handRead(val) {
      this.dataList = {
        header: false,
        name: "武当山风景区售票处",
        address: "十堰市丹江口市武当山特区永乐路14号",
        name1: "事件纪念地现今地名",
        jiedao: "永乐街道",
        laiyuan: "实地调查",
        jianjie:
          "武当山风景区1号停车场位于永乐路14号武当山风景区，靠近武当路、G316和金街，是游客游览武当山的重要交通枢纽。该停车场地理位置优越，与售票大厅相邻，方便游客购票后直接进入停车场。停车场设有明显的指示标志，方便游客快速找到停车位置。收费标准合理，每小时3元，24小时以内25元封顶。此外，停车场周边有多个公交站，包括武当山、武当山门等，可换乘206路、十堰武当山机场巴士2号线、十堰客运巴士班线等多条公交线路，为游客提供了便捷的交通选择",
      };
      console.log(val);
      // this.$router.replace('https://vr.baidu.com/vrcc/pano-share.html?shareId=share_9c47e87f9')
      this.dialogVisible = true;
    },
    handImg() {
      window.open(
        "https://vr.baidu.com/vrcc/pano-share.html?shareId=share_9c47e87f9"
      );
    },
    realistic(value) {
      window.open(
        "https://vr.baidu.com/vrcc/pano-share.html?shareId=share_9c47e87f9"
      );
      console.log("实景图片", value);
    },
    handleClose() {
      console.log(this.dialogVisible);
      this.dialogVisible = false;
    },
  },
};
</script>

<style scoped lang="scss">
.content {
  width: 100%;
  height: 100px;
  background-color: aliceblue;
  /* margin: 0 auto; */
  display: flex;
  justify-content: center;
  align-items: center;
}
p {
  font-size: 12px;
}
img {
  max-width: 100%; /* 图片宽度不超过容器宽度 */
  max-height: 100%;
  // position: relative;
  // &::after {
  //   content: "Text Over Image";
  //   // position: absolute;
  //   // left: 10px;
  //   // top: 10px;
  //   color: black;
  //   z-index: 9999;
  // }
}
::v-deep .col1 {
  height: 100%;
  display: flex;
  align-items: center;
  position: relative;
}
.readImg {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  font-size: 12px;
  color: aliceblue;
  cursor: pointer;
}
.realistic {
  cursor: pointer;
  color: aqua;
}
.search-load {
  height: 60vh;
  p {
    font-size: 16px;
  }
}
::v-deep .el-dialog__headerbtn{
  font-size: 40px;
}
</style>
