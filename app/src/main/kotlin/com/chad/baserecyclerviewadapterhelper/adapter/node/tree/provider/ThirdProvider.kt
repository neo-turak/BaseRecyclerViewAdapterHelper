package com.chad.baserecyclerviewadapterhelper.adapter.node.tree.provider

import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.entity.node.tree.ThirdNode
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class ThirdProvider : BaseNodeProvider() {
    override val itemViewType: Int
        get() = 3
    override val layoutId: Int
        get() = R.layout.item_node_third

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val entity = item as ThirdNode
        helper.setText(R.id.title, entity.title)
    }
}
