package com.ilovefish.caviarapp.designmode.strategy

// http://t.csdn.cn/95PbS
/**
 * 策略模式
 * 策略模式用于算法的自由切换和扩展，分离算法的定义与实现，在 Kotlin 中可以使用高阶函数作为算法的抽象。
 * */
class Strategy(inline val method: () -> Unit) {
	fun algorithm() {
		method()
	}
}