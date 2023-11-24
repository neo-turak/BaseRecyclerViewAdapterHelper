package com.chad.baserecyclerviewadapterhelper.adapter.node.section

import com.chad.baserecyclerviewadapterhelper.adapter.node.section.provider.RootFooterNodeProvider
import com.chad.baserecyclerviewadapterhelper.adapter.node.section.provider.RootNodeProvider
import com.chad.baserecyclerviewadapterhelper.adapter.node.section.provider.SecondNodeProvider
import com.chad.baserecyclerviewadapterhelper.entity.node.section.ItemNode
import com.chad.baserecyclerviewadapterhelper.entity.node.section.RootFooterNode
import com.chad.baserecyclerviewadapterhelper.entity.node.section.RootNode
import com.chad.library.adapter.base.BaseNodeAdapter
import com.chad.library.adapter.base.entity.node.BaseNode

class NodeSectionAdapter : BaseNodeAdapter() {
    init {
        addFullSpanNodeProvider(RootNodeProvider())
        addNodeProvider(SecondNodeProvider())
        addFooterNodeProvider(RootFooterNodeProvider())
    }

     override fun getItemType(items: MutableList<BaseNode>, position: Int): Int {
        val node = items[position]
         when (node) {
             is RootNode -> {
                 return 0
             }

             is ItemNode -> {
                 return 1
             }

             is RootFooterNode -> {
                 return 2
             }

             else -> return -1
         }
     }
}
