package com.chad.baserecyclerviewadapterhelper.entity

/**
 * 数据类不需要实现 [com.chad.library.adapter.base.entity.MultiItemEntity] 接口
 */
class DelegateMultiEntity {
    var name: String? = null
    var age = 0

    companion object {
        const val TEXT = 1
        const val IMG = 2
        const val IMG_TEXT = 3
    }
}
