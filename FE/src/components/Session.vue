<template>
  <div>
    <div class="logoBox center-block"><img src="../assets/gdut.png"></div>
      <form role="form" class="center-block auth-modal">
          <div class="form-group">
            <label for="username">学号</label>
            <input id="username" type="text" v-model="user.username" class="form-control" placeholder="登录学号">
          </div>
          <div class="form-group">
            <label for="password">密码</label>
            <input id="password" type="password" v-model="user.password" class="form-control" placeholder="密码">
          </div>
          <div class="form-group">
            <button type="submit" @click="signIn" class="btn btn-block btn-danger">登录</button>
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
      computed: {
        type() {
          if (!this.$route.params.type) {
            return 'login';
          }
          return this.$route.params.type;
        },
      },
      methods: {
        signIn() {
          this.$http.post('/MultifunSystemServer/UserAuth', this.user)
              .then((res) => {
                if (res.data.success) {
                  this.$store.dispatch('signInSuccess', res.data);
                  this.$router.push({ name: 'jobDetails' });
                } else {
                  this.$store.dispatch('signInFail', res.data);
                }
              }, (err) => {
                this.$store.dispatch('signInError', err);
              });
        },
      },
    };
</script>
