package com.ilovefish.caviarapp.designmode.adapter
interface Target {
	fun request()
}

class Adaptee {
	fun ask() {
		println("ask")
	}
}
// http://t.csdn.cn/ANS8A
/**
 * 适配器
 * 适配器模式是把一个不兼容的接口转化为另一个类可以使用的接口。
 * */
class Adapter(val adaptee: Adaptee) : Target {
	override fun request() {
		adaptee.ask()
	}
}