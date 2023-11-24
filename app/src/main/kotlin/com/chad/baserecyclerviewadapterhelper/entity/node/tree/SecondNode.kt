package com.chad.baserecyclerviewadapterhelper.entity.node.tree

import com.chad.library.adapter.base.entity.node.BaseExpandNode
import com.chad.library.adapter.base.entity.node.BaseNode

class SecondNode(val node: MutableList<BaseNode>,
                 val title: String) :
    BaseExpandNode() {

    init {
        isExpanded = false
    }

    override val childNode: MutableList<BaseNode>?
        get() = node
}
