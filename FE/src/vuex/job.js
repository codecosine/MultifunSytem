import {
  ADD_JOB_DETAILS,
  UPDATE_JOB_DETAILS,
  UPDATE_JOB,
} from './mutation-types';

const jobState = {
  jobDetails: [{
    id: '001',
    jobname: '数据库课程设计14信管2班',
    coursename: '数据库设计',
    courseclass: '14级信管2班',
    operator: '张沙清',
    requirements: '作业包含4个文件：1.数据库源文件 2.源代码 3.使用说明readMe 4.课程设计报告 ,请将4个文件打包成rar等压缩文件上交',
    deadTime: '2016-1-5',
  }, {
    id: '002',
    jobname: '商业数据分析',
    coursename: '商业数据分析',
    courseclass: '14级信管2班',
    operator: '2',
    requirements: '要求',
    deadTime: '2016-1-5',
  }, {
    id: '003',
    jobname: '数据库课程设计',
    coursename: '数据库设计',
    courseclass: '14级信管2班',
    operator: '张沙清',
    requirements: '要求',
    deadTime: '2016-1-5',
  }, {
    id: '004',
    jobname: '数据库课程设计',
    coursename: '数据库设计',
    courseclass: '14级信管2班',
    operator: '张沙清',
    requirements: '要求',
    deadTime: '2016-1-5',
  }],
  jobs: [{
    id: '001',
    username: '3114004923',
    jobname: '数据库课程设计2班',
    statu: 0,
    submitTime: '2017-1-9 00:35:56',
  }, {
    id: '002',
    username: '3114004924',
    jobname: '数据库课程设计1班',
    statu: 0,
    submitTime: '2017-1-9 00:35:56',
  }],
};
/* eslint no-param-reassign: ["error", { "props": false }] */
const mutations = {
  [ADD_JOB_DETAILS](state, data) {
    state.jobDetails.push(data);
  },
  [UPDATE_JOB_DETAILS](state, data) {
    state.jobDetails = data;
  },
  [UPDATE_JOB](state, data) {
    state.jobs = data;
  },
};
const actions = {
  fetchJobDetailsSuccess({ commit }, data) {
    commit(UPDATE_JOB_DETAILS, data);
  },
  fetchJobsSuccess({ commit }, data) {
    commit(UPDATE_JOB, data);
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
