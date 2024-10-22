<template>
  <div class="_container">
    <el-row  v-if="dataList.header">
      <i class="el-icon-back cur position_img_left" @click="goBack">返回</i>
      <i class="el-icon-view cur position_img_right" @click="handleImage"
        >实景</i
      >
      <el-col :span="24">
        <img
          src="@/assets/images/login-background.jpg"
          width="100%"
          height="200px"
          alt=""
        />
      </el-col>
    </el-row>
    <div style="background-color: rgb(240, 248, 254);overflow:auto;height:40vh">
      <div class="flex_align" style="justify-content: space-between">
        <h3 style="font-weight:700">{{ dataList.name }}</h3>
          <i class="el-icon-thumb">点赞（10）</i>
      </div>
      <div style="padding: 0 20px 10px 20px">
        <p>地址：{{ dataList.address }}</p>
        <!-- <p>类别名称：{{ dataList.name1 }}</p>
        <p>所属街道：{{ dataList.jiedao }}</p>
        <p>数据来源：{{ dataList.laiyuan }}</p> -->
        <p>备注：{{ dataList.jianjie }}</p>
      </div>
      <div class="imgs">
        <slot></slot>
      </div>
    </div>
  
  </div>
</template>
<script>
import searchLoad from "../loginName/index.vue";
export default {
  components: {},
  props: ["dataList"],
  data() {
    return {};
  },
  mounted(){
    console.log(this.$props.dataList)
  },
  methods: {
    handleImage() {
      window.open(
        "https://vr.baidu.com/vrcc/pano-share.html?shareId=share_9c47e87f9"
      );
    },
    goBack() {
      const value = {
        btn: true,
        queryPlaceVal: true,
      };
      this.$emit("update-value", value);
    },
  },
};
</script>
<style scoped lang="scss">
.flex_align {
  padding: 0 20px;
}
._container {
  width:28vw;
  padding: 0;
  margin: 0;
}
img {
  position: relative;
  max-width: 100%;
  max-height: 100%;
  margin-top: 10px;
}
p {
  font-size: 12px;
}
.imgs{
  display: flex;
  justify-content: space-around;
  flex-wrap: wrap;
  img{
    width: 30%;
  }
}
</style>
