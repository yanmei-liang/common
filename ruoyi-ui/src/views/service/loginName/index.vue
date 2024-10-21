<template>
  <div class="container">
    <!-- 地图 -->
    <el-container>
      <el-main>
        <div id="mapDiv"></div>
      </el-main>
    </el-container>
    <!-- 悬浮层 -->
    <div class="suspension">
      <QueryPlace
        v-if="queryPlaceVal"
        :parentData="message"
        :btn="butt"
        @setBtnBalue="getBtn"
      />
      <div v-if="btn">
        <div class="flex" v-show="dropDown">
          <div
            style="
              margin: 3px;
              background-color: rgb(240, 248, 254);
              border-radius: 5px;
              padding: 0 25px;
            "
          >
            <el-row style="text-align: center" class="image">
              <el-col
                :span="5"
                :offset="1"
                v-for="(item, index) in arrList"
                :key="item"
              >
                <div @click="setName(item)">
                  <img
                    :src="getImageSrc(index)"
                    :style="{ backgroundColor: color[index] }"
                    alt=""
                  />
                  <div>{{ item }}</div>
                </div>
                <!-- </router-link> -->
              </el-col>
            </el-row>

            <el-divider></el-divider>
            <div>
              <p>十堰市辖区县</p>
              <el-row>
                <el-col v-for="item in areaList" :key="item" :span="6"
                  ><a @click="handleAlert(item)"> {{ item }}</a
                  ><el-divider direction="vertical"
                /></el-col>
              </el-row>
            </div>
            <el-divider></el-divider>
            <div style="margin-bottom: 10px; padding-bottom: 20px">
              <p>最近搜索</p>
              <div>
                <el-alert style="margin-bottom: 10px" title="" type="info">
                  <el-link type="info" @click="handleAlert('十堰丹江口市')"
                    >十堰丹江口市</el-link
                  >
                </el-alert>
                <el-alert title="" type="info">
                  <el-link type="info" @click="handleAlert('武当山1号停车场')"
                    >武当山1号停车场</el-link
                  >
                </el-alert>
              </div>
            </div>
          </div>
          <div class="putAway" @click="putAway">
            <i class="el-icon-caret-top"></i>
            收起
          </div>
        </div>
        <div
          v-show="!dropDown"
          class="flex_align drop_down"
          @click="dropDown = !dropDown"
        >
          <p>点击展开</p>
          <i class="el-icon-caret-bottom"></i>
        </div>
      </div>
      <component
        v-else
        :is="currentComponent"
        @update-value="handleUpdateValue"
        :dataList="dataList"
      ></component>
    </div>
  </div>
