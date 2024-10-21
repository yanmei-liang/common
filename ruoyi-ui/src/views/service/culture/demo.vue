<template>
  <div>
    <Loadculture v-show="$route.meta.showFather"/>
    <router-view />
  </div>
</template>
<script>
import Loadculture from "@/views/service/loadculture";
export default {
  components: { Loadculture },

};
</script>
