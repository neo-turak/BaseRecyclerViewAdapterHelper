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
 * @description: Text Img ItemProvider
 * @date 2018/3/30  11:39
 */
class TextImgItemProvider : BaseItemProvider<ProviderMultiEntity>() {
    init {
        addChildClickViewIds(R.id.tv)
    }

    override val itemViewType: Int
        get() = ProviderMultiEntity.IMG_TEXT
    override val layoutId: Int
        get() = R.layout.item_img_text_view

    override fun convert(helper: BaseViewHolder, item: ProviderMultiEntity) {
        helper.setText(R.id.tv, "CymChad " + helper.adapterPosition)
        if (helper.adapterPosition % 2 == 0) {
            helper.setImageResource(R.id.iv, R.mipmap.animation_img1)
        } else {
            helper.setImageResource(R.id.iv, R.mipmap.animation_img2)
        }
    }

    /**
     * item 点击
     *
     * @param helper
     * @param item
     * @param position
     */
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

    /**
     * 子控件点击
     *
     * @param helper
     * @param view
     * @param item
     * @param position
     */
    override fun onChildClick(
        helper: BaseViewHolder,
        view: View,
        item: ProviderMultiEntity,
        position: Int
    ) {
        if (view.id == R.id.tv) {
            Tips.show("TextView Click: $position")
        }
    }
}
