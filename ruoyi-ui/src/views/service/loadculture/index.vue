<template>
  <div class="container">
    <div style="margin-left: 50px; display: flex">
      <div style="margin-top: 20px">
        <p>湖北省十堰市</p>
      </div>
      <div style="margin-top:50px">
        <p>地名文化博物馆</p>
      </div>
    </div>

    <div class="flex pos">
      <div class="" v-for="item in arrList" :key="item" @click="handName(item)">
        <div class="flex">
          <div class="line"></div>
          <span class="cur">{{ item.meta.title }}</span>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import TopNav from "@/components/TopNav/index.vue";
export default {
  components: { TopNav },
  data() {
    return {
      arrList: [],
    };
  },
  mounted() {
    const route = this.$router.options.routes.filter((item) => {
      return item.name == "culture";
    });
    // this.arrList.push(...route[0].children);
    route[0].children.forEach((item) => {
      if (item.meta && item.meta.title) {
        this.arrList.push(item);
      }
    });
  },
  methods: {
    handName(value) {
      // this.$router.go(0)
      this.$router.push({ name: value.path });
    },
  },
};
</script>
<style scoped lang="scss">
.container {
  background-image: url('~@/assets/images/login-background.jpg');
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
  color: yellow;
  //   display: flex;
  //   justify-content: space-between;
  &:hover {
    color: blue;
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
  top: 12vw;
}
</style>
