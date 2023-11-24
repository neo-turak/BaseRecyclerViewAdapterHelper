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
 * @description: Img ItemProvider
 * @date 2018/3/30  11:39
 */
class ImgItemProvider : BaseItemProvider<ProviderMultiEntity>() {
    override val itemViewType: Int
        get() = ProviderMultiEntity.IMG
    override val layoutId: Int
        get() = R.layout.item_image_view

    override fun convert(helper: BaseViewHolder, item: ProviderMultiEntity) {
        if (helper.adapterPosition % 2 == 0) {
            helper.setImageResource(R.id.iv, R.mipmap.animation_img1)
        } else {
            helper.setImageResource(R.id.iv, R.mipmap.animation_img2)
        }
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
