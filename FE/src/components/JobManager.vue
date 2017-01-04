<template>
  <div class="container bs-main">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <h2 class="page-header"><span class="glyphicon glyphicon-tag"></span>课程信息安排</h2>
          <div class="loading" v-if="loading">
            <div class="text-xs-center" >加载列表中......
            </div>
          </div>
          <file-check-modal :show="modalShow" :resultFile="modalFile" :tables="modalTable" :close="closeModal"></file-check-modal>
          <div class="row cs-content">
            <div class="col-lg-6">
              <button type="button" class="btn btn-primary" v-on:click="$router.push('/addTask')">+ 新建任务</button>
            </div>
            <div class="col-lg-6">
                <div class="input-group">
                  <input type="text" class="form-control" v-model="searchQuery" placeholder="输入算法名/备注进行搜索...">
                </div>
            </div>
            <div class="col-lg-12">
              <table class="table table-list">
                <thead class="thead-default">
                <tr>
                  <th>#id</th>
                  <th>课程名称</th>
                  <th>班级</th>
                  <th>状态</th>
                  <th>操作时间</th>
                  <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item in jobs">
                  <th scope="row">{{ index+1 }}</th>
                  <td>
                    <span>{{ item.id }}</span>
                  </td>
                  <td>
                    <span class="text-primary" >{{ item.courseName }}</span>
                  </td>
                  <td>
                    <span class="text-primary" >{{ item.courseClass }}</span>
                  </td>
                  <td>
                    <div>
                      <span v-bind:class="statusClassObject(item.status)" >{{ item.status | formatStatus }}</span>
                    </div>
                  </td>
                  <td>
                    <span class="text-primary" >{{ item.date }}</span>
                  </td>
                  <td>
                    <div class="operate-cell">
                      <a role="button">修改</a>
                      <a role="button">删除</a>
                      <a role="button" v-if="item.status === 1" v-bind:href="'/download?resultFile='+item.resultFile">下载</a>
                    </div>
                  </td>
                </tr>
                </tbody>
              </table>
            </div>
            <div class="col-lg-12">
              <div class="list-split">
                <div class="list-state">
                  <span class="tc-15-page-text"><!--if start-->
                    共<strong>0</strong>条记录，当前页有<strong>1</strong>条</span>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
    export default{
      filters: {
        formatDate(time) {
          if (!time) {
            return '无';
          }
          const date = new Date(time);
          const o = {
            month: date.getMonth() + 1,
            day: date.getDate(),
            hours: date.getHours(),
            minutes: date.getMinutes(),
            seconds: date.getSeconds(),
            years: date.getFullYear(),
          };
          return `${o.years}-${o.month}-${o.day} ${o.hours}:${o.minutes}:${o.seconds}`;
        },
        formatStatus(status) {
          if (status === 0) {
            return '计算中';
          }
          if (status === 1) {
            return '计算完成';
          }
          if (status === 2) {
            return '计算错误';
          }
          return '错误';
        },
      },
      data() {
        return {
          loading: false,
          error: null,
          searchQuery: '',
        };
      },
      computed: {
        jobs() {
          return this.$store.getters.jobs;
        },
      },
      methods: {
      },
    };
</script>
<style>

</style>
