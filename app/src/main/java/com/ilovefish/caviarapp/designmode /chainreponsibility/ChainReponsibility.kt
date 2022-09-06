package com.ilovefish.caviarapp.designmode.chainreponsibility

// http://t.csdn.cn/iEPQR
/**
 * 职责链模式
 * 职责链模式通过建立一条链来组织请求的处理者，请求将沿着链进行传递。
 */
class ChainReponsibility {

	interface Handler {
		var next: Handler?
		fun doHandle()
	}

	class ConcreteHandlerA() : Handler {
		override var next: Handler? = ConcreteHandlerB()
		override fun doHandle() {}
	}

	class ConcreteHandlerB() : Handler {
		override var next: Handler? = ConcreteHandlerC()
		override fun doHandle() {}
	}

	class ConcreteHandlerC() : Handler {
		override var next: Handler? = null
		override fun doHandle() {}
	}

}