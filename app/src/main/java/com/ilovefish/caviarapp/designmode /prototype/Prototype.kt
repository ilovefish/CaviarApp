package com.ilovefish.caviarapp.designmode.prototype
// http://t.csdn.cn/Qyili
/**
 * 原型：
 * 原型模式是以一个对象为原型，创建出一个新的对象，在Kotlin下很容易实现，用data class的copy就可以。
 * */
class Prototype {

	data class Product(var name:String) {}
	
	val prototype = Product("product")
	
	// Shallow copy
	val product = prototype.copy()

}