package com.ilovefish.caviarapp

import android.app.Application
import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import com.ilovefish.caviarmvvm.base.BaseApp


// 用于初始化 Glide
@GlideModule
open class MyAppGlideModule : AppGlideModule() {
    override fun applyOptions(context: Context, builder: GlideBuilder) {
//            GlideBuilder 就是 Glide 的构建器，它包含了下面这些数据。
//            线程池
//            图片来源线程池 sourceExecutor
//            磁盘缓存线程池 diskCacheExecutor
//            动画线程池 animationExecutor
//            内存大小计算器 memorySizeCalculator
//            网络状态监听器工厂 connectivityMonitorFactory
//            请求选项工厂 defaultRequestOptionsFactory
//            请求管理器工厂 requestManagerFactory
//            请求监听器列表 defaultRequestListeners
//            位图池 bitmapPool
//            数组池 arrayPool
//            内存缓存 MemoryCache
//            磁盘缓存工厂 diskCacheFactory
//            引擎 Engine
        super.applyOptions(context, builder)
    }

    // 比如获取网络图片默认用的是 HttpUrlFetcher ，HttpUrlFetcher 是用的 HttpURLConnection 来获取图片数据的，我们可以在 registerComponents() 方法中，把 HttpUrlFetcher 替换为 OkHttp 。
    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
//            Glide 有一个登记处 Registry ，它包含了下面这些 Registry 。
//            数据加载器登记处 ModelLoaderRegistry
//            编码器登记处 EncoderRegistry
//            资源解码器登记处 ResourceDecoderRegistry
//            资源编码器登记处 ResourceEncoderRegistry
//            数据重绕器登记处 DataRewinderRegistry
//            转码器登记处 DataRewinderRegistry
//            图片头部信息解析器登记处 ImageHeaderRegistry
        super.registerComponents(context, glide, registry)
    }

    override fun isManifestParsingEnabled(): Boolean {
        return super.isManifestParsingEnabled()
    }
}

class MainApplication : BaseApp() {

    override fun onCreate() {
        super.onCreate()
    }


    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)

//        TRIM_MEMORY_UI_HIDDEN：App 的所有 UI 界面被隐藏，最常见的就是 App 被 home 键或者 back 键，置换到后台了。
//        TRIM_MEMORY_RUNNING_MODERATE：表示 App 正常运行，并且不会被杀掉，但是目前手机内存已经有点低了，系统可能会根据 LRU List 来开始杀进程。
//        TRIM_MEMORY_RUNNING_LOW：表示 App正常运行，并且不会被杀掉。但是目前手机内存已经非常低了。
//        TRIM_MEMORY_RUNNING_CRITICAL：表示 App 正在正常运行，但是系统已经开始根据 LRU List 的缓存规则杀掉了一部分缓存的进程。这个时候应该尽可能的释放掉不需要的内存资源，
//        否者系统可能会继续杀掉其他缓存中的进程。
//        TRIM_MEMORY_BACKGROUND：表示 App 退出到后台，并且已经处于 LRU List 比较靠后的位置，暂时前面还有一些其他的 App 进程，暂时不用担心被杀掉。
//        TRIM_MENORY_MODERATE：表示 App 退出到后台，并且已经处于 LRU List 中间的位置，如果手机内存仍然不够的话，还是有被杀掉的风险的。
//        TRIM_MEMORY_COMPLETE：表示 App 退出到后台，并且已经处于 LRU List 比较考靠前的位置，并且手机内存已经极低，随时都有可能被系统杀掉。
//        其实从 level 值的取名来看，大致可以分为三类：
//        UI 置于后台：TRIM_MEMORY_UI_HIDDEN 。
//        App 正在前台运行时候的状态：TRIM_MEMORY_RUNNING_Xxx
//        App 被置于后台，在 Cached 状态下的回调：TRIM_MEMORY_Xxx
//        这三类中，通常我们只需要关心 App 被置于 Cached 状态下的情况，因为系统是不会杀掉一个正在前台运行的 App 的（但可能会触发 OOM），
//        但是如果该 App 有一些后台服务正在运行，这个服务也是有被杀的风险的。而在 Cached 状态下的时候，当收到 TRIM_MEMORY_Xxx 的回调，
//        就需要注意了，这些只是标记了当前 App 处于 LRU List 的位置，也就是说，如果回收了靠前的App进程之后，依然达不到内存使用的要求，
//        可能会进一步去杀进程，也就是说，极端情况下，可能从 TRIM_MEMORY_BACKGROUND 到 TRIM_MEMORY_COMPLETE 是瞬间完成的事情，
//        所以我们需要慎重处理它们，尽量对这三个状态都进行判断，然后做统一的回收内存资源的处理。
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            GlideApp.get(this).clearMemory();
        }
        GlideApp.get(this).trimMemory(level);
    }

    override fun onLowMemory() {
        super.onLowMemory()
        //在低内存的情况下，可以清除glide缓存
        GlideApp.get(this).clearMemory();
    }

}