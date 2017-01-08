### 主要功能
@ version 1.0.0
#### 平台服务
- 权限中间件,使用token验证,每次操作经过这个验证
#### 角色公共方法
- 登录/注销/修改密码/
- 获取平台发布的信息
#### 学生
- 获取自己的作业信息
- 增删改查作业信息
#### 教师
- 修改/发布平台的信息
- 获取作业信息列
- 增删改查作业信息列
- 打包作业信息列下载
### 以上功能前端接口
##### 登录
- 接口：/auth
- 类型：post
- 参数：{ user:{ username, password } }
- 返回值：{ sucess,msg,token}
##### 注销
- 接口：/logout
- 类型：post
- 参数：{ username }
- 返回值：{ sucess,msg }
##### 修改密码
- 接口：/resetPassword
- 类型：post
- 参数：{ user:{ username, newpass } }
- 返回值：{ sucess,msg }

##### 获取平台发布的信息
- 接口：/infoList
- 类型：get
- 参数：null
- 返回值：{ list:[] }
##### 获取自己的作业信息
- 接口：/job
- 类型：get
- 参数：httpHeader-token
- 返回值：{ list:[] }

##### 增删改查自己的作业信息
- 接口：/
- 类型：get
- 参数：null
- 返回值：{ success, msg }
/updatejob
/

# models
#### user
- id
- name
- password
- role
#### job
- id
- user_id
- name
- status
- date
- job_detail
- job_url
#### jobDetail
- name
- courseName
- introdution
- requirement
- deadTime
# todolist工作日程安排

- 登录弹窗
- 注册页面
