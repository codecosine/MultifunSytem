<template>
  <div class="container bs-main">
    <div class="container">
      <div class="row">
        <div class="col-xs-12">
          <h2 class="page-header"><span class="glyphicon glyphicon-star"></span>作业信息列表</h2>
          <div class="loading" v-if="loading">
            <div class="text-xs-center" >加载列表中......
            </div>
          </div>
          <div class="row cs-content">
            <div class="pull-right searchQuery">
                <div class="input-group">
                  <input type="text" class="form-control" v-model="searchQuery" placeholder="输入作业名/学号进行筛选...">
                </div>
            </div>
            <div class="col-lg-12">
              <table class="table table-list">
                <thead class="thead-default">
                <tr>
                  <th>作业号</th>
                  <th>作业名</th>
                  <th>学号</th>
                  <th>状态</th>
                  <th>操作时间</th>
                  <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <tr v-for="item in filteredItems">
                  <th scope="row">{{ item.id }}</th>
                  <td>
                    <span class="text-primary" >{{ item.jobname }}</span>
                  </td>
                  <td>
                    <span>{{ item.username }}</span>
                  </td>
                  <td>
                    <div>
                      <span v-bind:class="statusClassObject(item.statu)" >{{ item.statu | formatStatus }}</span>
                    </div>
                  </td>
                  <td>
                    <span>{{ item.submitTime }}</span>
                  </td>
                  <td>
                    <div class="operate-cell">
                      <a class="text-primary" role="button">修改</a>
                      <a class="text-primary" role="button">删除</a>
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
                    共<strong>{{ filteredItems.length }}</strong>条记录，当前页有<strong>1</strong>条</span>
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
      created() {
        this.fetchJobs();
      },
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
            return '待审核';
          }
          if (status === 1) {
            return '已完成';
          }
          if (status === 2) {
            return '错误';
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
        filteredItems() {
          const self = this;
          return self.jobs.filter(item => item.username.indexOf(self.searchQuery) !== -1 ||
          item.jobname.includes(self.searchQuery));
        },
      },
      methods: {
        statusClassObject(status) {
          if (status === 1) {
            return { 'text-success': true };
          }
          if (status === 2) {
            return { 'text-danger': true };
          }
          return { 'text-primary': true };
        },
        fetchJobs() {
          this.$http.get('/MultifunSystemServer/Jobs')
          .then((res) => {
            this.$store.dispatch('fetchJobsSuccess', res.data);
          }, (err) => {
            this.error = err.toString();
          });
        },
      },
    };
</script>
<style>
 .searchQuery{
   margin-bottom: 1.5rem;
 }

</style>
