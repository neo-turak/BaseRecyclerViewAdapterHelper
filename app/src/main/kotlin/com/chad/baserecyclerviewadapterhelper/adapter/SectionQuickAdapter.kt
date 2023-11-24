package com.chad.baserecyclerviewadapterhelper.adapter

import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.entity.MySection
import com.chad.baserecyclerviewadapterhelper.entity.Video
import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 *
 * @param sectionHeadResId The section head layout id for each item
 * @param layoutResId      The layout resource id of each item.
 * @param mItems             A new list is created out of this one to avoid mutable list
 *
 * Same as QuickAdapter#QuickAdapter(Context,int) but with
 * some initialization data.
 *
 */
class SectionQuickAdapter(layoutResId: Int, sectionHeadResId: Int, mItems: MutableList<MySection>) :
    BaseSectionQuickAdapter<MySection, BaseViewHolder>(sectionHeadResId, mItems) {
    /**

     *
     */
    init {
        setNormalLayout(layoutResId)
        addChildClickViewIds(R.id.more)
    }

    override fun convertHeader(helper: BaseViewHolder, item: MySection) {
        if (item.obj is String) {
            helper.setText(R.id.header, item.obj as String)
        }
    }

    override fun convert(holder: BaseViewHolder, item: MySection) {
        val video = item.obj as Video
        when (holder.layoutPosition % 2) {
            0 -> holder.setImageResource(R.id.iv, R.mipmap.m_img1)
            1 -> holder.setImageResource(R.id.iv, R.mipmap.m_img2)
            else -> {}
        }
        holder.setText(R.id.tv, video.name)
    }
}
