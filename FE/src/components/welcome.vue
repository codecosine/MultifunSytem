<template lang="html">
  <div>
    <div class="site-main">
      <div class="banner banner-inverse">
        <div class="container">
          <div class="row">
            <div class="col-sm-6">
            </div>
            <div class="col-sm-6">
              <form role="form" class="center-block auth-modal auth-modal-inner">
                <div class="form-group">
                  <label for="username">学号</label>
                  <input id="username" type="text" placeholder="输入你的学号/用户名" v-model="user.username" class="form-control">
                </div>
                <div class="form-group">
                  <label for="password">密码</label>
                  <input type="password" class="form-control" placeholder="输入你的密码" v-model="user.password" id="password">
                 </div>
                 <div class="form-group action-group">
                   <button type="submit" @click="signIn" class="btn btn-block btn-danger">登录</button>
                 </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="container">
      <div class="row">
        <div class="col-sm-4">
          <h3>课程作业安排</h3>
          <p>课程信息安排一览无余，清晰准确，再也不担心忘记弄混。 </p>
        </div>
        <div class="col-sm-4">
          <h3>作业轻松上传</h3>
          <p>按要求一键上传,随时查看情况,截止时间前随时修改</p>
        </div>
        <div class="col-sm-4">
          <h3>课程信息查看</h3>
          <p>课程相关讨论心得</p>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
export default {
  data() {
    return {
      user: {
        username: '',
        password: '',
      },
    };
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
<style lang="css">
.banner {
  background-image: url(../assets/banner-high.jpg);
  background-size: cover;
  height: 500px;
  margin-bottom: 50px;
  padding: 100px 0px;
}
.banner-text {
  color: #fff;
}
.banner::before {
  position: absolute;
  height: 550px;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  content: "";
  background-color: rgba(0,0,0,0.1);
}
.hand{
  cursor:pointer;
}
.action-group{
  margin-top: 30px;
}
.action-group button{
  height: 40px;
}
.auth-modal-inner{
  font-size: 14px;
  background-color: #fff;
  border: 1px solid #d8dee2;
  border-radius: 5px;
}
.auth-modal{
  width: 350px;
  padding: 20px;
  margin-top: 10px;
}
.logo {
  padding: 100px 0px;
  width:150px;
  height:150px;
}
.create-account-callout {
  margin-top: 15px;
  padding: 15px 20px;
  text-align: center;
  border: 1px solid #d8dee2;
  border-radius: 5px;
}
</style>
