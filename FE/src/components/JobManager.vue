<template>
  <div class="container app-main">
    <div class="container">
      <div class="row">
        <div class="col-xs-10">
          <div class="form-group row">
            <label class="col-xs-1 col-form-label metatit">上传</label>
            <div class="col-xs-4">
              <file-upload
                title="上传文件"
                class="btn btn-secondary file-upload"
                :events="events"
                name="xls"
                post-action="/upload/xls"
                extensions="xls,xlsx"
                :files="files"
                ref="upload">
              </file-upload>
              <small class="form-text text-muted">请选择需要的.xls文件</small>

            </div>
          </div>
          <div class="form-group row">
            <label class="col-xs-1 col-form-label metatit">信息</label>
            <div class="col-xs-6">
                <ul class="fileInfo" v-for="file in files">
                  <div class="alert alert-info" v-if="file.success" role="alert">
                    <strong>上传成功!</strong>
                  </div>
                  <li class="alert alert-danger" v-if="!file.success" role="alert">
                    <strong>上传失败!</strong>
                  </li>
                  <li>文件名：{{file.name}}</li>
                  <li>大小：{{file.size | formatSize}}</li>
                </ul>
                <small class="form-text text-muted">文件信息</small>
            </div>
          </div>
          <div class="form-group row">
            <label class="col-xs-1 col-form-label metatit">算法</label>
            <div class="col-xs-6">
              <ul class="algorithm-select-list clearfix">
                <li v-for="item in algorithmList">
                  <a class="algorithm-select-item" v-on:click="selectAlgorithms(item)"
                     v-bind:class="{ 'algorithm-selected': algorithms.indexOf(item)!== -1 }" >
                    {{item.name}}
                  </a>
                </li>
              </ul>
            </div>
          </div>
          <div class="form-group row">
            <span class="text-mute">当前已经选择的算法为:[<span>
            <span class="text-mute" v-for="item in algorithms">{{item.name}},</span>
            <span class="text-mute">]</span>
          </div>
          <div class="form-group row">
            <label class="col-xs-1 col-form-label metatit">备注</label>
            <div class="col-xs-4">
              <input class="form-control" type="text" v-model="remark" placeholder="remark">
              <small class="form-text text-muted">添加备注以更方便标识任务</small>
            </div>
          </div>
          <div class="form-group row">
            <label class="col-xs-1 col-form-label"></label>
            <div class="col-xs-6">
              <button type="submit" v-on:click="addTask" class="btn btn-primary addTaskbtn" :disabled="valid.pass">添加到任务列表</button>
            </div>
          </div>
          <div class="form-group row" v-if="addTaskSuccess">
            <label class="col-xs-1 col-form-label"></label>
            <div class="col-xs-5">
              <div class="alert alert-success" role="alert">
                <h5 class="alert-heading">任务添加成功!</h5>
                <p>你可以到任务列表查看任务情况，或者继续添加任务！</p>
              </div>
            </div>
          </div>
          <div class="form-group row" v-if="addTaskFail">
            <label class="col-xs-1 col-form-label"></label>
            <div class="col-xs-5">
              <div class="alert alert-danger" role="alert">
                <h5 class="alert-heading">任务添加失败!</h5>
                <p>请检查参数是否正确再重试。</p>
              </div>
            </div>
          </div>

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
      filters: {
        formatSize(size) {
          if (size > 1024 * 1024 * 1024 * 1024) {
            return `${(size / 1024 / 1024 / 1024 / 1024).toFixed(2)} TB`;
          } else if (size > 1024 * 1024 * 1024) {
            return `${(size / 1024 / 1024 / 1024).toFixed(2)} GB`;
          } else if (size > 1024 * 1024) {
            return `${(size / 1024 / 1024).toFixed(2)} MB`;
          } else if (size > 1024) {
            return `${(size / 1024).toFixed(2)} KB`;
          }
          return `${size.toString()} B`;
        },
      },
      data() {
        return {
          /* 提交任务表单 */
          addTaskSuccess: false,
          addTaskFail: false,
          algorithm: 'IRE',
          algorithms: [],
          remark: '',
          /* 算法参数 */
          algorithmList: [
            {
              name: 'IRE',
              args: '',
              isSelected: true,
            },
            {
              name: 'CRE',
              args: '',
              isSelected: false,
            },
            {
              name: 'ICRE',
              args: '',
              isSelected: false,
            },
            {
              name: 'IIRE',
              args: '',
              isSelected: false,
            },
            {
              name: 'IRE3',
              args: '',
              isSelected: false,
            },
            {
              name: 'CRE3',
              args: '',
              isSelected: false,
            },
            {
              name: 'Yang',
              args: '',
              isSelected: false,
            },
            {
              name: 'Liu',
              args: '',
              isSelected: false,
            },
            {
              name: 'Guo',
              args: '',
              isSelected: false,
            },
          ],
          select(item) {
            this.algorithm = item.name;
            this.algorithmList.forEach((ele) => {
              ele.isSelected = false;
            });
            item.isSelected = true;
          },
          /*
            上传插件配置
           */
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
  .fileInfo {
    list-style: none;
    line-height: 15px;
    padding-left: 0px;
  }
  .fileInfo li{
    font-size: 14px;
    width: 60%;
  }
  .metatit{
    color: #838383;
    text-align: left;
    font-weight: bold;
  }
  dl dd{
    width: 350px;
    float: left;
  }
  .algorithm-select-list{
    margin: 0px;
    padding: 0px;
    list-style: none;
  }
  .algorithm-select-list li{
    float: left;
    position: relative;
    margin: 0 4px 4px 0;
    line-height: 28px;
    vertical-align: middle;
    padding: 2px;
    cursor: pointer;
  }
  .algorithm-select-list li a:hover{
    border: 1px solid #bd2013;
  }
  .algorithm-select-list li a {
    float: left;
    background-color: #fff;
    white-space: nowrap;
    width: auto!important;
    min-width: 10px;
    padding: 0 9px;
    text-align: center;
    border: 1px solid #b8b7bd;
    text-decoration: none;
  }
  .algorithm-select-list li .algorithm-selected{
    border: 1px solid #bd2013;
  }
  label {
    display: inline-block;
    margin-bottom: 0;
  }
</style>
