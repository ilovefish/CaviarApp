package com.ilovefish.caviarapp.designmode.observer

import kotlin.properties.Delegates

interface IObserver {
	fun update(state: String)
}

class Obeserver : IObserver {
	override fun update(state: String) {
		println(state)
	}
}

// http://t.csdn.cn/ZFWNU
/**
 * 观察者模式
 * 是一个对象状态发生变化后，可以立即通知已订阅的另一个对象。
 * */
class Observable {
	var observers: MutableList<IObserver> = mutableListOf()

	fun attach(observer: IObserver) {
		observers.add(observer)
	}

	fun detach(observer: IObserver) {
		observers.remove(observer)
	}

	var state: String by Delegates.observable("0") {
		prop, old, new ->
		for (observer in observers) {
			observer.update("$old -> $new")
		}
	}
}