<template>
  <div class="container">
    <el-row>
      <el-col
        :span="7"
        v-for="(o, index) in 13"
        :key="o"
        :offset="index % 3 ? 1 : 0"
      >
        <el-card class="cur"
          :body-style="{ padding: '0px', display: 'flex', height: '240px' }"
        >
          <img  @click="handSetRead(o)"
            src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
            class="image"
         
          />
          <div>
            <h4>十堰市电子地名实录</h4>
            <p>作者：李大海</p>
            <span
              >简介："十堰电子地名丛书涵盖了十堰市及其所辖县（市区）、乡镇（街道）、社区（村）等各类行政区划名称，以及公路、街巷、桥梁、隧道、车站、",</span
            >
            <!-- <span>好吃的汉堡</span>
            <div class="bottom clearfix">
              <time class="time">{{ currentDate }}</time>
              <el-button type="text" class="button">操作按钮</el-button>
            </div> -->
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
<script>
export default {
  props: ["card"],
  data() {
    return {};
  },
  computed: {},
  methods: {
    handSetRead(value) {
       this.$router.push({path:'/culture/loadPhotos'})
      console.log(value)
      // console.log('1111',value);
    },
  },
};
</script>

<style scoped>
.image {
  width: 180px;
  padding: 20px;
  border-radius: 15px;
}
h4 {
  font-weight: 700;
}
span {
  font-size: 14px;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 6;
  overflow: hidden;
  text-overflow: ellipsis;
}
.el-col-offset-1,
.el-col-offset-0 {
  margin-top: 1%;
}
</style>
