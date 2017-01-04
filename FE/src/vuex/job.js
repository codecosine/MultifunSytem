import {
  UPDATE_JOB_DETAILS,
} from './mutation-types';

const jobState = {
  jobDetails: [{
    jobId: '123',
    jobName: '数据库课程设计',
    courseName: '数据库设计',
    courseClass: '14级信管2班',
    introdution: '简介',
    requirement: '要求',
    deadTime: '2016-1-5',
  }, {
    jobId: '100',
    jobName: '数据库课程设计2',
    courseName: '数据库设计',
    courseClass: '14级信管2班',
    introdution: '简介',
    requirement: '要求',
    deadTime: '2016-1-5',
  }],
  jobs: [{
    id: '0001',
    courseName: '数据库课程设计',
    courseClass: '14信管2班',
    statu: '1',
    introdution: '简介',
    date: '2017年01月04日22:55:26',
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
  fetchJobDetailsById({ state }, id) {
    const jobDetails = state.jobDetails;
    let result = null;
    jobDetails.forEach((ele) => {
      if (ele.id === id) {
        result = ele;
      }
    });
    return result;
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
