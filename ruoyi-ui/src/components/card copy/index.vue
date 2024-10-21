<template>
  <div>
    <el-row
      :style="{
        maxWidth: card.width || '380px',
        height:'240px',
        //maxHeight: card.height || '200px',
        overflow: 'hidden',
        padding: '2px',
        borderRadius:'10px',
        //border: 'black solid 1px',
         boxXSizing: 'border-box',
         cursor: 'pointer',
        // boxShadow: '0px 0px 4px 4px rgb(91, 87, 91)'
        padding:'10px'
      }"
    >
      <el-col :span="card.col || 8">
        <!-- <div style="background-color: red; width: 100%; vertical-align:middle"></div> -->
        <img src="../../assets/images/login-background.jpg" :style="{backgroundSize: 'cover',width:'100%'}" alt="">
      </el-col>
      <el-col :span="24 - card.col || 16">
        <el-card shadow="always">
          <!-- <template #header>
            <div class="card-header">
              <p>{{ card.name }}</p>
            </div>
          </template> -->
          <p v-if="!!card.title" style="font-weight: 700; font-size: 18px">
            {{ card.title }}
          </p>
          <p>作者：{{ card.name }}</p>
          <p>简介：{{ card.content }}</p>
          <!-- <p v-for="o in 4" :key="o" class="text item">
            {{ "List item " + o }}
          </p> -->
          <!-- <template #footer>Footer content</template> -->
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>
<script>
export default {
  props: ["card"],
  data() {
    return {};
  },
};
</script>

<style scoped>
/deep/ .el-card__header {
  height: 20px !important;
  padding: 0;
}
p {
  font-size: 14px;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 5;
  overflow: hidden;
  text-overflow: ellipsis;
}
</style>
