package com.chad.baserecyclerviewadapterhelper.adapter

import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.entity.HomeEntity
import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
class HomeAdapter(mItems: MutableList<HomeEntity>) :
        BaseSectionQuickAdapter<HomeEntity, BaseViewHolder>(R.layout.def_section_head, R.layout.home_item_view, mItems) {

    override fun convert(holder: BaseViewHolder, item: HomeEntity) {

        holder.setText(R.id.text, item.name)
        holder.setImageResource(R.id.icon, item.imageResource)
    }

    override fun convertHeader(helper: BaseViewHolder, item: HomeEntity) {
        helper.setGone(R.id.more, true)
        helper.setText(R.id.header, item.headerTitle)
    }
}