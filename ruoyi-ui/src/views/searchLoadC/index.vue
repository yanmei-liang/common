<template>
  <div class="_container">
    <!-- <el-row>
      <i class="el-icon-back cur position_img_left" @click="goBack">返回</i>
      <i class="el-icon-view cur position_img_right" @click="goBack">实景</i>
      <el-col :span="24">
        <img
          src="../../assets/images/login-background.jpg"
          width="100%"
          height="200px"
          alt=""
        />
      </el-col>
    </el-row> -->
    <div
      class="flex_align"
      style="
        justify-content: space-around;
        background-color: rgb(240, 248, 254);
      "
    >
      <h3>109省道南延长线</h3>
      <p>点赞</p>
    </div>
    <el-row>
      <el-col :span="10" v-for="item in 3" :key="item">
        <img
          src="../../assets/images/login-background.jpg"
          width="100%"
          height="200px"
          alt=""
        />
      </el-col>

    </el-row>
  </div>
</template>
<script>
import searchLoad from "../loginName/index.vue";
export default {
  components: {},
  data() {
    return {};
  },
  methods: {
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
._container {
  width: 400px;
  padding: 0;
  margin: 0;
}
img {
  position: relative;
  max-width: 100%;
  max-height: 100%;
  margin-top: 10px;
}
</style>
