package com.ilovefish.caviarapp.designmode.interpreter
/**
 *	解释器模式
 *	解释器模式是定义一个语言的文法，并且建立一个解释器来解释该语言中的句子，这里的“语言”是指使用规定格式和语法的代码。
 * */
class Interpreter {
	// 语言的文法
	class Context {
		fun assign() {}
		fun lookup() {}

		val map: Map<String, String> = mapOf()
	}

	interface Expression {
		fun interpret()
	}

	// 解释以上
	class TerminalExpression : Expression {
		override fun interpret() {}
	}

	class NoneTerminalExpression : Expression {
		override fun interpret() {}
	}

}