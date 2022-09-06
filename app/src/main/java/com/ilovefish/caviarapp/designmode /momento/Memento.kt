package com.ilovefish.caviarapp.designmode.momento

// http://t.csdn.cn/81jbh
/**
 * 	备忘录模式
 * 	是在不破坏封装的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态，这样可以在以后将对象恢复到原先保存的状态。
 * */
data class Memento(var state: String?)

data class Originator(var state: String?) {
	fun save() = Memento(this.state)

	fun restore(memento: Memento?) {
		this.state = memento?.state
	}
}

data class Caretaker(var memento: Memento?)
	
