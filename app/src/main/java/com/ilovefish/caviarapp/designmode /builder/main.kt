package com.ilovefish.caviarapp.designmode.builder

fun main(args: Array<String>) {
	val product = Product.build {
		name = "name"
		num = 1
	}
	
	println(product.name);
	println(product.num);

	val applyProduct = ApplyProduct()
	//通过with来实现
	with(applyProduct, {
		color ="red"
		width = 2f
		round = true
	})
	applyProduct.write()

	applyProduct.apply {
		color = "gray"
		width = 6f
		round = false
		write()
	}
}