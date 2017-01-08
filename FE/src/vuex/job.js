import {
  UPDATE_JOB_DETAILS,
} from './mutation-types';

const jobState = {
  jobDetails: [{
    id: '123',
    jobname: '数据库课程设计',
    coursename: '数据库设计',
    courseclass: '14级信管2班',
    operator: '张沙清',
    requirements: '要求',
    deadTime: '2016-1-5',
  }, {
    id: '123',
    jobname: '数据库课程设计',
    coursename: '数据库设计',
    courseclass: '14级信管2班',
    operator: '张沙清',
    requirements: '要求',
    deadTime: '2016-1-5',
  }, {
    id: '123',
    jobname: '数据库课程设计',
    coursename: '数据库设计',
    courseclass: '14级信管2班',
    operator: '张沙清',
    requirements: '要求',
    deadTime: '2016-1-5',
  }, {
    id: '123',
    jobname: '数据库课程设计',
    coursename: '数据库设计',
    courseclass: '14级信管2班',
    operator: '张沙清',
    requirements: '要求',
    deadTime: '2016-1-5',
  }],
  jobs: [{
    id: '123',
    username: '3114004923',
    jobname: '数据库课程设计',
    statu: 0,
    submitTime: '2017-1-9 00:35:56',
  }],
};
/* eslint no-param-reassign: ["error", { "props": false }] */
const mutations = {
  [UPDATE_JOB_DETAILS](state, data) {
    state.jobDetails = data;
  },
};
const actions = {
  fetchJobDetailsSuccess({ commit }, data) {
    commit(UPDATE_JOB_DETAILS, data);
  },

};
const getters = {
  jobDetails: state => state.jobDetails,
  jobs: state => state.jobs,
};
export default {
  state: jobState,
  mutations,
  actions,
  getters,
};
