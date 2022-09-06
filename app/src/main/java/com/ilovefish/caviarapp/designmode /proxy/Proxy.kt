package com.ilovefish.caviarapp.designmode.proxy

interface ISubject {
	fun request()
}

class RealSubject : ISubject {
	override fun request() {}
}

// http://t.csdn.cn/ucynG
/**
 * 代理模式
 * 代理模式是使用一个代理对象来访问目标对象的行为。
 * */
// 代理对象
class Proxy : ISubject {
	// 真实目标对象，隐真实对象
	private val subject = RealSubject()

	// 添加额外功能
	fun preRequest() {}
	fun postRequest() {}

	override fun request() {
		preRequest()
		subject.request()
		postRequest()
	}
}