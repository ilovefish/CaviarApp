package com.ilovefish.caviarapp.designmode.strategy

fun main(args: Array<String>) {
	val strategyA = { println("StrategyA") }
	val strategyB = { println("StrategyB") }

	Strategy(strategyA).algorithm()
	Strategy(strategyB).algorithm()
}