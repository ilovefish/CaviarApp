package com.ilovefish.caviarapp.designmode.component


// http://t.csdn.cn/KCydI
/**
 * 组合模式
 * 组合模式是对树形结构的处理，让调用者忽视单个对象和组合结构的差异。
 * 如，Android，View像是叶子节点、ViewGroup像是枝节点，构建视图就是一种组合模式。
 * */
abstract class Component(val name: String) {

	/**
	 * 添加部件
	 */
	abstract fun add(component: Component)

	/**
	 * 移除部件
	 */
	abstract fun remove(component: Component)

	/**
	 * 展示当前部件
	 */
	abstract fun display(depth: Int)
}

/**
 * @create on 2020/8/23 22:47
 * @description 枝节点
 * @author mrdonkey
 */
class Composite(name: String) : Component(name) {

	//孩子
	private val children = arrayListOf<Component>()

	override fun add(component: Component) {
		children.add(component)
	}

	override fun remove(component: Component) {
		children.remove(component)
	}

	override fun display(depth: Int) {
		println(Array(depth) { "-" }.joinToString(" ") + name)//输出本身
		for (child in children) {//遍历其孩子
			child.display(depth + 2)
		}
	}

}

/**
 * @create on 2020/8/23 22:47
 * @description 叶子节点
 * @author mrdonkey
 */
class Leaf(name: String) : Component(name) {
	override fun add(component: Component) {
		println("cannot add from a leaf")
	}

	override fun remove(component: Component) {
		println("cannot remove from a leaf")
	}

	override fun display(depth: Int) {
		println(Array(depth) { "-" }.joinToString(" ") + name)
	}

}
