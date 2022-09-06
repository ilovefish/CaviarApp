package com.ilovefish.caviarapp.designmode.state

// http://t.csdn.cn/vei2j
/**
 * 状态模式
 * 状态模式将一个对象在不同状态下的不同行为封装在一个个状态类中，通过设置不同的状态可以让对象拥有不同的行为。
 * */
sealed class State(val name: String) {
	abstract fun handle()
	class ConcreteStateA : State(name = "StateA") {
		override fun handle() {
			println("$name")
		}
	}

	class ConcreteStateB : State(name = "StateB") {
		override fun handle() {
			println("$name")
		}
	}
}

class Context {
	private var state: State = State.ConcreteStateA()

	val name: String get() = state.name

	fun request() {
		state.handle()
	}

	fun setState(state: State) {
		this.state = state
	}
}