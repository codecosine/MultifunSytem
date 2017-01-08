<template>
  <form role="form">
    <div class="form-group">
      <label for="exampleInputEmail1">作业名称</label>
      <input type="email" class="form-control" v-model="jobDetail.jobname">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">课程名称</label>
      <input type="email" class="form-control" v-model="jobDetail.coursename"">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">班级名称</label>
      <input type="email" class="form-control" v-model="jobDetail.courseclass">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">要求</label>
      <input type="email" class="form-control" v-model="jobDetail.requirements">
    </div>
    <div class="form-group">
      <label for="exampleInputEmail1">截止时间</label>
      <input type="email" class="form-control" v-model="jobDetail.deadTime">
    </div>
    <button type="submit" class="btn btn-default" @click="confirmJob">添加课程信息</button>
  </form>
</template>
<script>
    /* eslint no-param-reassign: ["error", { "props": false }] */
    export default{
      data() {
        return {
          jobDetail: {
            jobId: '100',
            jobName: '数据库课程设计2',
            courseName: '数据库设计',
            courseClass: '14级信管2班',
            requirement: '要求',
            deadTime: '2016-1-5',
          },
        };
      },
      methods: {
        confirmJob() {
          this.$http.post('/MultifunSystemServer/AddJobDetail', this.jobdetail)
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
