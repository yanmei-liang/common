<template>
  <div class="container">
    <div class="breadcrumb">
       <Breadcrumb />
    </div>
    <el-carousel
      arrow="always"
      trigger="click"
      style="width: 100%; height: 800px"
    >
      <!-- <el-carousel-item v-for="item in 4" height="800px" :key="item"> -->
      <div id="mapDiv"></div>
      <!-- </el-carousel-item> -->
    </el-carousel>

    <div class="carousel" v-show="!setMap">
      <div class="flex">
        <i class="el-icon-arrow-down" @click="() => (setMap = !setMap)"></i>
      </div>
      <div class="img_list">
        <div v-for="item in 6" :key="item">
          <img
            src="http://api.tianditu.gov.cn/staticimage?center=116.40,39.93&width=500&height=500&zoom=13&layers= ter_c,cta_c&tk=525ecf8803a6268acc612ba1ae3e3065"
            alt=""
          />
        </div>
      </div>
    </div>
    <div v-show="setMap" class="carousel" style="height: 25px">
      <div class="flex" @click="() => (setMap = !setMap)">
        <i class="el-icon-arrow-up">点击展开</i>
      </div>
    </div>
  </div>
</template>
<script>
import Axios from "axios";
import Breadcrumb from "@/components/Breadcrumb/index.vue";
export default {
  components:{Breadcrumb},
  data() {
    return {
      setMap: false,
    };
  },
  mounted() {
    const m =
      "http://api.tianditu.gov.cn/staticimage?center=116.40,39.93&width=400&height=300&zoom=10&layers=vec_c,eva_c&tk=525ecf8803a6268acc612ba1ae3e3065";
    Axios.get(m).then((res) => {
      console.log(res);
    });

    var map;
    var zoom = 12;
    map = new T.Map("mapDiv", {
      projection: "EPSG:4326",
    });
    map.centerAndZoom(new T.LngLat(116.40769, 39.89945), zoom);
    var line = "";
    var points = [];
    points.push(new T.LngLat(116.41136, 39.97569));
    points.push(new T.LngLat(116.411794, 39.9068));
    points.push(new T.LngLat(116.32969, 39.9294));
    points.push(new T.LngLat(116.385438, 39.9061));
    map.enableDrag();
    // points.push([...points]);
    //创建线对象
    line = new T.Polyline(points, {
      showLabel: false, //测距功能展示
      color: "red",
      weight: 5,
      opacity: 1,
      fillColor: "#FFFFFF",
      fillOpacity: 0.5,
    });
    // this.line = line;
    //向地图上添加线
    map.addOverLay(line);
    line.addEventListener("click", this.LineClick);
  },
  methods: {
    getCarousel(value) {
      console.log(value);
    },
  },
};
</script>
<style scoped>

.img_list {
  display: flex;
  align-items: center;
  /* justify-content: space-around; */
  overflow: auto;
}
img {
  width: 200px;
  height: 150px;
  margin: 0 20px;
}
.carousel {
  position: absolute;
  bottom: 50px;
  left: 20%;
  width: 60%;
  height: 200px;
  background-color: rgba(85, 85, 85, 0.552941176470588);
  z-index: 999;
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.el-icon-arrow-down {
  font-weight: 1000 !important;
  font-size: 35px !important;
}
.el-icon-arrow-up {
  font-weight: 800;
  align-items: center;
}
.flex {
  justify-content: center;
}
#mapDiv {
  max-height: 100%;
  max-width: 100%;
}
::v-deep .el-carousel__container {
  height: 100vh !important;
}
::v-deep .el-carousel__arrow {
  z-index: 99999;
  background-color: black;
  width: 50px;
  height: 50px;
}
.breadcrumb{
  border-radius: 10px;
}
</style>
