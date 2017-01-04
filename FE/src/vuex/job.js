import {
  UPDATE_JOB_LIST,
} from './mutation-types';

const jobState = {
  jobList: [{
    jobId: '123',
    jobName: '数据库课程设计',
    courseName: '数据库设计',
    courseClass: '14级信管2班',
    introduction: '简介',
    requirement: '要求',
    deadTime: '2016-1-5',
  }, {
    jobId: '100',
    jobName: '数据库课程设计2',
    courseName: '数据库设计',
    courseClass: '14级信管2班',
    introduction: '简介',
    requirement: '要求',
    deadTime: '2016-1-5',
  }],

};
/* eslint no-param-reassign: ["error", { "props": false }] */
const mutations = {
  [UPDATE_JOB_LIST](state, data) {
    state.jobList = data;
  },

};
const actions = {
  fetchJobList({ commit }, data) {
    commit(UPDATE_JOB_LIST, data);
  },
};
const getters = {
  jobList: state => state.jobList,
};

export default {
  state: jobState,
  mutations,
  actions,
  getters,
};
