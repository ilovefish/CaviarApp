package com.hunagyu.factory

// http://t.csdn.cn/Akiuf
/**
 * 工厂方法
 * 工厂方法把创建对象的过程抽象为接口，由工厂的子类决定对象的创建。
 * */
class FactoryMethod {

	abstract class AProduct(val name: String)

	class ProductA : AProduct("ProductA")
	class ProductB : AProduct("ProductB")

	interface IFactory {
		fun makeProduct(): AProduct
	}

	class FactoryA : IFactory {
		override fun makeProduct() = ProductA()
	}

	class FactoryB : IFactory {
		override fun makeProduct() = ProductB()
	}

}
