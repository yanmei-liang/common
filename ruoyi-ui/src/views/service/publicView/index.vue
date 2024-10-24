<template>
  <div class="container">
    <!-- <img src="../../../assets/images/login-background.jpg" alt="" /> -->
    <div class="header">
      <p>公众互动交流</p>
      <div class="btn">
        <el-button @click="() => (currentComponent = 'Message')"
          >留言咨询</el-button
        >
        <el-button @click="() => (currentComponent = 'writing')"
          >地名征文</el-button
        >
      </div>
    </div>
    <div class="content">
      <component
        :is="currentComponent"
        :loading="loading"
        :dataList="messageList"
      ></component>
    </div>
  </div>
</template>
<script>
import Message from "./Message.vue";
import Writing from "./writing.vue";

export default {
  components: { Message, Writing },
  data() {
    return {
      currentComponent: "Message",
 
      loading: false,
      messageList: [],
    };
  },


  methods: {

  },
};
</script>
<style scoped lang="scss">
.container {
  display: block;
  margin-top: 10px;
  // height: calc(100vh - 94px);
  background-color: #f2f2f2;
  .header {
    width: 100%;
    height: 200px;
    background-image: url("../../../assets/images/login-background.jpg");
    background-size: cover;
    position: relative;
    display: flex;
    p {
      font-family: "Arial Negreta", "Arial Normal", "Arial", sans-serif;
      font-weight: 700;
      font-style: normal;
      font-size: 48px;
      color: #ffffff;
      margin-left: 100px;
    }
    .btn {
      margin-left: 100px;
      position: absolute;
      bottom: 0;
      .el-button {
        font-size: 18px;
        padding: 15px 30px;
      }
    }
  }
  .content {
    overflow: hidden;
    height: 100%;
  }
}
</style>