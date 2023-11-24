package com.chad.baserecyclerviewadapterhelper.utils

import android.content.Context

/**
 * <pre>
 * author: Blankj
 * blog  : http://blankj.com
 * time  : 16/12/08
 * desc  : Utils初始化相关
</pre> *
 */
class Utils private constructor() {
    init {
        throw UnsupportedOperationException("u can't instantiate me...")
    }

    companion object {
        private var context: Context? = null

        /**
         * 初始化工具类
         *
         * @param context 上下文
         */
        @JvmStatic
        fun init(context: Context) {
            Companion.context = context.applicationContext
        }

        /**
         * 获取ApplicationContext
         *
         * @return ApplicationContext
         */
        fun getContext(): Context? {
            if (context != null) return context
            throw NullPointerException("u should init first")
        }
    }
}
