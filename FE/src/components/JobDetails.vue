<template lang="html">
  <div class="container page-wrap">
    <div class="col-sm-4" v-for="job in jobDetails">
      <div class="card">
        <div class="card-block">
          <div class="card-title">
            <b></b><span>{{ job.jobname }}</span><b></b>
          </div>
          <h5 class="card-subtitle">课程名称:<span class="card-text">{{ job.coursename }}</span></h5>
          <h5 class="card-subtitle">班级:<span class="card-text">{{ job.courseclass }}</span></h5>
          <h5 class="card-subtitle">截止时间:<span class="card-text">{{ job.deadTime }}</span></h5>
          <div class="card-action">
            <a @click="toJob(job.id)" class="card-btn btn btn-primary">立即进入</a>
          </div>
        </div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="card">
        <div class="card-block">
          <div class="card-title">
            <b></b><span>管理作业发布信息</span><b></b>
          </div>
          <div class="card-action">
            <a @click="add =!add" class="card-btn btn btn-default">添加新的作业信息</a>
          </div>
          <div class="card-action">
            <a @click="edit =!edit" class="card-btn btn btn-default">修改当前作业信息</a>
          </div>
        </div>
      </div>
    </div>
    <transition name="fade">
      <div role="dialog" class="c-modal" v-show="add">
        <div class="modal-dialog modal-lg" role="document">
          <div class="modal-content">
            <div name="modal-body">
              <div class="modal-body modal-scroll">
                <button type="button" class="close" @click="add = !add"><span>&times;</span></button>
                <form role="form">
                  <div class="form-group">
                    <h3>添加作业信息</h3>
                  </div>
                  <div class="form-group">
                    <label for="jobname">作业名称</label>
                    <input type="text" class="form-control" v-model="addjobDetail.jobname">
                  </div>
                  <div class="form-group">
                    <label for="coursename">课程名称</label>
                    <input type="text" class="form-control" v-model="addjobDetail.coursename">
                  </div>
                  <div class="form-group">
                    <label for="courseclass">班级</label>
                    <input type="text" class="form-control" v-model="addjobDetail.courseclass">
                  </div>
                  <div class="form-group">
                    <label for="requirements">要求</label>
                    <textarea class="form-control" rows="3" v-model="addjobDetail.requirements"></textarea>
                  </div>
                  <div class="form-group">
                    <label for="deadTime">截止时间</label>
                    <input type="text" class="form-control" v-model="addjobDetail.deadTime">
                  </div>
                </form>
              </div>
            </div>
            <div name="modal-footer">
              <div class="modal-footer">
                <button type="submit" class="btn btn-primary" @click="addJob" :disabled="addinvalid">添加课程信息</button>
                <button type="button" class="btn btn-default" @click="add = !add">关闭</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </transition>
    <transition name="fade">
      <div role="dialog" class="c-modal" v-show="edit">
        <div class="modal-dialog modal-lg" role="document">
          <div class="modal-content">
            <div name="modal-body">
              <div class="modal-body modal-scroll">
                <button type="button" class="close" @click="edit = !edit"><span>&times;</span></button>
                <form role="form">
                  <div class="form-group">
                    <h3>修改作业信息</h3>
                  </div>
                  <div class="form-group">
                    <label for="jobname">选择需要修改的信息</label>
                    <select class="form-control" v-model="editId">
                      <option v-for="job in jobDetails" :value="job.id">{{ job.jobname }}</option>
                    </select>
                  </div>
                  <div class="form-group">
                    <label for="jobname">作业名称</label>
                    <input type="text" class="form-control" v-model="editjobDetail.jobname">
                  </div>
                  <div class="form-group">
                    <label for="coursename">课程名称</label>
                    <input type="text" class="form-control" v-model="editjobDetail.coursename">
                  </div>
                  <div class="form-group">
                    <label for="courseclass">班级</label>
                    <input type="text" class="form-control" v-model="editjobDetail.courseclass">
                  </div>
                  <div class="form-group">
                    <label for="requirements">要求</label>
                    <textarea class="form-control" rows="3" v-model="editjobDetail.requirements"></textarea>
                  </div>
                  <div class="form-group">
                    <label for="deadTime">截止时间</label>
                    <input type="text" class="form-control" v-model="editjobDetail.deadTime">
                  </div>
                </form>
              </div>
            </div>
            <div name="modal-footer">
              <div class="modal-footer">
                <button type="submit" class="btn btn-primary" @click="editJob" :disabled="editinvalid">修改课程信息</button>
                <button type="button" class="btn btn-default" @click="edit = !edit">关闭</button>
              </div>
            </div>
          </div>
        </div>
      </div>
    </transition>
  </div>
</template>
<script>
export default {
  created() {
    this.fetchJobDetails();
  },
  data() {
    return {
      add: false,
      edit: false,
      editId: 100,
      addinvalid: true,
      editinvalid: false,
      addjobDetail: {
        jobname: '',
        coursename: '',
        courseclass: '',
        requirements: '',
        deadTime: '',
      },
    };
  },
  computed: {
    addinvalid() {
      if (this.addjobDetail.jobname && this.addjobDetail.coursename
      && this.addjobDetail.courseclass && this.addjobDetail.requirements) {
        return false;
      }
      return true;
    },
    jobDetails() {
      return this.$store.getters.jobDetails;
    },
    editjobDetail() {
      let jobDetail = {
        id: '123',
        jobname: '尚未加载到该课程作业',
        coursename: 'XXXX',
        courseclass: 'XXX',
        operator: 'XXX',
        requirements: '要求',
        deadTime: '',
      };
      const id = this.editId;
      this.jobDetails.forEach((ele) => {
        if (ele.id === id) {
          jobDetail = ele;
        }
      });
      return jobDetail;
    },
  },
  methods: {
    toJob(jobId) {
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
    addJob() {
      this.$http.post('/MultifunSystemServer/AddJobDetail', this.jobdetail)
        .then((res) => {
          if (res.data.success) {
            this.$store.dispatch('signInSuccess', res.data);
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
<style lang="less">
@import "../styles/card.less";
  .c-modal {
    position: fixed;
      top: 10%;
      right: 0;
      bottom: 0;
      left: 0;
      z-index: 1050;
      -webkit-overflow-scrolling: touch;
      outline: 0;
  }
  .fade-enter-active, .fade-leave-active {
    transition: opacity .3s
  }
  .fade-enter, .fade-leave-to /* .fade-leave-active in <2.1.8 */ {
    opacity: 0
  }
</style>
