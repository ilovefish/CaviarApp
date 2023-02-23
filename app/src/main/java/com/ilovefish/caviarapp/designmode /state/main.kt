package com.ilovefish.caviarapp.state

import com.ilovefish.caviarapp.designmode.state.Context
import com.ilovefish.caviarapp.designmode.state.State

fun main(args: Array<String>) {
	val context = Context()
	context.request()
	context.setState(State.ConcreteStateB())
	context.request()
}
	
