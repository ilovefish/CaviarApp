package com.ilovefish.caviarapp.designmode.decorator

import com.ilovefish.caviarapp.designmode.facade.Facade

fun main(args: Array<String>) {
	val facade = Facade()//facade作用：客户端可以在根本不知道三个子系统的存在
	facade.operationA()//对子系统的方法进行整合，方便外部调用
	facade.operationB()
}
