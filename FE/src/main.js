import Vue from 'vue';
import VueRouter from 'vue-router';
import VueResource from 'vue-resource';
import App from './App';

import Home from './components/Home';

Vue.use(VueRouter);
Vue.use(VueResource);

const routes = [
  { path: '/', component: Home },
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
