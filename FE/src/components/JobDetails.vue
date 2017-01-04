<template lang="html">
  <div class="container page-wrap">
    <div class="col-sm-4" v-for="job in jobDetails">
      <div class="card">
        <div class="card-block">
          <div class="card-title">
            <b></b><span>{{ job.jobname }}</span><b></b>
          </div>
          <h5 class="card-subtitle">课程名称:<span class="card-text">{{ job.courseName }}</span></h5>
          <h5 class="card-subtitle">班级:<span class="card-text">{{ job.courseClass }}</span></h5>
          <h5 class="card-subtitle">截止时间:<span class="card-text">{{ job.deadTime }}</span></h5>
          <h5 class="card-subtitle">简介:</h5>
          <ul>
            <li><p class="card-text">{{ job.introdution }}</p></li>
          </ul>
          <div class="card-action">
            <a @click="toJob(job.jobId)" class="card-btn btn btn-primary">立即进入</a>
          </div>
        </div>
      </div>
     </div>
  </div>
</template>
<script>
export default {
  created() {
    this.fetchJobDetails();
  },
  data() {
    return {
    };
  },
  computed: {
    jobDetails() {
      return this.$store.getters.jobDetails;
    },
  },
  methods: {
    toJob(jobId) {
      console.log('tojob');
      this.$router.push({ name: 'job', params: { jobId } });
    },
    fetchJobDetails() {
      this.$http.get('/MultifunSystemServer/JobDetails')
      .then((res) => {
        this.$store.dispatch('fetchJobDetailsSuccess', res.data);
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
