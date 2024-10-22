<template>
  <div class="container">
    <div>
      <div class="header">
        <img src="../../../assets/images/zhengcezixun.png" alt="" />
      </div>
      <div class="content">
        <el-tabs v-model="activeName" stretch>
          <el-tab-pane label="最新咨询" name="first">
            <el-card class="box-card" style="margin: 0 2vw">
              <div slot="header" class="clearfix">
                <span>标题</span>
                <div
                  style="float: right; padding: 3px 0; margin-right: 1vw"
                  type="text"
                >
                  <span style="margin-right: 10vw">来源</span>
                  <span
                    >时间
                    <i class="el-icon-sort"></i>
                  </span>
                </div>
              </div>
              <ul>
                <li v-for="item in newsList" :key="item" class="text">
                  <div v-if="item.isshow=='是'?true:false" style="display: flex; position: relative">
                    <span class="content_font" @click="handleClick(item)">{{
                      item.title
                    }}</span>
                    <div style="position: absolute; right: 0">
                      <span style="margin-right: 8vw">{{item.resource}}</span>
                      <span>2024-09-20</span>
                    </div>
                  </div>
                </li>
              </ul>
            </el-card>
          </el-tab-pane>
          <el-tab-pane label="政策法规" name="second">政策法规</el-tab-pane>
          <el-tab-pane label="地名公告" name="third">地名公告</el-tab-pane>
        </el-tabs>
      </div>
      <Pagination :total="100" />
    </div>

    <router-view v-show="$route.meta.showFather" />
  </div>
</template>
<script>
import {
  listNews,
  getNews,
  delNews,
  addNews,
  updateNews,
} from "@/api/system/news";
import Pagination from "@/components/Pagination/index.vue";
export default {
  components: { Pagination },
  data() {
    return {
      activeName: "first",
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        title: null,
        resource: null,
        resourceurl: null,
        content: null,
        isshow: null,
        createuer: null,
        createtime: null,
        isdel: null,
      },
      newsList:[]
    };
  },
  mounted() {
    listNews(this.queryParams).then((res) => {
      console.log(res.rows)
      this.newsList = res.rows;
      // this.total = response.total;
      // this.loading = false;
    });
  },
  methods: {
    handleClick(val) {
      this.$router.push({ path: "policyDetail",query:val });
    },
  },
};
</script>
<style scoped lang="scss">
.text {
  margin: 20px 0;
}
.container {
  margin: 0 2vw;
  display: block !important;
  background-color: #f2f2f2;
}
.header {
  width: 100%;
  height: 10vw;
  background-color: #f2f2f2;
  img {
    width: 100%;
    height: 100%;
  }
}
.content {
  margin: 0 3vw;
  margin-top: -5vw;
  background-color: #f2f2f2;
  color: #333333;
  .content_font {
    &:hover {
      text-decoration: underline;
      cursor: pointer;
    }
  }
}
::v-deep .is-active {
  color: #a30014;
  font-weight: 700;
}
::v-deep .el-tabs__item:hover {
  color: initial;
}
::v-deep .el-tabs__active-bar {
  background-color: #a30014;
}
::v-deep .el-tabs--top .el-tabs__item.is-top,
.el-tabs--top .el-tabs__item.is-bottom {
  height: 6vw;
  line-height: 6vw;
  font-size: 1.7rem;
}
.pagination-container[data-v-72233bcd],
::v-deep .el-tabs__header,
.el-card {
  background-color: #f2f2f2;
}
</style>
