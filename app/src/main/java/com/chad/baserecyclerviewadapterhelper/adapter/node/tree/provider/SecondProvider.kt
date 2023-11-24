package com.chad.baserecyclerviewadapterhelper.adapter.node.tree.provider

import android.view.View
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.entity.node.tree.SecondNode
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class SecondProvider : BaseNodeProvider() {
    override val itemViewType: Int
        get() = 2
    override val layoutId: Int
        get() = R.layout.item_node_second

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val entity = item as SecondNode
        helper.setText(R.id.title, entity.title)
        if (entity.isExpanded) {
            helper.setImageResource(R.id.iv, R.mipmap.arrow_b)
        } else {
            helper.setImageResource(R.id.iv, R.mipmap.arrow_r)
        }
    }

    override fun onClick(helper: BaseViewHolder, view: View, item: BaseNode, position: Int) {
        val entity = item as SecondNode
        if (entity.isExpanded) {
            getAdapter()!!.collapse(position)
        } else {
            getAdapter()!!.expandAndCollapseOther(position)
        }
    }
}
