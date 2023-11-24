package com.chad.baserecyclerviewadapterhelper.adapter.node.section.provider

import android.view.View
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.entity.node.section.ItemNode
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class SecondNodeProvider : BaseNodeProvider() {
    override val itemViewType: Int
        get() = 1
    override val layoutId: Int
        get() = R.layout.item_section_content

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val entity = item as ItemNode
        helper.setImageResource(R.id.iv, entity.img)
        helper.setText(R.id.tv, entity.name)
    }

    override fun onClick(helper: BaseViewHolder, view: View, item: BaseNode, position: Int) {}
}
