<template>
  <div class="container">
    <div class="row">
      <div class="center-block logo"><img src="../assets/gdut.png" style="width:150px"></div>
        <form role="form" class="center-block auth-modal auth-modal-inner">
            <div class="form-group">
              <label for="id">学号</label>
              <input id="id" type="text" v-model="user.id" class="form-control">
            </div>
            <div class="form-group">
              <label for="password">密码</label>
              <input id="password" type="password" v-model="user.password" class="form-control" >
            </div>
            <button type="button" @click="signIn" class="btn btn-block btn-danger">登录</button>
        </form>
        <p class="create-account-callout center-block auth-modal" v-if="method==='signIn'">
            没有账号?<a class="hand" href="" data-ga-click="Sign in, switch to sign up">注册新用户</a>
         </p>
    </div>
  </div>
</template>
<style lang="less">
  @@import "../styles/loginBox.less";
</style>
<script>
    export default{
      data() {
        return {
          user: {
            username: '',
            password: '',
          },
        };
      },
      methods: {
        /* eslint no-undef: "error" */
        /* eslint-env browser */
        signIn() {
          this.$store.dispatch('signInRequest', this.user)
            .then((res) => {
              if (res.data.success) {
                const auth = {
                  username: res.data.username,
                  token: res.data.token,
                };
                this.$store.dispatch('signInSuccess', auth);
                window.localStorage.setItem('TOKEN_KEY', res.data.token);
                this.$router.push({ name: 'main' });
              }  // 传递 res.message
            }, (err) => {
              this.$store.dispatch('signInError', err);
            });
        },
      },
    };
</script>
