<template>
  <div class="inbut">
    <el-input
      :rows="6"
      type="input"
      v-model="parentData.value"
      :placeholder="parentData.msg || '请输入'"
      :size='parentData.size'
      :clearable="parentData.clearable || true"
      :disabled="parentData.disabled || false"
      :validate-event="parentData.validateEvent"
    />
    <el-button :type="btn.color || 'primary'" @click="getBtn">{{btn.name || '搜索'}}</el-button>
  </div>
</template>
<script>
export default {
  props: ["parentData","btn"],
  data() {
    return {};
  },
  methods:{
    getBtn(){
      this.$emit('setBtnBalue',this.parentData.value)
    }
  }
};
</script>

<style scoped>
.inbut {
  display: flex;
  width: 28vw !important;
}
</style>
