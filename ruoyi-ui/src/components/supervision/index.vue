<template>
  <div style="width: 100%" @click="handleCorrection">
    <img
      style="width: 10px; height: 12px"
      src="../../assets/images/jiucuo.png"
      alt=""
    />
    <i style="font-size: 13px; color: red">当前描述有误,点击纠错</i>
  </div>
</template>
<script>
export default {
    prop:[''],
    data() {
        return{}
    },
    methods:{
        handleCorrection(){
            this.$emit('handleCorrection')
        }
    }
}
</script>