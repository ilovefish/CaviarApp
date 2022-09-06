package com.hunagyu.factory

// http://t.csdn.cn/iCA61
/**
 * 抽象工厂
 * 工厂方法针对一种产品，而抽象工厂是针对一系列产品，为每种产品定义一个工厂方法，工厂子类负责创建该系列的多种产品。
 * */
class AbstractFactory {

	abstract class AProductA(val name: String)

	class ProductA1 : AProductA("ProductA1")
	class ProductA2 : AProductA("ProductA2")

	abstract class AProductB(val name: String)

	class ProductB1 : AProductB("ProductB1")
	class ProductB2 : AProductB("ProductB2")

	interface IFactory {
		fun makeProductA(): AProductA
		fun makeProductB(): AProductB
	}

	class FactoryA : IFactory {
		override fun makeProductA() = ProductA1()
		override fun makeProductB() = ProductB1()
	}

	class FactoryB : IFactory {
		override fun makeProductA() = ProductA2()
		override fun makeProductB() = ProductB2()
	}

}