<template>
  <div id="app">
    <header class="navbar">
      <h2 class="navbar-title">
        <a class="anchor" data-track-action="navbar" data-track-label="logo" href="/">
        <span class="sr-only">Cosiner</span>
      </a>
    </h2>
      <div>
        <ul class="navbar-list pull-right" v-show="!token">
          <li>
            <router-link :to="{ name: 'session', params: { type: 'login' }}">登录</router-link>
            <router-link :to="{ name: 'session', params: { type: 'register' }}">注册</router-link>
          </li>
        </ul>
        <ul class="navbar-list pull-right" v-show="token">
          <li>
            <router-link :to="{ name: 'jobDetails'}">作业列表</router-link>
          </li>
          <li>
            <router-link :to="{ name: 'jobDetails'}">我的作业</router-link>
          </li>
          <li>
            <a>{{ user.role }}--{{ user.username }}</a>
          </li>
        </ul>
      </div>
    </header>
    <router-view></router-view>
    <footer class="bs-footer">
      <div class="container">
        <p>多功能学生信息管理系统</p>
        <p>广东工业大学</p>
      </div>
    </footer>
  </div>
</template>
<script>
import store from './vuex/store';

export default {
  name: 'app',
  store,
  computed: {
    user() {
      return this.$store.getters.user;
    },
    token() {
      return this.$store.getters.token;
    },
  },
};
</script>
<style lang="less">
  @import "~bootstrap/less/bootstrap.less";
  @import "./styles/base.less";
  @import "./styles/navbar.less";
</style>
