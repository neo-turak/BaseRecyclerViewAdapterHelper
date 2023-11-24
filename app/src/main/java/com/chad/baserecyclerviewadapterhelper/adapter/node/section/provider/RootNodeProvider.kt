package com.chad.baserecyclerviewadapterhelper.adapter.node.section.provider

import android.view.View
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.entity.node.section.RootNode
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class RootNodeProvider : BaseNodeProvider() {
    override val itemViewType: Int
        get() = 0
    override val layoutId: Int
        get() = R.layout.def_section_head

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val entity = item as RootNode
        helper.setText(R.id.header, entity.title)
    }

    override fun onClick(helper: BaseViewHolder, view: View, item: BaseNode, position: Int) {
        getAdapter()!!.expandOrCollapse(position)
    }
}
