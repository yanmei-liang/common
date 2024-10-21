<template>
  <div class="container">
    <LoadcultureCate>
      <div class="moudle">
        <div v-for="item in 9" class="moudle_child" :key="item">
          <img src="@/assets/images/login-background.jpg" alt="" />
          <div class="imgfont">十堰市街道介绍视频</div>
        </div>
      </div>
    </LoadcultureCate>
  </div>
</template>
<script>
import LoadcultureCate from "../../loadcultureCate copy/index.vue";
export default {
  components: { LoadcultureCate },
  data() {
    return {};
  },
  created() {},
  mounted() {
    console.log();
  },
  watch: {},
  methods: {},
};
</script>
<style scoped>
.imgfont{
  width: 100%;
  position: absolute;
  bottom: 20px;
  z-index: 999;
  color: #ffffff;
 
}
.moudle_child {
  width: 400px;
  height: 200px;
  position: relative;
  text-align: center;
}
.moudle {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
}
img {
  width: 100%;
  height: 100%;
  padding: 10px;

}
</style>
