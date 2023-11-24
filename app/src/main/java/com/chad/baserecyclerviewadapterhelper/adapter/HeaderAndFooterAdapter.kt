package com.chad.baserecyclerviewadapterhelper.adapter

import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.model.DataServer
import com.chad.baserecyclerviewadapterhelper.entity.Status
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
class HeaderAndFooterAdapter(dataSize: Int) : BaseQuickAdapter<Status, BaseViewHolder>(
    R.layout.item_header_and_footer,
    DataServer.getSampleData(dataSize)
) {
    protected override fun convert(holder: BaseViewHolder, item: Status) {
        when (holder.layoutPosition %
                3) {
            0 -> holder.setImageResource(R.id.iv, R.mipmap.animation_img1)
            1 -> holder.setImageResource(R.id.iv, R.mipmap.animation_img2)
            2 -> holder.setImageResource(R.id.iv, R.mipmap.animation_img3)
            else -> {}
        }
    }
}
