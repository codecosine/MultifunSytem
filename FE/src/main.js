import Vue from 'vue';
import VueRouter from 'vue-router';
import VueResource from 'vue-resource';

import App from './App';

import JobDetails from './components/JobDetails';
import Job from './components/Job';
import JobManager from './components/JobManager';

Vue.use(VueRouter);
Vue.use(VueResource);
Vue.config.devtools = true;

const routes = [
  { name: 'home', path: '/', component: JobDetails },
  { name: 'jobDetails', path: '/jobDetails', component: JobDetails },
  { name: 'job', path: '/job/:jobId', component: Job },
  { name: 'jobManager', path: '/jobManager', component: JobManager },
];
const router = new VueRouter({
  routes,
});

/* eslint-disable no-new */
new Vue({
  router,
  el: '#app',
  template: '<App/>',
  components: { App },
});
