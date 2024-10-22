<template>
  <div class="container">
    <div style="margin-left: 50px; display: flex">
      <div style="margin-top: 20px">
        <p>湖北省十堰市</p>
      </div>
      <div style="margin-top: 50px">
        <p>地名文化博物馆</p>
      </div>
    </div>

    <div class="flex pos">
      <div class="" v-for="item in arrList" :key="item" @click="handName(item)">
        <div class="flex">
          <div class="line"></div>
          <span class="cur">{{ item.title }}</span>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import {
  listMedia,
  getMedia,
  delMedia,
  addMedia,
  updateMedia,
} from "@/api/system/media";
export default {
  data() {
    return {
      arrList: [
        {
          id: "1",
          title: "电子地名文化丛书",
          path: "loadcultureCate",
        },
        {
          id: "2",
          title: "电子图集挂图",
          path: "loadPhotos",
        },
        {
          id: "3",
          title: "地名故事影音",
          path: "loadVedio",
        },
        {
          id: "4",
          title: "古镇、古村地名文化",
          path: "villagesnames",
        },
        {
          id: "5",
          title: "文化遗产目录",
          path: "heritageView",
        },
      ],

      dataList: null,
    };
  },
  created() {
    this.$nextTick(() => {
      this.onLoad();
    });
  },
  mounted() {
    // const route = this.$router.options.routes.filter((item) => {
    //   return item.name == "culture";
    // });
    // // this.arrList.push(...route[0].children);
    // route[0].children.forEach((item) => {
    //   if (item.meta && item.meta.title) {
    //     this.arrList.push(item);
    //   }
    // });
  },
  methods: {
    onLoad() {
      // listMedia(this.queryParams).then((res) => {
      //   // console.log(res.rows)
      //   this.dataList = res.rows;
      //   // this.mediaList = response.rows;
      //   // this.total = response.total;
      //   // this.loading = false;
      // });
    },
    handName(val) {
      // const arr = this.dataList.filter((item) => {
      //   return item.type == val.id
      // });
      this.$router.push({ path: val.path ,query:{...val}});
      // console.log(this.$router.push({path:'culture/cultureIndex/loadcultureCate/index'}))
      // this.$router.go(0)
      // this.$router.push({ name: value.path });
    },
  },
};
</script>
<style scoped lang="scss">
.container {
  background-image: url("~@/assets/images/login-background.jpg");
  background-size: cover;
}
p {
  font-family: "Arial Normal", "Arial", sans-serif;
  font-weight: 400;
  font-style: normal;
  font-size: 60px;
  color: #ffffff;
  text-shadow: 5px 5px 5px black;
  writing-mode: vertical-rl;
  letter-spacing: 14px;
}
.cur {
  color: rgba(255, 255, 0, 0.51);
  //   display: flex;
  //   justify-content: space-between;
  &:hover {
    color: rgba(0, 0, 255, 0.477);
  }
}
span {
  font-family: "华文隶书 Bold", "华文隶书 Regular", 华文隶书, sans-serif;
  font-weight: 700;
  font-style: normal;
  font-size: 40px;
  color: rgb(255, 255, 0);
  writing-mode: vertical-rl;
  letter-spacing: 10px;
}
.line {
  width: 3px;
  height: 500px;
  background-color: #ffffff;
  margin: 0 20px;
}
.pos {
  position: absolute;
  right: 100px;
  top: 8vw;
}
</style>
