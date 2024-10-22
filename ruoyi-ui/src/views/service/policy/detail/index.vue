<template>
  <div class="container">
    <!-- <div class="pos"> -->
      <!-- <Breadcrumb /> -->
    <!-- </div> -->
    <div class="content">
      <h1>快讯：{{list.title}}</h1>
      <p>2024-09-20 16:45 来源： {{list.resource}}</p>
      <img src="../../../../assets/images/detail.png" alt="" />
      <p>
       {{list.content}}
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
      list :''
    };
  },
  mounted(){
    this.list = this.$route.query
    console.log(this.$route.query)
  }
};
</script>
<style scoped lang="scss">
.container{
  overflow: auto;
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
    img{
        width: 80%;
    }
}
</style>
