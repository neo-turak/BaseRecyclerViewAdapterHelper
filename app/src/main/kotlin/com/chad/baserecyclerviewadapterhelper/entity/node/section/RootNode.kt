package com.chad.baserecyclerviewadapterhelper.entity.node.section

import com.chad.library.adapter.base.entity.node.BaseExpandNode
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.entity.node.NodeFooterImp

class RootNode(val node: MutableList<BaseNode>?,
               val title: String) :
    BaseExpandNode(), NodeFooterImp {




    override val footerNode: BaseNode
        /**
         * [NodeFooterImp]
         * （可选实现）
         * 重写此方法，获取脚部节点
         * @return
         */
        get() = RootFooterNode("显示更多...")

    /**
     * [BaseNode]
     * 重写此方法，获取子节点。如果没有子节点，返回 null 或者 空数组
     * @return child nodes
     */
    override val childNode: MutableList<BaseNode>?
        get() = node
}
