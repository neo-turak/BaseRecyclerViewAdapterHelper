package com.chad.baserecyclerviewadapterhelper.adapter.node.tree

import com.chad.baserecyclerviewadapterhelper.adapter.node.tree.provider.FirstProvider
import com.chad.baserecyclerviewadapterhelper.adapter.node.tree.provider.SecondProvider
import com.chad.baserecyclerviewadapterhelper.adapter.node.tree.provider.ThirdProvider
import com.chad.baserecyclerviewadapterhelper.entity.node.tree.FirstNode
import com.chad.baserecyclerviewadapterhelper.entity.node.tree.SecondNode
import com.chad.baserecyclerviewadapterhelper.entity.node.tree.ThirdNode
import com.chad.library.adapter.base.BaseNodeAdapter
import com.chad.library.adapter.base.entity.node.BaseNode

class NodeTreeAdapter : BaseNodeAdapter() {
     override fun getItemType(items: MutableList<BaseNode>, position: Int): Int {
        val node = items[position]
         when (node) {
             is FirstNode -> {
                 return 1
             }

             is SecondNode -> {
                 return 2
             }

             is ThirdNode -> {
                 return 3
             }

             else -> return -1
         }
     }

    init {
        addNodeProvider(FirstProvider())
        addNodeProvider(SecondProvider())
        addNodeProvider(ThirdProvider())
    }

    companion object {
        const val EXPAND_COLLAPSE_PAYLOAD = 110
    }
}
