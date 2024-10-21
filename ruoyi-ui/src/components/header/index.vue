<template>
  <div>
    <el-container class="header_img">
      <el-header class="header">
        <div style="display: flex; align-items: center;margin:20px 0 0 0">
          <img
            src="../../assets/logo/logo.png"
            style="margin: 0 5px"
            alt="图片无法加载"
          />
          <p style="color:#FFFFFF;margin-top: 6vh;">十堰市行政区划服务平台</p>
        </div>
        <div class="cur" style="width: 70%; display: flex; margin: 0 auto">
          <div v-for="item in list" :key="item.id" @click="handRouter(item)">
            <div class="header-content">{{ item.name }}</div>
          </div>
        </div>
        <!-- <div>未登录</div> -->
      </el-header>
    </el-container>
  </div>
</template>
<script>
export default {
  data() {
    return {
      class11: "",
      list: [
        { name: "地名专题", id: "1", path: "/login", nameval: "login" },
        { name: "地名文化", id: "2", path: "/culture", nameval: "culture" },
        { name: "区划演变", id: "3", path: "/region", nameval: "region" },
        { name: "政策咨询", id: "4", path: "/policy", nameval: "policy" },
        { name: "公众互动", id: "5", path: "/public", nameval: "public" },
        { name: "管理系统", id: "6", path: "", nameval: "login" },
      ],
    };
  },
  mounted() {
    console.log(this.$route.path);
    //  console.log(this.$route.meta)
    //  if(this.$route.path == "/"){
    // document.getElementsByClassName("header-content")[0].className += " fixed";
    //  }else{
    document.getElementsByClassName("header-content")[
      sessionStorage.getItem("HEADERID")
    ].className += " fixed";
    //  }
  },
  methods: {
    handRouter(value) {
      if (
        value.name ==
        document.getElementsByClassName("header-content")[value.id - 1]
          .innerHTML
      ) {
        const arr = document.getElementsByClassName("header-content");
        for (let i = 0; i < arr.length; i++) {
          arr[i].classList.remove("fixed");
        }
        arr[value.id - 1].className += " fixed";
        sessionStorage.setItem("HEADERID", value.id - 1);
      }

      this.$router.push("/");
      this.$router.push(value.nameval);
      // console.log(value.id - 1,document.getElementsByClassName("header-content"))
    },
  },
};
</script>
<style scoped lang="scss">
.header {
  height: 24px;
  display: flex;
  align-items: center;
  // justify-content: space-around;
  // background-image: url("../../assets/images/login-background.jpg");
  // background-size: cover;
  img{
    width: 50px;
  }
  .cur{
    position: absolute;
    bottom: 0;
    left: 30%;
  }
}
.fixed {
  background-color: #409eff;
  border-radius: 10px;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
}
.header-content {
  margin: 0 15px;
  padding: 15px;
  font-size: 20px;
  color: #FFFFFF;
  &:hover {
    background-color: #409eff;
    border-radius: 10px;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    /* 动画名称和持续时间 */
    animation: pulse 3s infinite;
    margin: 0 15px;
    padding: 15px;
    font-size: 20px;
  }
  @keyframes pulse {
    0% {
      box-shadow: 0 0 0 0 rgba(255, 255, 255, 0.7);
    }
    70% {
      box-shadow: 0 0 20px 20px rgba(255, 255, 255, 0);
    }
    100% {
      box-shadow: 0 0 0 0 rgba(255, 255, 255, 0);
    }
  }
  .animated-button:hover {
    animation: pulse-hover 1s infinite;
  }

  @keyframes pulse-hover {
    0% {
      box-shadow: 0 0 20px 20px rgba(255, 255, 255, 0.4);
    }
    70% {
      box-shadow: 0 0 20px 20px rgba(255, 255, 255, 0);
    }
    100% {
      box-shadow: 0 0 0 0 rgba(255, 255, 255, 0);
    }
  }
}
.header_img {
  width: 100%;
  height: 20vh;
  background-image: url("../../assets/images/shiyanLogo.png");
  background-size: cover;
  background-position: 0 -130px;
  position: relative;
  p {
    font-size: 30px;
    color: #ffffff;
    font-weight: 1000;
    font-family: "华文隶书 Bold", "华文隶书 Regular", '华文隶书', sans-serif;
    // margin: 15px;
  }
}

</style>
