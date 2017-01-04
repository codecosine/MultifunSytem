import Vue from 'vue';
import Vuex from 'vuex';

import auth from './auth';
import job from './job';

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    auth,
    job,
  },
  strict: process.env.NODE_ENV !== 'production',
});
