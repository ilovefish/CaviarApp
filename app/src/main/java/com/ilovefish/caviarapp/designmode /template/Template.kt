package com.ilovefish.caviarapp.designmode.template

interface ITemplate {
	fun templateMethod(methodA: () -> Unit, methodB: () -> Unit, methodC: () -> Unit)
}

/**
 * 模版方法模式
 * 模板方法模式提供了一个模板方法来定义算法框架，
 * 而某些具体步骤的实现可以在其子类中完成。
 * */
class Template : ITemplate {

	//  Kotlin 中使用高阶函数可以避免继承的方式。
	override fun templateMethod(methodA: () -> Unit, methodB: () -> Unit, methodC: () -> Unit) {
		methodA()
		methodB()
		methodC()
	}

}