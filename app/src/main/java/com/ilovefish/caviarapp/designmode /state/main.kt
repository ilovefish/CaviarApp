package com.ilovefish.caviarapp.state

fun main(args: Array<String>) {
	val context = Context()
	context.request()
	context.setState(State.ConcreteStateB())
	context.request()
}
	
