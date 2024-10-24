<template>
  <div class="container">
    <!-- 地图 -->
    <el-container>
      <el-main id="mainDIV">
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
                <el-col v-for="item in areaList" :key="item.id" :span="6"
                  ><a @click="handleAlert(item)"> {{ item.name }}</a
                  ><el-divider direction="vertical"
                /></el-col>
              </el-row>
            </div>
            <el-divider></el-divider>
            <div style="margin-bottom: 10px; padding-bottom: 20px">
              <p>最近搜索</p>
              <div>
                <el-alert
                  v-for="item in lately"
                  :key="item.id"
                  style="margin-bottom: 10px"
                  title=""
                  type="info"
                >
                  <el-link type="info" @click="handleBlert(item)">{{
                    item.name
                  }}</el-link>
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
        :header="header"
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
import { listDm, getDm, delDm, addDm, updateDm } from "@/api/system/dm";
import Axios from "axios";
export default {
  name: "Demo",
  components: { QueryPlace, QueryCard, CardImg, searchLoad, placeName },
  data() {
    return {
      header: true,
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
      areaList: [],
      points: [],
      line: "",
      url: "tk=525ecf8803a6268acc612ba1ae3e3065",
      lianjie:
        "layers=vec_c,cva_c &paths=116.34867,39.94593;116.42626,39.94731;116.4551,39.90267 |116.43381,39.86766;116.34249,39.87178;116.32807,39.90748 &pathStyles=0xff0000,8,0.7|0x00ff00,19,1&",
      queryParams: {
        pageNum: 1,
        pageSize: 100,
        dicType: null,
        name: null,
        address: null,
        content: null,
        imgurl: null,
        pointarr: null,
      },
      lately: [],
      map: null,
      zoom: 12,
      marker: "",
    };
  },

  watch: {},
  created() {
    this.$nextTick(() => {
      this.onLoad();
    });
  },
  mounted() {},
  methods: {
    handleBlert(val) {
      this.map.clearOverLays();

      this.dataList = {
        id: val.id,
        name: val.name,
        address: val.address,
        jianjie: val.content,
        header: true,
      };
      this.handleMap([val], val.pointarr.split(","));
      this.map.enableDrag();
      this.currentComponent = "searchLoad";
      this.queryPlaceVal = true;
      this.btn = false;
    },
    handleAlert(val) {
      this.map.clearOverLays();
      // document
      //   .getElementById("mainDIV")
      //   .removeChild(document.getElementById("mapDiv"));
      // var div = document.createElement("div");
      // div.id = "mapDiv";
      // // 重新添加子元素
      // document.getElementById("mainDIV").appendChild(div);
      this.message = {
        value: val.name,
      };
      let map;
      let zoom = 10;

      //初始化地图对象
      // map = new T.Map("mapDiv");

      //设置显示地图的中心点和级别
      this.map.centerAndZoom(
        new T.LngLat(
          JSON.parse(val.pointarr).center[0],
          JSON.parse(val.pointarr).center[1]
        ),
        zoom
      );

      var points = [];
      points = JSON.parse(val.pointarr).geometry[0][0].map((item) => {
        return new T.LngLat(item[0], item[1]);
      });

      //创建线对象
      // var line = new T.Polyline(points, {
      //   color: "red",
      //   lineStyle: "dashed",
      //   weight: "5",
      // });
      // map.clearOverLays();
      // //向地图上添加线
      // map.addOverLay(line);

      var polygon = new T.Polygon(points, {
        color: "blue",
        weight: 3,
        opacity: 0.5,
        fillColor: "#6778a5",
        fillOpacity: 0.5,
        lineStyle: "dashed",
      });
      //向地图上添加面
      this.map.addOverLay(polygon);

      // console.log(points)
      // //创建线对象
      // var line = new T.Polyline(points);
      // //向地图上添加线
      // map.addOverLay(line);
      this.map.enableDrag();
      this.dataList = {
        id: val.id,
        name: val.name,
        address: val.address,
        jianjie: val.content,
        header: true,
        // pointarr: val.pointarr,
      };
      this.currentComponent = "searchLoad";
      this.queryPlaceVal = true;
      this.btn = false;

      // var imageURL = "http://t0.tianditu.gov.cn/img_w/wmts?" +
      //                 "SERVICE=WMTS&REQUEST=GetTile&VERSION=1.0.0&LAYER=img&STYLE=default&TILEMATRIXSET=w&FORMAT=tiles" +
      //                 "&TILEMATRIX={z}&TILEROW={y}&TILECOL={x}&tk=525ecf8803a6268acc612ba1ae3e3065";
      //             //创建自定义图层对象
      //             var lay = new T.TileLayer(imageURL, {minZoom: 14, maxZoom: 14});
      //             //将图层增加到地图上
      //             map.addLayer(lay);
    },

    getImageSrc(index) {
      return require(`@/assets/images/${index + 1}.png`);
    },
    getBtn(value) {
      if (!!value && value != "") {
        const query = { ...this.queryParams, name: value };
        listDm(query).then((res) => {
          console.log("打印", res);
          this.currentComponent = "placeName";
          this.dataList = res.rows;
          this.btn = false;
          this.queryPlaceVal = true;
          this.handleMap(res.rows);
        });
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
    setName(val) {
      const arr = this.points.filter((item) => {
        return item.dicType == val;
      });
      this.map.clearOverLays();

      this.dataList = arr;
      this.btn = false;
      this.queryPlaceVal = false;
      this.handleMap(arr);
      this.map.enableDrag();
      this.currentComponent = "placeName";
    },
    onLoad() {
      listDm(this.queryParams)
        .then((res) => {
          // this.handleMap(res.rows);
          this.handleMap([]);
          this.points = res.rows;
          this.areaList = res.rows.filter((item) => {
            return item.dicType == "行政区划";
          });
          this.lately = res.rows.filter((item) => {
            return item.dicType == "搜索";
          });
        })
        .catch((err) => {});
    },
    handleMap(val, center) {
      // removeMarkerClick();
      const arr = [];
      val.forEach((item) => {
        if (!!item.pointarr && !!item.name) {
          arr.push([...item.pointarr.split(","), item.name]);
        }
      });
      // var zoom = 12;
      var data_info = arr;
      if (!this.map) {
        this.map = new T.Map("mapDiv", {
          projection: "EPSG:4326",
        });
      }

      //  map.removeChild(document.getElementById("mapDiv"));
      if (!!center) {
        this.map.centerAndZoom(new T.LngLat(center[0], center[1]), this.zoom);
      } else {
        this.map.centerAndZoom(new T.LngLat(110.8065, 32.62129), this.zoom);
      }

      this.map.enableDrag();

      for (var i = 0; i < data_info.length; i++) {
        var marker = new T.Marker(
          new T.LngLat(data_info[i][0], data_info[i][1])
        );
        // 创建标注
        marker.addEventListener("click", this.MarkerClick);
        var content = data_info[i][2];
        var latlng = new T.LngLat(
          data_info[i][0] - 0.0002,
          data_info[i][1] + 0.0007
        );
        var label = new T.Label({
          text: content,
          position: latlng,
          offset: new T.Point(-9, 0),
        });
        //创建地图文本对象
        this.map.addOverLay(label);
        this.map.addOverLay(marker); // 将标注添加到地图中
      }
    },
    MarkerClick(e) {
      console.log(e);
    },
  },
};
</script>

<style scoped lang="scss">
.suspension {
  width: 28vw;
  position: absolute;
  left: 50px;
  top: 6vh;
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
  // margin-top: 65px;
  padding: 5px;
  height: 100%;
  // overflow: hidden;
}
::v-deep .tdt-label.tdt-clickable {
  // transform: translate3d(183px, 288px, 0px) !important;
}
</style>
