package com.ilovefish.caviarapp.designmode.command

interface ICommand {
	fun request()
}

// http://t.csdn.cn/hgOTB
/**
 * 命令模式
 * 将请求封装为命令对象，解耦请求发送者与接收者，对请求排队或者记录请求日志，以及支持可撤销的操作。
 * */

// 顾客->服务员->传递命令->厨师烤肉->顾客接收
// 将一个接受者对象绑定于一个动作，调用接收者相应的操作
class Command : ICommand {
	val receiver: Receiver = Receiver()

	override fun request() {
		receiver.action()
	}
}
// 命令执行请求
class Invoker {
	var command: ICommand = Command()

	fun call() {
		command.request()
	}
}

// 知道如何实施与执行一个请求相关的操作
class Receiver {
	fun action() {
		println("Receiver do action")
	}
}

