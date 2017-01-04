import Vue from 'vue';
import {
  UPDATE_USER,
  UPDATE_MSG,
  UPDATE_TOKEN,
  LOGOUT_SUCCESS,
  SIGNIN_REQUEST,
  SIGNIN_REQUEST_FINISH,
  UPDATE_USER_MSG,
  CLEAR_USER_MSG,
} from './mutation-types';

const authState = {
  token: null,
  request: false,
  message: {
    success: false,
    msg: '',
  },
  user: {
    id: '',
    username: '未登录',
    role: '',
  },
};
/* eslint no-param-reassign: ["error", { "props": false }] */
const mutations = {
  [UPDATE_USER](state, data) {
    state.user = data;
  },
  [UPDATE_MSG](state, data) {
    state.message = data;
  },
  [UPDATE_TOKEN](state, data) {
    state.token = data;
  },
  [LOGOUT_SUCCESS](state) {
    state.token = null;
    state.user = {
      username: '未登录',
    };
  },
  [SIGNIN_REQUEST](state) {
    state.request = true;
  },
  [SIGNIN_REQUEST_FINISH](state) {
    state.request = false;
  },
  [CLEAR_USER_MSG](state) {
    state.usermsg = {
      msgstate: false,
      msg: '',
    };
  },
};
const actions = {
  signInSuccess({ state, commit }, data) {
    const loginUser = JSON.parse(data.content);
    commit(UPDATE_USER, { id: loginUser.id, username: loginUser.username, role: loginUser.role });
    commit(UPDATE_MSG, { success: data.success, msg: data.message });
    commit(UPDATE_TOKEN, 'TEMP');
  },
  signInFail({ state, commit }, data) {
    commit(UPDATE_MSG, { success: data.success, msg: data.message });
  },
  signInRequest({ state, commit }, user) {
    if (state.request) {
      return new Error('请求重复发送');
    }
    commit(SIGNIN_REQUEST);
    return Vue.http.post('/auth', user);
  },
  signUpRequest({ state, commit }, user) {
    if (state.request) {
      commit(UPDATE_USER_MSG, { msgstate: 'danger', msg: '请不要尝试多次登录' });
      return new Error('请求重复发送');
    }
    commit(SIGNIN_REQUEST);
    return Vue.http.post('/register', user);
  },
  signInError({ commit }) {
    commit(SIGNIN_REQUEST_FINISH);
    commit(UPDATE_USER_MSG, { msgstate: 'danger', msg: '登录失败，请重试！' });
  },
  updateInfoMsg({ commit }, msg) {
    commit(UPDATE_USER_MSG, { msgstate: 'info', msg });
  },
  clearUserMsg({ commit }) {
    commit(CLEAR_USER_MSG);
  },

  logout({ commit }) {
    commit(LOGOUT_SUCCESS);
    commit(UPDATE_USER_MSG, { msgstate: 'info', msg: '注销成功' });
  },
  tokenAuthFalse({ commit }) {
    commit(UPDATE_USER_MSG, { msgstate: 'danger', msg: '本地权限已经过期失效，请尝试使用用户密码登录' });
  },
};
const authGetters = {
  username: state => state.user.username,
  token: state => state.token,
  message: state => state.usermsg,
  user: state => state.user,
};
export default {
  state: authState,
  mutations,
  actions,
  getters: authGetters,
};
