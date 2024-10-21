<template>
  <div class="container">
    <div class="pos">
      <Breadcrumb />
    </div>
    <div class="content">
      <h1>快讯：习近平同马来西亚最高元首易卜拉欣会谈</h1>
      <p>2024-09-20 16:45 来源： 新华社</p>
      <img src="../../../../assets/images/detail.png" alt="" />
      <p>
        9月20日下午，国家主席习近平在北京人民大会堂同来华进行国事访问的马来西亚最高元首易卜拉欣举行会谈。
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
    };
  },
};
</script>
<style scoped lang="scss">
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
    img{
        width: 80%;
    }
}
</style>
