package com.chad.baserecyclerviewadapterhelper.activity.node

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.node.section.NodeSectionAdapter
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity
import com.chad.baserecyclerviewadapterhelper.entity.node.section.ItemNode
import com.chad.baserecyclerviewadapterhelper.entity.node.section.RootNode
import com.chad.library.adapter.base.entity.node.BaseNode

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
class NodeSectionUseActivity : BaseActivity() {
    private lateinit var mRecyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_node_section)
        setBackBtn()
        setTitle("Node Use (Section)")
        mRecyclerView = findViewById(R.id.rv_list)
        mRecyclerView.setLayoutManager(GridLayoutManager(this, 3))
        //        mRecyclerView.addItemDecoration(new GridSectionAverageGapItemDecoration(10, 10, 20, 15));
        val nodeAdapter = NodeSectionAdapter()

        // 顶部header
        val view = layoutInflater.inflate(R.layout.head_view, mRecyclerView, false)
        view.findViewById<View>(R.id.iv).visibility =
            View.GONE
        nodeAdapter.addHeaderView(view)
        mRecyclerView.setAdapter(nodeAdapter)
        nodeAdapter.setList(entity)
        mRecyclerView.scheduleLayoutAnimation()
    }

    private val entity: MutableList<BaseNode>
        get() {
            val list: MutableList<BaseNode> = ArrayList()
            for (i in 0..7) {

                //Item Node
                val itemEntity1 = ItemNode(R.mipmap.click_head_img_0, "Root $i - SecondNode 0")
                val itemEntity2 = ItemNode(R.mipmap.click_head_img_0, "Root $i - SecondNode 1")
                val itemEntity3 = ItemNode(R.mipmap.click_head_img_0, "Root $i - SecondNode 2")
                val itemEntity4 = ItemNode(R.mipmap.click_head_img_0, "Root $i - SecondNode 3")
                val itemEntity5 = ItemNode(R.mipmap.click_head_img_0, "Root $i - SecondNode 4")
                val items: MutableList<BaseNode> = ArrayList()
                items.add(itemEntity1)
                items.add(itemEntity2)
                items.add(itemEntity3)
                items.add(itemEntity4)
                items.add(itemEntity5)

                // Root Node
                val entity = RootNode(items, "Root Node $i")
                if (i == 1) {
                    // 第1号数据默认不展开
                    entity.isExpanded = false
                }
                list.add(entity)
            }
            return list
        }
}
