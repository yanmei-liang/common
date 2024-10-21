<template>
  <div>
    <Loadculture v-show="$route.meta.showFather"/>
    <router-view />
  </div>
</template>
<script>
import Loadculture from "../views/loadculture/index.vue";
export default {
  components: { Loadculture },

};
</script>
