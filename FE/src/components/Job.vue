<template>
  <div class="container bs-main">
    <div class="container">
      <div class="row">
        <div class="col-xs-10">
          <h2 class="page-header"><span class="glyphicon glyphicon-tag"></span> 数据库课程设计</h2>
          <form role="form">
            <div class="form-group">
              <label>简介</label>
              <p>{{ jobDetail.introdution }}</p>
            </div>
            <div class="form-group">
              <label>课程班级</label>
              <p>{{ jobDetail.courseClass }}</p>
            </div>
            <div class="form-group">
              <label for="exampleInputEmail1">要求</label>
              <p>{{ jobDetail.requirement }}</p>
            </div>
            <div class="form-group">
              <label for="exampleInputFile">文件上传</label>
              <file-upload
                title="添加文件"
                :events="events"
                name="job"
                post-action="/MultifunSystemServer/Upload"
                extensions="zip"
                :files="uploadedFiles"
                ref="upload">
              </file-upload>
              <input type="file" id="exampleInputFile">
              <p class="help-block">文件要求为zip.rar打包文件</p>
              <div class="progress-bar" v-bind:style="{ width: fileProgress + '%' }" v-show="fileProgress > 0" ></div>
              <ul v-show="uploadedFiles.length > 0">
                <!-- loop through the completed files -->
                <li v-for="file in uploadedFiles">Name: <em>{{ file.name }}</em> Size: <em>{{ file.size | prettyBytes }}</em></li>
              </ul>
            </div>
            <button type="submit" class="btn btn-primary">确认提交</button>
            <button type="button" @click="fetchJob(1)"></button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
    import FileUpload from 'vue-upload-component';
    /* eslint no-param-reassign: ["error", { "props": false }] */
    export default{
      components: {
        FileUpload,
      },
      // created() {
      //   this.fetchJob(this.$route.params.jobId);
      // },
      data() {
        return {
          jobDetail: {
            jobId: '100',
            jobName: '数据库课程设计2',
            courseName: '数据库设计',
            courseClass: '14级信管2班',
            introdution: '简介',
            requirement: '要求',
            deadTime: '2016-1-5',
          },
          job: {
            username: '',
            course_name: '',
            courseClass: '',
            statu: '',
            date: '',
            url: '',
          },
          uploadedFiles: [], // my list for the v-for
          fileProgress: 0, // global progress
          files: [],
          upload: [],
          events: {
            add(file, component) {
              component.active = true;
              file.headers['X-Filename'] = encodeURIComponent(file.name);
              file.data.filename = file.name;
            },
          },
        };
      },
      computed: {
        fileName() {
          return this.files[0].response.fileName;
        },
      },
      methods: {
        fetchJob(id) {
          this.jobDetail = this.$store.dispatch('fetchJobDetailsById', id);
          console.log(this.jobDetail);
        },
        // confirmJob() {
        //   this.$http.post('/MultifunSystemServer/AddJob', this.job)
        //       .then((res) => {
        //         if (res.data.success) {
        //           this.$store.dispatch('signInSuccess', res.data);
        //           this.$router.push({ name: 'jobDetails' });
        //         } else {
        //           this.$store.dispatch('signInFail', res.data);
        //         }
        //       }, (err) => {
        //         this.$store.dispatch('signInError', err);
        //       });
        // },
      },
      mounted() {
        this.upload = this.$refs.upload.$data;
      },
    };
</script>
<style>
    .progress-bar {
      opacity: 1;
      height: 2px;
      margin: 0.4em 0;
      width: 0;
      background: green;
    }
</style>
