package com.ilovefish.caviarapp.designmode.iterator

// http://t.csdn.cn/6GssE
/**
 *	迭代器模式
 *	迭代器模式提供一种不暴露底层实现情况下的遍历聚合对象中的元素的一种方式。
 * */
interface Aggretate<T> {
	val iterator: Iterator<T>
}

class ConcreteAggretate(val words: List<String>) : Aggretate<String> {
	override val iterator = words.iterator()
}

// 迭代器函数表示使用 words.iterator() 迭代器
operator fun ConcreteAggretate.iterator(): Iterator<String> = words.iterator()
