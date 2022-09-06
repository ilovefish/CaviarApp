package com.ilovefish.caviarapp.designmode.bridge
// http://t.csdn.cn/wkDKh
/**
 * 桥接模式
 * 桥接模式可以分离某个类存在两个独立变化的纬度，
 * 把多层继承结构改为两个独立的继承结构，
 * 在两个抽象层中有一个抽象关联。
 *
 * 实现系统可能有多角度分类。
 * 每一种分类都可能变化，
 * 那么就把这种多角度分离出来让它们独立变化，
 * 减少他们的耦合。
 * */
class Bridge {

	interface Implemetor {
		fun operationImpl()
	}

	class ConcreteImplemetorA : Implemetor {
		override fun operationImpl() {
			println("ConcreteImplemetorA")
		}
	}

	class ConcreteImplemetorB : Implemetor {
		override fun operationImpl() {
			println("ConcreteImplemetorB")
		}
	}

	abstract class Abstraction(val impl: Implemetor) {
		abstract fun operation()
	}

	class RefinedAbstraction : Abstraction(impl = ConcreteImplemetorA()) {
		override fun operation() {
			impl.operationImpl()
		}
	}

}