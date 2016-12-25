<template>
  <div>
    <div class="logoBox center-block"><img src="../assets/gdut.png"></div>
      <form role="form" class="center-block auth-modal">
          <div class="form-group">
            <label for="id">学号</label>
            <input id="id" type="text" v-model="user.id" class="form-control" placeholder="登录学号">
          </div>
          <div class="form-group">
            <label for="password">密码</label>
            <input id="password" type="password" v-model="user.password" class="form-control" placeholder="密码">
          </div>
          <div class="form-group">
            <button type="button" @click="signIn" class="btn btn-block btn-danger">登录</button>
          </div>
          <div class="form-group">
            <p class="create-account center-block">
              没有账号?<a href="">注册新用户</a>
             </p>
          </div>
      </form>
  </div>
</template>
<style lang="less">
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
