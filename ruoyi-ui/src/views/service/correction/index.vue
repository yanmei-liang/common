<template>
  <div style="overflow: auto">
    <div class="header_img">
      <span style="margin-left: 50px"> 地名监督纠错</span>
    </div>
    <div class="content">
      <p style="border-bottom: 1px solid black; padding-bottom: 10px">
        纠错信息填写
      </p>
      <div style="margin: 0 50px">
        <el-form ref="form" :model="form" label-width="120px">
          <el-form-item required label="地点名称">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item required label="编辑位置">
            <div id="mapDiv"></div>
          </el-form-item>
          <el-form-item required label=" 地点来历">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item required label=" 历史沿革">
            <el-input v-model="form.jianjie"></el-input>
          </el-form-item>
          <el-form-item required label=" 地理实体描述">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item required label=" 资料来源">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item required label=" 资料来源">
            <ImageUpload :fileSize="3" />
          </el-form-item>
        </el-form>
      </div>
      <p style="border-bottom: 1px solid black; padding-bottom: 10px">
        个人信息填写
        <span>（请放心填写，管理员会严格保密您的个人信息）</span>
      </p>
      <div style="margin: 0 50px">
        <el-form ref="form" :model="form" label-width="120px">
          <el-form-item required label=" 联系姓名">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item required label=" 联系电话">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item required label=" 电子邮箱">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item required label=" 验证码">
            <el-input v-model="form.name"></el-input>
          </el-form-item>
          <el-form-item required style="display: flex; justify-content: center">
            <el-button
              style="margin-right: 80px"
              type="primary"
              @click="onSubmit"
              >立即创建</el-button
            >
          </el-form-item>
        </el-form>
      </div>
    </div>
  </div>
</template>
<script>
import ImageUpload from "@/components/ImageUpload/index";
import { number } from "echarts";
export default {
  components: { ImageUpload },
  data() {
    return {
      form: {
        name: "",
        region: "",
        date1: "",
        date2: "",
        delivery: false,
        type: [],
        resource: "",
        desc: "",
        pointarr: "",
        jianjie: "",
      },
      map: "",
      marker: "",
      zoom: 12,
    };
  },
  created() {},
  mounted() {
    // console.log(this.$route.params.dataList)
    // const { dataList } = this.$route.params;
    // if (!!dataList) {
    //   this.form = {
    //     name: dataList.name,
    //     pointarr: dataList.pointarr,
    //     jianjie: dataList.jianjie,
    //   };
    // }
    this.$nextTick(() => {
      this.onLoad();
       this.marker.enableDragging();
    });

   
  },
  methods: {
    onSubmit() {},
    onLoad() {
      //初始化地图对象
      const { dataList } = this.$route.params;
      if (!!dataList) {
        this.form = {
          name: dataList.name,
          pointarr: dataList.pointarr,
          jianjie: dataList.jianjie,
        };
      }
      this.map = new T.Map("mapDiv");
      // const center = (this.form.pointarr || "110.8065, 32.62129").split(",")
      // console.log("center",this.map,this.form.pointarr.split(",")[0]);
      //设置显示地图的中心点和级别
      this.map.centerAndZoom(new T.LngLat(116.40769, 39.89945), this.zoom);
      var point = new T.LngLat(116.40769, 39.89945);
      this.marker = new T.Marker(point); // 创建标注
      this.map.addOverLay(this.marker); // 将标注添加到地图中
      this.marker.disableDragging(); // 不可拖拽
    },
  },
};
</script>
<style scoped lang="scss">
.header_img {
  width: 100%;
  height: 150px;
  line-height: 150px;
  background-color: blue;
  font-size: 35px;
  color: #ffffff;
  font-weight: 800;
}
.content {
  // background-color: yellowgreen;
  // padding: 5vh;
  margin: 0 100px;
  overflow: auto;
}
#mapDiv {
  width: 100%;
  height: 400px;
  z-index: 1;
}
</style>