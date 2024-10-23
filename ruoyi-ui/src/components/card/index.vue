<template>
  <div class="container">
    <el-row :gutter="20">
      <el-col  style="margin:10px 0"
        :span="8"
        v-for="item in card"
        :key="item"
      >
        <el-card
        v-if="!item.isshow"
          class="cur"
          :body-style="{ padding: '0px', display: 'flex', height: '240px' }"
        >
          <img
            v-if="item.mainimg"
            @click="handSetRead(item)"
            :src="dataImg(item.mainimg)"
            class="image"
          />
          <img
            v-else
            @click="handSetRead(item)"
            src="@/assets/images/tupian.webp"
            class="image"
          />
          <div>
            <h4>{{ item.name }}</h4>
            <p>作者：{{ item.author }}</p>
            <span>简介：{{ item.content }} </span>
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
  computed: {
  
  },
  methods: {
    handSetRead(value) {
      // this.$router.push({ path: "/loadPhotos" });
      console.log(value);
      // console.log('1111',value);
    },
      dataImg(val){
        console.log(val.split('.jpg')[0]+'.jpg')
        return val.split('.jpg')[0]+'.jpg'
    }
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
