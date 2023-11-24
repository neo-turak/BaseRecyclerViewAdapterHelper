package com.chad.baserecyclerviewadapterhelper.entity.node.section

import com.chad.library.adapter.base.entity.node.BaseNode

class RootFooterNode(val title: String) : BaseNode() {

    override val childNode: MutableList<BaseNode>?
        get() = null
}
