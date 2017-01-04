<template>
  <div id="app">
    <div class="modal-back" v-show="loginBox" @click="closeLogin">
    </div>
    <div class="loginBox" v-show="loginBox">
      <login-box></login-box>
    </div>
    <header class="navbar">
      <h2 class="navbar-title">
        <a class="anchor" data-track-action="navbar" data-track-label="logo" href="/">
        <span class="sr-only">Cosiner</span>
      </a>
    </h2>
      <div>
        <ul class="navbar-list pull-right" v-show="!token">
          <li>
            <a title="Stock photo license" @click="showLogin">登录</a>
          </li>
          <li>
            <a href="/photo-license/" title="Stock photo license">注册</a>
          </li>
        </ul>
        <ul class="navbar-list pull-right" v-show="token">
          <li></li>
          <li>
            <a title="Stock photo license">已登录: {{ username }}</a>
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
import loginBox from './components/Session';
import store from './vuex/store';

export default {
  name: 'app',
  store,
  components: {
    loginBox,
  },
  computed: {
    username() {
      return this.$store.getters.username;
    },
    token() {
      return this.$store.getters.token;
    },
  },
  data() {
    return {
      loginBox: false,
    };
  },
  methods: {
    showLogin() {
      this.loginBox = true;
    },
    closeLogin() {
      this.loginBox = false;
    },
  },
};
</script>
<style lang="less">
  @import "~bootstrap/less/bootstrap.less";
  @import "./styles/base.less";
  @import "./styles/navbar.less";
  @import "./styles/loginBox.less";
</style>
