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
import {
  listMedia,
  getMedia,
  delMedia,
  addMedia,
  updateMedia,
} from "@/api/system/media";
export default {
  components: { LoadcultureCate },
  data() {
    return {
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        type: null,
        name: null,
        author: null,
        area: null,
        mainimg: null,
        content: null,
        isshow: null,
        createuer: null,
        createtime: null,
        isdel: null,
      },
    };
  },
  created() {},
  mounted() {
    
    const data = { ...this.queryParams, type: "故事影音" };
    listMedia(data).then((res) => {
      console.log(this.queryParams,res.rows,data);
      this.cardContent = res.rows;
    });
  },
  watch: {},
  methods: {},
};
</script>
<style scoped>
.imgfont {
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
