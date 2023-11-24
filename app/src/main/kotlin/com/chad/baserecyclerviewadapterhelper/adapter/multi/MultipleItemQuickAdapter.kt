package com.chad.baserecyclerviewadapterhelper.adapter.multi

import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.entity.QuickMultipleEntity
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 * modify by AllenCoder
 */
class MultipleItemQuickAdapter(mData: MutableList<QuickMultipleEntity>) :
    BaseMultiItemQuickAdapter<QuickMultipleEntity, BaseViewHolder>(mData) {
    init {
        addItemType(QuickMultipleEntity.TEXT, R.layout.item_text_view)
        addItemType(QuickMultipleEntity.IMG, R.layout.item_image_view)
        addItemType(QuickMultipleEntity.IMG_TEXT, R.layout.item_img_text_view)
    }

     override fun convert(holder: BaseViewHolder, item: QuickMultipleEntity) {
        when (holder.itemViewType) {
            QuickMultipleEntity.TEXT -> holder.setText(R.id.tv, item.content)
            QuickMultipleEntity.IMG_TEXT -> when (holder.layoutPosition % 2) {
                0 -> holder.setImageResource(
                    R.id.iv, R.mipmap.animation_img1
                )

                1 -> holder.setImageResource(R.id.iv, R.mipmap.animation_img2)
                else -> {}
            }

            else -> {}
        }
    }
}
