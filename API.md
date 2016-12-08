
# API解释 (如果你需要某个API请在此提出)

*Tips:*  **请先在本地模拟数据**

### 登录/登出(/login)
1. 登录

```js
//请求
url:"www.bingblue.com/api/login",
type:"POST",
data:{userName:"xxx",userPwd:"***"}

//返回数据 json
{
  status:1 //1成功,0失败
  message:"登录成功！"//返回消息
  user:{ //成功的话返回user
    userId:1000001, //系统生成，类似QQ号
    userName:"xxx", //用户名
    userPwd:"***", //密码,md5加密
    nickName:"aaa", //昵称
    userPhone:"150", //手机号
    userSex:"男", //性别,男、女、人妖
    userEmail:"a@q.com", //邮箱
    userStatus:"1", //用户状态 1.正常 2.在线、3离线、0封禁
    userLvl:"1", //用户等级
    userVip:"1", //VIP等级
    regDate:"1000083788", //注册时间 ISODate("2015-07-15T05:47:31.743Z")
  }
}
```

### 注册(/reg) 
1. 检查用户名是否重复

```js
//请求
url:"www.bingblue.com/api/isRepeatByName",
type:"POST",
data:{userName:"xxx"}

//返回数据 json
{
  valid: false //false 用户名重复，不能注册，true 可以注册
}