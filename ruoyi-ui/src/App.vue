<template>
  <div id="app">
    <!-- <Header /> -->
    <router-view />
  </div>
</template>

<script>
import ThemePicker from "@/components/ThemePicker";
import Header from "@/components/header/index.vue";
export default {
  name: "App",
  components: { ThemePicker, Header },
  methods: {
  },
  metaInfo() {
    return {
      title:
        this.$store.state.settings.dynamicTitle &&
        this.$store.state.settings.title,
      titleTemplate: (title) => {
        return title
          ? `${title} - ${process.env.VUE_APP_TITLE}`
          : process.env.VUE_APP_TITLE;
      },
    };
  },
};
</script>
<style>
/* #app .theme-picker {
  display: none;
} */
</style>
