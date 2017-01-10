import Vue from 'vue';
import VueRouter from 'vue-router';
import VueResource from 'vue-resource';

import App from './App';
import JobDetails from './components/JobDetails';
import Job from './components/Job';
import JobManager from './components/JobManager';
import Welcome from './components/welcome';
import Session from './components/Session';

Vue.use(VueRouter);
Vue.use(VueResource);
Vue.config.devtools = true;

const routes = [
  { name: 'welcome', path: '/', component: Welcome },
  { name: 'session', path: '/session/:type', component: Session },
  { name: 'jobDetails', path: '/app/jobDetails', component: JobDetails },
  { name: 'job', path: '/app/job/:jobId', component: Job },
  { name: 'jobManager', path: '/app/jobManager', component: JobManager },
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
