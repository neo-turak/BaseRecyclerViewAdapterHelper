package com.chad.baserecyclerviewadapterhelper.adapter

import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.entity.Movie
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.UpFetchModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * @author: limuyang
 * @date: 2019-12-06
 * @Description:
 */
class UpFetchAdapter : BaseQuickAdapter<Movie, BaseViewHolder>(R.layout.item_header_and_footer),
    UpFetchModule {
    protected override fun convert(holder: BaseViewHolder, item: Movie) {
        when (holder.layoutPosition %
                3) {
            0 -> holder.setImageResource(R.id.iv, R.mipmap.animation_img1)
            1 -> holder.setImageResource(R.id.iv, R.mipmap.animation_img2)
            2 -> holder.setImageResource(R.id.iv, R.mipmap.animation_img3)
            else -> {}
        }
    }
}
