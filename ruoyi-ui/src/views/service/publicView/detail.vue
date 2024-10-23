<template>
  <div class="container">
    <!-- <div class="pos"> -->
    <!-- <Breadcrumb /> -->
    <!-- </div> -->
    <div class="content">
      <h1>{{ list.title }}</h1>
      <p>
        {{ list.date }}
        <span style="margin: 0 40px">上传人: {{ list.pople }}</span>
        <span>
          点赞:
          <img
            @click="
              () => {
                (zuan = !zuan), list.zuan++;
              }
            "
            v-show="zuan"
            style="width: 20px"
            src="@/assets/images/zuan.png"
            alt=""
          />
          <img
            @click="
              () => {
                (zuan = !zuan), list.zuan--;
              }
            "
            v-show="!zuan"
            style="width: 20px"
            src="@/assets/images/zuan1.png"
            alt=""
          />
          {{ list.zuan }}</span
        >
      </p>
      <img src="../../../assets/images/detail.png" alt="" />
      <p>
        {{ list.content }}
      </p>
    </div>
  </div>
</template>
<script>
import Breadcrumb from "@/components/Breadcrumb/index.vue";
export default {
  components: { Breadcrumb },
  data() {
    return {
      aaa: "1111",
      list: "",
      zuan: true,
    };
  },
  mounted() {
    this.list = this.$route.query;
    // console.log(this.$route.query)
  },
};
</script>
<style scoped lang="scss">
.container {
  overflow: hidden;
  margin-bottom: 15vh;
}
.pos {
  height: 80px;
  width: 100%;
  background-color: #ffffff;
  display: flex;
  align-items: center;
}
.content {
  width: 50%;
  margin: 0 auto;
  margin-top: 6vh;
  text-align: center;

  img {
    width: 80%;
  }
}
</style>
