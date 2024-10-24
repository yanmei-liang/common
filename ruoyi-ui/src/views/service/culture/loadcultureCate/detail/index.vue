<template>
  <div>
    <div style="width: 100%; height: 200px">
      <Breadcrumb />
    </div>

    111
  </div>
</template>
<script>
import {
  listMedia,
  getMedia,
  delMedia,
  addMedia,
  updateMedia,
} from "@/api/system/media";
import Breadcrumb from "@/components/Breadcrumb/index.vue";
export default {
  components: { Breadcrumb },
  data() {
    return {
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        type: null,
        name: null,
        author: null,
        area: null,
        mainimg: null,
        content: null,
        isshow: null,
        createuer: null,
        createtime: null,
        isdel: null,
      },
    };
  },
  mounted() {
    console.log(this.$route.params);
    this.getList();
  },
  methods: {
    getList() {
      this.loading = true;
      listMedia(this.queryParams).then((response) => {
        this.mediaList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
  },
};
</script>