package com.ilovefish.caviarapp.designmode.mediator

interface IMediator {
	fun register(colleagur: AColleague)
	fun operation(i: Int)
}

// http://t.csdn.cn/4tedc
/*
 * 中介者模式
 * 中介者模式用一个中介对象（中介者）来封装一系列的对象交互，中介者使各对象不需要显式地相互引用，
 * 从而使其耦合松散，而且可以独立地改变它们之间的交互。
 * */
class Mediator : IMediator {
	var colleagues: MutableList<AColleague> = mutableListOf()

	override fun register(colleagur: AColleague) {
		colleagues.add(colleagur)
	}

	override fun operation(i: Int) {
		colleagues.get(i).operation()
	}
}

abstract class AColleague(val mediator: IMediator) {
	abstract fun selfMethod()
	abstract fun communicate(i: Int)
	abstract fun operation()
}

class ConcreteColleague(val name: String, mediator: IMediator) : AColleague(mediator) {
	override fun selfMethod() {}

	override fun communicate(i: Int) {
		mediator.operation(i)
	}

	override fun operation() {
		println(name + "operation")
	}
}