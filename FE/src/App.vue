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
        <ul class="navbar-list pull-right">
          <li>
            <a title="Stock photo license" @click="showLogin">登录</a>
          </li>
          <li>
            <a href="/photo-license/" title="Stock photo license">注册</a>
          </li>
          <li>
            <a href="/photo-license/" title="Stock photo license" >License</a>
          </li>
        </ul>
      </div>
    </header>
    <router-view></router-view>
    <footer class="bs-footer">
      <div class="container">
        <p>广东工业大学</p>
      </div>
    </footer>
  </div>
</template>
<script>
import loginBox from './components/Session';

export default {
  components: {
    loginBox,
  },
  name: 'app',
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
  //@import "./styles/flex.less";
  @import "~bootstrap/less/bootstrap.less";
  // @import "./styles/reset.less";
  @import "./styles/base.less";
  @import "./styles/navbar.less";
  @import "./styles/loginBox.less";
</style>
