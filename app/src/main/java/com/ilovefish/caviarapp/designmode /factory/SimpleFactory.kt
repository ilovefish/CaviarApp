package com.ilovefish.caviarapp.designmode.factory
// http://t.csdn.cn/RoNRe
/**
 * 	简单工厂
 * 	定义一个工厂类，它可以根据参数的不同返回不同类的实例。
 * */
class SimpleFactory {

	abstract class AProduct(val name: String)

	class ProductA : AProduct("ProductA")
	class ProductB : AProduct("ProductB")

	interface IFactory {
		fun makeProduct(name: String): AProduct?
	}

	class Factory : IFactory {
		override fun makeProduct(name: String): AProduct? {
			when (name) {
				"A" -> return ProductA()
				"B" -> return ProductB()
				else -> return null
			}
		}
	}

}