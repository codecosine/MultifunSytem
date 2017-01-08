<template>
  <div class="container bs-main">
    <div class="container">
      <div class="row">
        <div class="col-xs-10">
          <h2 class="page-header"><span class="glyphicon glyphicon-tag"></span> 数据库课程设计</h2>
          <form role="form">
            <div class="form-group">
              <label>课程名称</label>
              <p>{{ jobDetail.coursename }}</p>
            </div>
            <div class="form-group">
              <label>操作者</label>
              <p>{{ jobDetail.operator }}</p>
            </div>
            <div class="form-group">
              <label>课程班级</label>
              <p>{{ jobDetail.courseclass }}</p>
            </div>
            <div class="form-group">
              <label>截止时间</label>
              <p>{{ jobDetail.deadTime }}</p>
            </div>
            <div class="form-group">
              <label for="exampleInputEmail1">要求</label>
              <p>{{ jobDetail.requirements }}</p>
            </div>
            <div class="form-group">
              <label for="exampleInputFile">文件上传</label>
              <div>
                  <file-upload
                    title="添加文件"
                    :events="events"
                    class="btn btn-default"
                    name="job"
                    post-action="/MultifunSystemServer/Upload"
                    extensions="zip"
                    :files="uploadedFiles"
                    ref="upload">
                  </file-upload>
              </div>
              <p class="help-block">文件要求为zip.rar打包文件</p>
              <div class="progress-bar" v-bind:style="{ width: fileProgress + '%' }" v-show="fileProgress > 0" ></div>
              <ul v-show="uploadedFiles.length > 0">
                <!-- loop through the completed files -->
                <li v-for="file in uploadedFiles">Name: <em>{{ file.name }}</em> Size: <em>{{ file.size | prettyBytes }}</em></li>
              </ul>
            </div>
            <button type="submit" class="btn btn-lg btn-primary">确认提交</button>
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
      data() {
        return {
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
        jobDetails() {
          return this.$store.getters.jobDetails;
        },
        jobDetail() {
          let jobDetail = {
            id: '123',
            jobname: '尚未加载到该课程作业',
            coursename: 'XXXX',
            courseclass: 'XXX',
            operator: 'XXX',
            requirements: '要求',
            deadTime: '',
          };
          const id = this.$route.params.jobId;
          this.jobDetails.forEach((ele) => {
            if (ele.id === id) {
              jobDetail = ele;
            }
          });
          return jobDetail;
        },
      },
      methods: {
        confirmJob() {
          this.$http.post('/MultifunSystemServer/AddJob', this.job)
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
      mounted() {
        this.upload = this.$refs.upload.$data;
      },
    };
</script>
<style>
  .form-group>label{
    font-size: 18px;
  }
  .progress-bar {
    opacity: 1;
    height: 2px;
    margin: 0.4em 0;
    width: 0;
    background: green;
  }
</style>
