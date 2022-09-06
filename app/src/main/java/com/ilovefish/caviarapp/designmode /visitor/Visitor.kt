package com.ilovefish.caviarapp.designmode.visitor

interface IElement {
	fun accept(visitor: IVisitor)
	fun operation()
}

class ConcreteElementA(val name: String) : IElement {
	override fun accept(visitor: IVisitor) = visitor.visit(this)
	override fun operation() {
		println("$name")
	}
}

class ConcreteElementB(val name: String) : IElement {
	override fun accept(visitor: IVisitor) = visitor.visit(this)
	override fun operation() {
		println("$name")
	}
}

interface IVisitor {
	fun visit(elementA: ConcreteElementA)
	fun visit(elementB: ConcreteElementB)
}

// http://t.csdn.cn/KYnDa
/**
 * 访问者模式
 * 访问者模式提供一个作用于某对象结构中的各元素的操作表示，
 * 它使我们可以在不改变各元素的类的前提下定义作用于这些元素的新操作。
 *
 * 把处理从数据结构分离除了。（把数据结构和作用于结构上的操作之间的耦合解脱开，使得操作集合可以相对自由地演化）
 * */
// ElementA 和 B 由 Visitor 来执行具体不同的操作
class Visitor : IVisitor {
	override fun visit(elementA: ConcreteElementA) {
		elementA.operation()
	}

	override fun visit(elementB: ConcreteElementB) {
		elementB.operation()
	}
}