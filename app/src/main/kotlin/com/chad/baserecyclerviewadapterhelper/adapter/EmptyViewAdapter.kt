package com.chad.baserecyclerviewadapterhelper.adapter

import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.entity.Status
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class EmptyViewAdapter : BaseQuickAdapter<Status, BaseViewHolder>(R.layout.layout_animation) {
    protected override fun convert(holder: BaseViewHolder, item: Status) {
        when (holder.layoutPosition % 3) {
            0 -> holder.setImageResource(R.id.img, R.mipmap.animation_img1)
            1 -> holder.setImageResource(R.id.img, R.mipmap.animation_img2)
            2 -> holder.setImageResource(R.id.img, R.mipmap.animation_img3)
            else -> {}
        }
        holder.setText(R.id.tweetName, "Hoteis in Rio de Janeiro")
        holder.setText(R.id.tweetText, "O ever youthful,O ever weeping")
    }
}
