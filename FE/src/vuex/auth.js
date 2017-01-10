import {
  UPDATE_USER,
  UPDATE_MSG,
  UPDATE_TOKEN,
  LOGOUT_SUCCESS,
} from './mutation-types';

const authState = {
  token: null,
  message: {
    show: false,
    msgstate: 'info',
    msg: '',
  },
  user: {
    id: '',
    username: '未登录',
    role: '未登录',
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
  signInError({ commit }) {
    commit(UPDATE_MSG, { msgstate: 'danger', msg: '登录失败，请重试！' });
  },
  logout({ commit }) {
    commit(LOGOUT_SUCCESS);
    commit(UPDATE_MSG, { msgstate: 'info', msg: '注销成功' });
  },
  tokenAuthFalse({ commit }) {
    commit(UPDATE_MSG, { msgstate: 'danger', msg: '本地权限已经过期失效，请尝试使用用户密码登录' });
  },
  closeMsg({ commit }) {
    commit(UPDATE_MSG, { msgstate: 'info', msg: '' });
  },
};
const authGetters = {
  username: state => state.user.username,
  token: state => state.token,
  message: state => state.message,
  user: state => state.user,
};
export default {
  state: authState,
  mutations,
  actions,
  getters: authGetters,
};
