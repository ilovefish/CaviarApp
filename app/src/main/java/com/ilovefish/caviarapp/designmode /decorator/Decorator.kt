package com.ilovefish.caviarapp.designmode.decorator
// http://t.csdn.cn/L3mdM
/**
 * 装饰模式
 * 装饰模式可以给一个对象添加额外的行为，在Kotlin下可以用扩展函数实现。
 * */
class Decorator {
	class Component {
		fun operation() {
			println("operation")
		}
	}

	fun Component.decorate(method: Component.() -> Unit) {
		println("do before")
		method()
		println("do after")
	}

	fun testDecorate() {
		Component().run {
			decorate {
				operation()
			}
		}
	}
}