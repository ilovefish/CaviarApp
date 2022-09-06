package com.ilovefish.caviarapp.designmode.facade
// http://t.csdn.cn/k31RW
/**
 *	外观模式
 *	外观模式是为一个复杂的子系统提供一个简化的统一接口。
 *  客户端可以在根本不知道三个子系统的存在。
 *  对子系统的方法进行整合，方便外部调用。
 * */
class Facade {
	class SubSystemA {
		fun methodA() {}
	}

	class SubSystemB {
		fun methodB() {}
	}

	class SubSystemC {
		fun methodC() {}
	}

	val subSA: SubSystemA = SubSystemA()
	val subSB: SubSystemB = SubSystemB()
	val subSC: SubSystemC = SubSystemC()

	fun operationA() {
		subSA.methodA()
		subSB.methodB()
	}

	fun operationB() {
		subSB.methodB()
		subSC.methodC()
	}

}