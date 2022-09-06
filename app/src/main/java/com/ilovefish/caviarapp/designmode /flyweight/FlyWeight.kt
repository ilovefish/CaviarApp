package com.ilovefish.caviarapp.designmode.flyweight

abstract class AFlyWeight {
	abstract fun operation()
}

class ConcreteFlyWeight : AFlyWeight() {
	override fun operation() {
		println("ConcreteFlyWeight")
	}
}

class UnsharedFlyWeight : AFlyWeight() {
	override fun operation() {
		println("UnsharedFlyWeight")
	}
}

enum class FlyWeight {
	CONCRETE, UNSHARED
}

// http://t.csdn.cn/ZftmJ
/**
 * 享元模式
 * 享元模式以共享的方式高效地支持大量细粒度对象的重用，享元对象能做到共享的关键是区分了可共享内部状态和不可共享外部状态。
 * 在kotlin中，字符串String中也运用到了享元模式。第一次创建了字符串对象a，下次再创建b时只是把引用指向常量池中的‘你好’。
 * */
class FlyWeightFactory {
	// 共享内部状态 map
	private val map: HashMap<FlyWeight, AFlyWeight> = HashMap()

	init {
		map.put(FlyWeight.CONCRETE, ConcreteFlyWeight())
		map.put(FlyWeight.UNSHARED, UnsharedFlyWeight())
	}

	fun getFlyWeight(key: FlyWeight): AFlyWeight {
		return map.getValue(key)
	}
}