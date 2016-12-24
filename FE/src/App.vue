<template>
  <div id="app">
    <header class="navbar">
      <h2 class="navbar-title">
        <a class="anchor" data-track-action="navbar" data-track-label="logo" href="/">
        <span class="sr-only">Cosiner</span>
      </a>
    </h2>
      <div>
        <ul class="navbar-list pull-right">
          <li>
            <a href="/photo-license/" title="Stock photo license">登录</a>
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
export default {
  name: 'app',
};
</script>
<style lang="less">
  //@import "./styles/flex.less";
  @import "~bootstrap/less/bootstrap.less";
  // @import "./styles/reset.less";
  @import "./styles/base.less";
  @import "./styles/navbar.less";
</style>
