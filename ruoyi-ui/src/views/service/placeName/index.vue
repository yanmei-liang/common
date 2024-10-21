<template>
  <div class="container">
    <div class="flex_align place_top">
      <div class="flex_align">
        <i class="el-icon-arrow-left" @click="goBack"></i>
        <p>特色地名（27个）</p>
      </div>
      <el-select
        v-model="value"
        placeholder="请选择"
        style="width: 120px"
        size="mini"
      >
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value"
        >
        </el-option>
      </el-select>
      <el-input
        size="mini"
        placeholder="请输入"
        prefix-icon="el-icon-search"
        v-model="inputVal"
        :style="{ width: '150px', fontSize: '13px' }"
      >
      </el-input>
    </div>
    <div style="margin-top: 10px; overflow: auto; height: 500px">
      <div class="flex place_buttom">
        <CardImg :cardVal="cardVal" />
      </div>
    </div>
  </div>
</template>

<script>
import CardImg from "@/components/CardImg/index.vue";
export default {
  props:[],
  components: { CardImg },
  data() {
    return {
      inputVal: "",
      cardVal: [
        {
          id: "1",
          name: "1、武当山景区售票处",
          place: "十堰市丹江口市武当山特区永乐路14号",
          img: false,
          scene: true,
        },
        {
          id: "2",
          name: "2.武当山1号停车场",
          place: "十堰市丹江口市武当山特区永乐路14号",
          img: true,
          scene: true,
        },
        {
          id: "3",
          name: "3.武当山火车站",
          place: "十堰市丹江口市武当山特区永乐路14号",
          img: true
        },
        {
          id: "4",
          name: "4.武当山风景区-太和楼",
          place: "十堰市丹江口市武当山特区永乐路14号",
          img:true,
        },
        {
          id: "5",
          name: "5.武当山天乐客栈",
          place: "十堰市丹江口市武当山特区永乐路14号",
          img:true,
          scene: true,
        },
        {
          id: "6",
          name: "6.武当山-明月道院",
          place: "十堰市丹江口市武当山特区永乐路14号",
          img:true,
        },
      ],
      options: [
        {
          value: "选项1",
          label: "全部年份",
        },
        {
          value: "选项2",
          label: "2005",
        },
        {
          value: "选项3",
          label: "1999",
        },
        {
          value: "选项4",
          label: "1983",
        },
        {
          value: "选项5",
          label: "1999",
        },
      ],
      value: "",
    };
  },
  methods: {
    goBack() {
      const value = {
        btn: true,
        queryPlaceVal: true,
      };
      this.$emit("update-value", value);
    },
  },
};
</script>
<style scoped lang="scss">
.container {
  display: block;
  height: 500px;
}
.place_top {
  justify-content: space-between;
  background-color: rgb(240, 248, 254);
}
.place_buttom {
  justify-items: center;
  background-color: rgb(240, 248, 254);
  border-radius: 10px;
}
.suspension {
  width: 400px;
  position: absolute;
  left: 20px;
  top: 0px;
  z-index: 99;
}
p {
  font-size: 13px;
}
</style>
