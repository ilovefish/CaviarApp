package com.ilovefish.caviarapp.designmode.visitor

fun main(args: Array<String>) {
	val visitor = Visitor()
	val concreteElementA = ConcreteElementA("ElementA")
	val concreteElementB = ConcreteElementB("ElementB")
	concreteElementA.accept(visitor)
	concreteElementB.accept(visitor)
}