package com.chad.library.adapter.base.diff

/**
 * 使用java接口定义方法
 * @param <T>
</T> */
interface DifferImp<T> {
    fun addListListener(listChangeListener: ListChangeListener<T>)
}
