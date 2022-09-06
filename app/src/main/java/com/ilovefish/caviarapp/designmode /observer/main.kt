package com.ilovefish.caviarapp.designmode.observer

fun main(args: Array<String>) {
	val observable = Observable()
	observable.attach(Obeserver())
	observable.state = "1"
	observable.state = "2"
	observable.state = "3"
}