<template>
  <div class="container bs-main">
    <div class="container">
      <div class="row">
        <div class="col-xs-10">
          <h2 class="page-header"><span class="glyphicon glyphicon-tag"></span> 数据库课程设计</h2>
          <form role="form">
            <div class="form-group">
              <label for="exampleInputEmail1">简介</label>
            </div>
            <div class="form-group">
              <label for="exampleInputEmail1">要求</label>
              <p></p>
            </div>
            <div class="form-group">
              <label for="exampleInputEmail1">提交者信息</label>
              <p></p>
            </div>
            <div class="form-group">

              <label for="exampleInputFile">文件上传</label>
              <file-upload
                title="添加文件"
                :events="events"
                name="formFile"
                post-action="/upload"
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
          </form>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
    import FileUpload from 'vue-upload-component';
    /* eslint no-param-reassign: ["error", { "props": false }] */
    /* eslint no-console: ["error", { allow: ["warn", "error"] }] */
    export default{
      components: {
        FileUpload,
      },
      watch: {
        addTaskSuccess(value) {
          if (value) {
            this.changeFlag();
          }
        },
        addTaskFail(value) {
          if (value) {
            this.changeFlag();
          }
        },
      },
      data() {
        return {
          uploadedFiles: [], // my list for the v-for
          fileProgress: 0, // global progress
          files: [],
          upload: [],
          events: {
            add(file, component) {
              component.active = true;
              file.headers['X-Filename'] = encodeURIComponent(file.name);
              file.data.finename = file.name;
            },
          },
        };
      },
      computed: {
        jobList() {
          return this.$store.getters.jobList;
        },
        fileName() {
          return this.files[0].response.fileName;
        },
        valid() {
          const valid = {
            uploadError: true,
            algorithmError: true,
          };
          if (this.files[0]) {
            if (this.files[0].success) {
              valid.uploadError = false;
            }
          }
          if (this.algorithm !== '') {
            valid.algorithmError = false;
          }
          valid.pass = (valid.uploadError || valid.algorithmError);
          return valid;
        },
      },
      methods: {
        selectAlgorithms(item) {
          if (this.algorithms.indexOf(item) !== -1) {
            this.algorithms.splice(this.algorithms.indexOf(item), 1);
          } else {
            this.algorithms.push(item);
          }
        },
        addTask() {
          this.$http.post('/calculation/cal',
            {
              fileName: this.fileName,
              algoName: this.algorithm,
              remark: this.remark,
            })
            .then(() => {
              this.addTaskSuccess = true;
            }, (err) => {
              this.addTaskFail = true;
              console.error(err);
            });
        },
        changeFlag() {
          setTimeout(() => {
            this.addTaskSuccess = false;
            this.addTaskFail = false;
          }, 5000);
        },
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
