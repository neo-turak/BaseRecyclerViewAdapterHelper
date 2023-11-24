package com.chad.baserecyclerviewadapterhelper.adapter.multi

import com.chad.baserecyclerviewadapterhelper.adapter.multi.provider.ImgItemProvider
import com.chad.baserecyclerviewadapterhelper.adapter.multi.provider.TextImgItemProvider
import com.chad.baserecyclerviewadapterhelper.adapter.multi.provider.TextItemProvider
import com.chad.baserecyclerviewadapterhelper.entity.ProviderMultiEntity
import com.chad.library.adapter.base.BaseProviderMultiAdapter

/**
 * @author: limuyang
 * @date: 2019-12-04
 * @Description:
 */
class ProviderMultiAdapter : BaseProviderMultiAdapter<ProviderMultiEntity>() {
    init {
        addItemProvider(ImgItemProvider())
        addItemProvider(TextImgItemProvider())
        addItemProvider(TextItemProvider())
    }

    /**
     * 自行根据数据、位置等内容，返回 item 类型
     * @param items
     * @param position
     * @return
     */
     override fun getItemType(items: MutableList<ProviderMultiEntity>, position: Int): Int {
        when (position % 3) {
            0 -> return ProviderMultiEntity.IMG
            1 -> return ProviderMultiEntity.TEXT
            2 -> return ProviderMultiEntity.IMG_TEXT
            else -> {}
        }
        return 0
    }
}
