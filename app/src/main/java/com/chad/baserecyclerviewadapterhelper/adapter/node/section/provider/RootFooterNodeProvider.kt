package com.chad.baserecyclerviewadapterhelper.adapter.node.section.provider

import android.view.View
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.entity.node.section.RootFooterNode
import com.chad.baserecyclerviewadapterhelper.utils.Tips
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class RootFooterNodeProvider : BaseNodeProvider() {
    init {
        addChildClickViewIds(R.id.footerTv)
    }

    override val itemViewType: Int
        get() = 2
    override val layoutId: Int
        get() = R.layout.node_footer

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val entity = item as RootFooterNode
        helper.setText(R.id.footerTv, entity.title)
    }

    override fun onChildClick(helper: BaseViewHolder, view: View, item: BaseNode, position: Int) {
        if (view.id == R.id.footerTv) {
            Tips.show("Footer Node Click : $position")
        }
    }
}
