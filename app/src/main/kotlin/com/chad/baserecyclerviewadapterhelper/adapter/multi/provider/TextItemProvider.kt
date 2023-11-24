package com.chad.baserecyclerviewadapterhelper.adapter.multi.provider

import android.view.View
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.entity.ProviderMultiEntity
import com.chad.baserecyclerviewadapterhelper.utils.Tips
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * https://github.com/chaychan
 *
 * @author ChayChan
 * @description: Text ItemProvider
 * @date 2018/3/30  11:39
 */
class TextItemProvider : BaseItemProvider<ProviderMultiEntity>() {
    override val itemViewType: Int
        get() = ProviderMultiEntity.TEXT
    override val layoutId: Int
        get() = R.layout.item_text_view

    override fun convert(helper: BaseViewHolder, item: ProviderMultiEntity) {
        helper.setText(R.id.tv, "CymChad content : " + helper.adapterPosition)
    }

    override fun onClick(
        helper: BaseViewHolder,
        view: View,
        item: ProviderMultiEntity,
        position: Int
    ) {
        Tips.show("Click: $position")
    }

    override fun onLongClick(
        helper: BaseViewHolder,
        view: View,
        item: ProviderMultiEntity,
        position: Int
    ): Boolean {
        Tips.show("Long Click: $position")
        return true
    }
}
