<template lang="html">
  <div class="container page-wrap">
    <div class="col-sm-4" v-for="job in jobList">
      <div class="card">
        <div class="card-block">
          <div class="card-title">
            <b></b><span>{{ job.jobName }}</span><b></b>
          </div>
          <h5 class="card-subtitle">课程名称:<span class="card-text">{{ job.courseName }}</span></h5>
          <h5 class="card-subtitle">班级:<span class="card-text">{{ job.courseClass }}</span></h5>
          <h5 class="card-subtitle">截止时间:<span class="card-text">{{ job.deadTime }}</span></h5>
          <h5 class="card-subtitle">简介:</h5>
          <ul>
            <li><p class="card-text">{{ job.introduction }}</p></li>
          </ul>
          <div class="card-action">
            <a @click="toJobManager(job.jobId)" class="card-btn btn btn-primary">立即进入</a>
          </div>
        </div>
      </div>
     </div>
  </div>
</template>
<script>
export default {
  created() {
    this.fetchJobList();
  },
  data() {
    return {
    };
  },
  computed: {
    jobList() {
      return this.$store.getters.jobList;
    },
  },
  methods: {
    toJobManager(jobId) {
      this.$router.push({ name: 'job', params: { jobId } });
    },
    fetchJobList() {
      this.$http.get('/api/list')
      .then((res) => {
        this.$store.dispatch('fetchJobList', res.data);
      }, (err) => {
        this.error = err.toString();
      });
    },
  },
};
</script>
<style lang="less">
@import "../styles/card.less";
</style>
