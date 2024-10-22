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
        @change="handleChange"
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
        <CardImg :cardVal="arrList" />
      </div>
    </div>
  </div>
</template>

<script>
import CardImg from "@/components/CardImg/index.vue";
export default {
  props: ["dataList"],
  components: { CardImg },
  data() {
    return {
      inputVal: "",
      options: [
        {
          value: "全部市辖区",
          label: "全部市辖区",
        },
        {
          value: "茅箭",
          label: "茅箭区",
        },
        {
          value: "张湾",
          label: "张湾区",
        },
        {
          value: "郧阳",
          label: "郧阳区",
        },
        {
          value: "郧西",
          label: "郧西县",
        },
        {
          value: "竹山",
          label: "竹山县",
        },
        {
          value: "竹溪",
          label: "竹溪县",
        },
        {
          value: "房县",
          label: "房县区",
        },
        {
          value: "丹江口",
          label: "丹江口市",
        },
      ],
      value: "",
      arrList: [],
    };
  },
  mounted() {
    this.arrList = this.$props.dataList;
    console.log( this.$props.dataList)
  },
  methods: {
    handleChange(val) {
      // console.log(this.arrList);
      if (val != "全部市辖区") {
       this.arrList = this.$props.dataList.filter((item) => {
          const pattern = new RegExp(val, "i");
          if (pattern.test(item.address)) {
            return item;
          }
        });
      }else{
        this.arrList = this.$props.dataList
      }
    },
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
