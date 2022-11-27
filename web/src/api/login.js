import request from '@/utils/request'

// 登录方法
export function login (user) {
  return request({
    url: '/user/login',
    headers: {
      isToken: false
    },
    method: 'post',

    data: user
  })
}

// 测试接口
export function testCors () {
  return request({
    url: '/testCors',
    method: 'post'
  })
}
