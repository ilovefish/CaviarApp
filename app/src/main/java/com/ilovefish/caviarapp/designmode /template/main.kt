package com.ilovefish.caviarapp.designmode.template

fun main(args: Array<String>) {
	Template().templateMethod({
		println("methodA")
	}, {
		println("methodB")
	}, {
		println("methodC")
	})
}