package com.chad.baserecyclerviewadapterhelper.entity.node.tree

import com.chad.library.adapter.base.entity.node.BaseNode

class ThirdNode(val title: String) : BaseNode() {

    override val childNode: MutableList<BaseNode>?
        get() = null
}