</template>
<script lang="javascript">
import QueryPlace from "@/components/Query/index.vue";
import QueryCard from "@/components/card/index.vue";
import CardImg from "@/components/CardImg/index.vue";
import placeName from "../placeName/index.vue";
import searchLoad from "../searchLoad/index.vue";
import Axios from "axios";
export default {
  name: "Demo",
  components: { QueryPlace, QueryCard, CardImg, searchLoad, placeName },
  data() {
    return {
      dataList: [],
      color: [
        "rgb(74, 131, 242)",
        "rgb(61, 216, 153)",
        "rgb(247, 166, 98)",
        "rgb(254, 112, 99)",
      ],
      queryPlaceVal: true,
      setbtn: false,
      dropDown: true,
      currentComponent: "placeName",
      btn: true,
      arrList: ["特色地名", "历史地名", "乡村著名", "便民服务"],
      map: "",
      zoom: 12,
      message: {
        msg: "请输入地名",
        value: "",
        clearable: true,
        size: "medium ",
      },
      butt: {
        color: "primary",
        name: "查询",
      },
      cardContent: {
        width: "380px",
        col: 8,
        title: "名称名称名称",
        name: "李四",
        content:
          "十堰电子地名丛书涵盖了十堰市及其所辖县（市区）、乡镇（街道）、社区（村）等各类行政区划名称，以及公路、街巷、桥梁、隧道、车站、",
      },
      areaList: [
        "茅箭区",
        "张湾区",
        "郧阳区",
        "云溪区",
        "竹山县",
        "竹溪县",
        "房县区",
        "丹江口市",
      ],
      points: [],
      line: "",
      url: "tk=525ecf8803a6268acc612ba1ae3e3065",
      lianjie:
        "layers=vec_c,cva_c &paths=116.34867,39.94593;116.42626,39.94731;116.4551,39.90267 |116.43381,39.86766;116.34249,39.87178;116.32807,39.90748 &pathStyles=0xff0000,8,0.7|0x00ff00,19,1&",
    };
  },

  watch: {},
  created() {
    Axios.get(
      "http://api.tianditu.gov.cn/v2/administrative?keyword=156420302&childLevel=0&extensions=true&tk=525ecf8803a6268acc612ba1ae3e3065	"
    ).then((res) => {
      console.log(res);
    });
  },
  mounted() {
    this.onLoad();
  },
  methods: {
    handleAlert(val) {
      this.dataList = {
        header: true,
        name: val,
        address: "十堰市丹江口市武当山特区永乐路14号",
        name1: "事件纪念地现今地名",
        jiedao: "永乐街道",
        laiyuan: "实地调查",
        jianjie:
          "武当山风景区1号停车场位于永乐路14号武当山风景区，靠近武当路、G316和金街，是游客游览武当山的重要交通枢纽。该停车场地理位置优越，与售票大厅相邻，方便游客购票后直接进入停车场。停车场设有明显的指示标志，方便游客快速找到停车位置。收费标准合理，每小时3元，24小时以内25元封顶。此外，停车场周边有多个公交站，包括武当山、武当山门等，可换乘206路、十堰武当山机场巴士2号线、十堰客运巴士班线等多条公交线路，为游客提供了便捷的交通选择",
      };
      this.message = {
        value: val,
      };
      this.currentComponent = "searchLoad";
      this.queryPlaceVal = true;
      this.btn = false;
    },

    getImageSrc(index) {
      return require(`@/assets/images/${index + 1}.png`);
    },
    getBtn(value) {
      if (!!value && value != "") {
        Axios.get(
          `http://api.tianditu.gov.cn/v2/search?postStr={"queryType":13,"start":0,"count":5,"specify":"156110000","dataTypes":"${value}"}&type=query&tk=525ecf8803a6268acc612ba1ae3e3065`
        )
          .then((res) => {
            console.log(res);
          })
          .catch((err) => {
            console.log("er", err);
          });
        this.currentComponent = "searchLoad";
        this.queryPlaceVal = true;
        this.btn = false;
      }
    },
    putAway() {
      this.dropDown = !this.dropDown;
    },
    handleUpdateValue(value) {
      this.message = {
        value: "",
      };
      this.btn = value.btn;
      this.queryPlaceVal = value.queryPlaceVal;
      this.dropDown = true;
    },
    setName(arrlist) {
      this.currentComponent = "placeName";
      this.btn = false;
      this.queryPlaceVal = false;
    },
    onLoad() {
      var map;
      var zoom = 17;
      var data_info = [
        [110.8, 32.62, "地址:十堰市政府"],
        [110.8065, 32.6205, "地址:十堰市民政局"],
        // [116.406605, 39.921585, "地址:北京市东城区东华门大街"],
        // [116.412222, 39.912345, "地址:北京市东城区正义路甲5号"],
      ];
      map = new T.Map("mapDiv", {
        projection: "EPSG:4326",
      });
      map.centerAndZoom(new T.LngLat(110.8065, 32.62129), zoom);

      for (var i = 0; i < data_info.length; i++) {
        var marker = new T.Marker(
          new T.LngLat(data_info[i][0], data_info[i][1])
        ); // 创建标注
        var content = data_info[i][2];
        var latlng = new T.LngLat(data_info[i][0]+0.0002, data_info[i][1]+0.0005);
        var label = new T.Label({
          text: content,
          position: latlng,
          offset: new T.Point(-9, 0),
        });
        //创建地图文本对象
        map.addOverLay(label);
        map.addOverLay(marker); // 将标注添加到地图中
        // this.addClickHandler(content, marker);
      }

      // var line = "";
      // var points = [];
      // points.push(new T.LngLat(116.41136, 39.97569));
      // points.push(new T.LngLat(116.411794, 39.9068));
      // points.push(new T.LngLat(116.32969, 39.9294));
      // points.push(new T.LngLat(116.385438, 39.9061));
      // map.enableDrag();
      // this.points.push([...points]);
      // //创建线对象
      // line = new T.Polyline(points, {
      //   showLabel: false, //测距功能展示
      //   color: "red",
      //   weight: 5,
      //   opacity: 1,
      //   fillColor: "#FFFFFF",
      //   fillOpacity: 0.5,
      // });
      // this.line = line;
      // //向地图上添加线
      // map.addOverLay(line);
      // line.addEventListener("click", this.LineClick);
    },

    // LineClick(e) {
    //   console.log(
    //     "您点击了线",
    //     e.target.ht.join(","),
    //     "http://api.tianditu.gov.cn/geocoder?postStr=" +
    //       { ...e.target.ht } +
    //       "&type=geocode&tk=525ecf8803a6268acc612ba1ae3e3065"
    //   );
    //   this.currentComponent = "searchLoad";
    //   this.queryPlaceVal = true;
    //   this.btn = false;
    // },

    addClickHandler(content, marker) {
      var that = this;
      marker.addEventListener("click", function (e) {
        var point = e.lnglat;
        //  const marker = new T.Marker(point); // 创建标注
        var markerInfoWin = new T.InfoWindow(content, {
          offset: new T.Point(0, -30),
        }); // 创建信息窗口对象
        marker.openInfoWindow(markerInfoWin, point); //开启信息窗口
      });
    },

    // openInfo(content, e) {
    //   var point = e.lnglat;
    //   var map;
    //   map = new T.Map("mapDiv", {
    //     projection: "EPSG:4326",
    //   });
    //   const marker = new T.Marker(point); // 创建标注
    //   var markerInfoWin = new T.InfoWindow(content, {
    //     offset: new T.Point(0, -30),
    //   }); // 创建信息窗口对象
    //   map.openInfoWindow(markerInfoWin, point); //开启信息窗口
    // },
  },
};
</script>

<style scoped lang="scss">
.suspension {
  width: 28vw;
  position: absolute;
  left: 50px;
  top: 10vw;
  z-index: 999;
}
a {
  color: rgb(83, 147, 249);
  &:hover {
    color: green;
  }
}
.putAway {
  background-color: rgb(233, 232, 238);
  height: 60px;
  position: absolute;
  right: -35px;
  width: 30px;
  bottom: 21px;
  text-align: center;
  cursor: pointer;
}
.drop_down {
  background-color: rgb(240, 248, 254);
  justify-content: center;
  margin-top: 10px;
  border-radius: 5px;
  cursor: pointer;
}
img {
  width: 60px;
  height: 60px;
  padding: 10px;
  margin-top: 20px;
  margin-bottom: 10px;
  border-radius: 5px;
}
::v-deep .tdt-container .tdt-control-copyright {
  display: none;
}
.el-main {
  padding: 5px;
  height: 89vh;
}
::v-deep .tdt-label.tdt-clickable {
  // transform: translate3d(183px, 288px, 0px) !important;
}
</style>
