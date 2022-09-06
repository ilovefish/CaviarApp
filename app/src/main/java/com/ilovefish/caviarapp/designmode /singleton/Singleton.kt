package com.ilovefish.caviarapp.designmode.singleton

// http://t.csdn.cn/PMenG
/**
 * 饿汉单例
 * kotlin中实现饿汉单例只需要在类名前面加上一个object关键字就可以了。
 * 因为kotlin中是没有静态方法的概念的，所以就没有办法创建类似java实现方式中的getInstance()这样的静态方法。
 * 但是kotlin提供了更加简洁的方式达到相同的效果，就是使用object关键字。
 * */
object Singleton {}

//    java
//    public class SingletonDemo {
//        private static SingletonDemo instance=new SingletonDemo();
//        private SingletonDemo(){
//
//        }
//        public static SingletonDemo getInstance(){
//            return instance;
//        }
//    }


/**
 * 懒汉单例
 * kotlin实现懒汉单例的关键点有两个:
 * 1 主构造器私有化
 * 2 使用自定义访问器返回对象实例
 * */
class SluggardSingletonDemo private constructor() {
    companion object {
        private var instance: SluggardSingletonDemo? = null
            //这里使用的是自定义访问器
            get() {
                if (field == null) {
                    field = SluggardSingletonDemo()
                }
                return field
            }

        fun get(): SluggardSingletonDemo{
            return instance!!
        }
    }
}

//    Java实现
//    public class SingletonDemo {
//        private static SingletonDemo instance;
//        private SingletonDemo(){}
//        public static SingletonDemo getInstance(){
//            if(instance==null){
//                instance=new SingletonDemo();
//            }
//            return instance;
//        }
//    }


/**
 * 线程安全懒汉模式
 * 内容基本与懒汉模式相同，唯一的区别就是Java使用为方法添加同步锁的方式实现，
 * kotlin需要在方法中添加@Synchronized注解。
 * */
class ThreadSafetySluggardSingletonDemo private constructor() {
    companion object {
        private var instance: ThreadSafetySluggardSingletonDemo? = null
            get() {
                if (field == null) {
                    field = ThreadSafetySluggardSingletonDemo()
                }
                return field
            }
        //使用同步锁注解
        @Synchronized
        fun get(): ThreadSafetySluggardSingletonDemo{
            return instance!!
        }
    }

}
//    Java实现
//    public class SingletonDemo {
//        private static SingletonDemo instance;
//        private SingletonDemo(){}
//        //为方法添加同步锁
//        public static synchronized SingletonDemo getInstance(){
//            if(instance==null){
//                instance=new SingletonDemo();
//            }
//            return instance;
//        }
//    }


/**
 * 双重校验锁模式
 * Java中的双重校验锁模式就是在同步锁模式的基础上稍作改动，添加了双重判断，并且将同步锁的作用域进一步缩小到了方法内部进行第二重判断之前。
 * 而kotlin中双重校验锁的实现更加简单，直接使用lazy结合属性委托的方式实现。
 * */
class LazyThreadSafetySingletonDemo private constructor() {
    companion object {
        val instance: LazyThreadSafetySingletonDemo by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            LazyThreadSafetySingletonDemo()
        }
    }
}

//    Java实现
//    public class SingletonDemo {
//        private volatile static SingletonDemo instance;
//        private SingletonDemo(){}
//        public static SingletonDemo getInstance(){
//            if(instance==null){
//                synchronized (SingletonDemo.class){
//                    if(instance==null){
//                        instance=new SingletonDemo();
//                    }
//                }
//            }
//            return instance;
//        }
//    }

/**
 * 静态内部类模式
 * */
class StaticSingletonDemo private constructor() {
    companion object {
        val instance = StaticSingletonDemoHolder.holder
    }

    private object StaticSingletonDemoHolder {
        val holder= StaticSingletonDemo()

    }
}

//    Java实现
//    public class SingletonDemo {
//        private static class SingletonHolder{
//            private static SingletonDemo instance=new SingletonDemo();
//        }
//        private SingletonDemo(){
//            System.out.println("this is a singleton model");
//        }
//        public static SingletonDemo getInstance(){
//            return SingletonHolder.instance;
//        }
//    }