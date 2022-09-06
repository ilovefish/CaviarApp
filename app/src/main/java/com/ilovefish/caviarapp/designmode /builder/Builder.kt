package com.ilovefish.caviarapp.designmode.builder
// http://t.csdn.cn/sgmh9
/**
 * 建造者
 * 建造者模式是为了构建复杂对象的，一般情况下，Kotlin中使用标准的apply函数就可以。
 * */
class Product(val name: String?, val num: Int) {
	private constructor(builder: Builder) : this(builder.name, builder.num)

	class Builder(var name: String? = null, var num: Int = 0) {
		fun build() = Product(this)
	}

	companion object {
		inline fun build(block: Builder.() -> Unit) = Builder().apply(block).build()
	}
}

class ApplyProduct {
	var color: String = "white"
	var width: Float = 1.0f
	var round: Boolean = false

	fun write(){
		print("color:${color}, width:${width}, round:${round}")
	}
}