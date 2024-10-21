<template>
  <div class="container">
    <div class="pos">
      <Breadcrumb />
      <div class="header">
        <HeaderSearch :parentData="message" :btn="butt" />
      </div>
    </div>

    <el-container style="width: 100%; height: 90vh !important">
      <el-container class="filter-tree">
        <el-aside width="200px">
          <el-tree
            :data="data"
            :props="defaultProps"
            default-expand-all
            ref="tree"
          >
          </el-tree>
        </el-aside>
        <el-container style="margin-bottom:15vh">
          <el-main>
            <QueryCard :card="cardContent" />
          </el-main>
        </el-container>
      </el-container>
    </el-container>
  </div>
</template>
<script>
import HeaderSearch from "../../components/Query/index.vue";
import QueryCard from "../../components/card/index.vue";
import Breadcrumb from "@/components/Breadcrumb/index.vue";
export default {
  components: { HeaderSearch, QueryCard, Breadcrumb },
  name: "MyComponent",
  data() {
    return {
      message: {
        msg: "请输入名称",
        width: "500px",
        value: "",
        clearable: true,
        size: "lager",
      },
      butt: {
        color: "primary",
        name: "查询",
      },
      filterText: "",
      data: [
        {
          id: 1,
          label: "十堰市（8）",
          children: [
            {
              id: 4,
              label: "茅箭区（3）",
            },
            {
              id: 6,
              label: "丹江口市（3）",
            },
            {
              id: 8,
              label: "竹山县（2）",
            },
          ],
        },
      ],
      defaultProps: {
        children: "children",
        label: "label",
      },
      cardContent: {
        width: "373px",
        col: 12,
        title: "名称名称名称",
        name: "李四",
        content:
          "十堰电子地名丛书涵盖了十堰市及其所辖县（市区）、乡镇（街道）、社区（村）等各类行政区划名称，以及公路、街巷、桥梁、隧道、车站、",
      },
    };
  },
  created() {},
  mounted() {
  },
  watch: {},
  methods: {
    setSHouye() {
      this.$router.go(-1);
    },
  },
};
</script>
<style scoped>
.pos {
  /* position: absolute;
    left: 0;
    top: 60px; */
  border-width: 0px;
  position: absolute;
  left: 0px;
  top:20vh;
  width: 100%;
  height: 80px;
  /* line-height: 120px; */
  background: inherit;
  border: none;
  border-radius: 0px;
  -moz-box-shadow: none;
  -webkit-box-shadow: none;
  box-shadow: none;
  z-index: 999;
  margin: 0 20px;
  background-color: rgba(242, 242, 242, 0.996078431372549);
}
.pos_header {
  height: 80px;
  display: flex;
  align-items: center;
}
.container {
  display: block;
  height: 100vh;
}
.header {
  display: flex;
  align-items: center;
  justify-content: center;
  background-image: url("../../assets/images/login-background.jpg");
  background-size: contain;
  width: 100%;
  height: 10vh;
  float: left;
  /* position: absolute;
  left: 45%;
  top: 120px;
  z-index: 999; */
}
.filter-tree {
  margin-top: 23vh;
}
.breadcrumb_left {
  font-size: 20px;
}
::v-deep .el-breadcrumb__separator {
  /* font-size: 30px; */
  color: black;
}
::v-deep .app-breadcrumb{
  line-height: 80px !important;
}
</style>
