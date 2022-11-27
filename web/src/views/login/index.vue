<template>
  <div>
    <van-nav-bar title="登录" />
    <van-form @submit="onSubmit">
      <van-field
        v-model="user.userName"
        name="用户名"
        label="用户名"
        placeholder="用户名"
        :rules="[{ required: true, message: '请填写用户名' }]"
      />
      <van-field
        v-model="user.password"
        type="password"
        name="密码"
        label="密码"
        placeholder="密码"
        :rules="[{ required: true, message: '请填写密码' }]"
      />
      <div style="margin: 16px">
        <van-button round block type="info" native-type="submit"
          >登录</van-button
        >
      </div>
    </van-form>
    <!-- 居中 -->
    <van-row type="flex" justify="center">
      <van-col span="6">
        <van-button type="primary" @click="sendRequest">测试接口</van-button>
      </van-col>
    </van-row>
  </div>
</template>

<script>
import { login, testCors } from '@/api/login'
import { setToken } from '@/utils/auth'
export default {
  name: 'login',
  data () {
    return {
      user: {
        userName: '', // 用户名
        password: '' // 密码
      }
    }
  },
  methods: {
    async sendRequest () {
      try {
        const res = await testCors()
        console.log(res)
        this.$toast.success('请求成功')
      } catch (err) {
        this.$toast.fail('请求失败')
      }
    },
    async onSubmit () {
      // 1. 获取表单数据
      const user = this.user
      // 3. 提交表单请求登录
      this.$toast.loading({
        message: '登录中...',
        forbidClick: true, // 禁用背景点击
        duration: 500 // 持续时间，默认 2000，0 表示持续展示不关闭
      })
      try {
        const res = await login(user)
        if (res.data.token) {
          setToken(res.data.token)
        }

        // if (res.code === 200) {
        //   this.$toast.success('登录成功')
        // } else {
        //   this.$toast.success(res.message)
        // }
        console.log('res', res)
      } catch (err) {
        this.$toast.fail('登录失败，请稍后重试')
      }
      // 4. 根据请求响应结果处理后续操作
    }
  }
}
</script>

<style scoped lang="less">
</style>
