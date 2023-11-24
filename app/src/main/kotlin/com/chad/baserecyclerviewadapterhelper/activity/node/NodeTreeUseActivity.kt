package com.chad.baserecyclerviewadapterhelper.activity.node

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.node.tree.NodeTreeAdapter
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity
import com.chad.baserecyclerviewadapterhelper.entity.node.tree.FirstNode
import com.chad.baserecyclerviewadapterhelper.entity.node.tree.SecondNode
import com.chad.baserecyclerviewadapterhelper.entity.node.tree.ThirdNode
import com.chad.baserecyclerviewadapterhelper.utils.Tips.show
import com.chad.library.adapter.base.entity.node.BaseNode

class NodeTreeUseActivity : BaseActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private val adapter = NodeTreeAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_node_tree)
        setBackBtn()
        setTitle("Node Use (Tree)")
        mRecyclerView = findViewById(R.id.rv_list)
        mRecyclerView.setLayoutManager(LinearLayoutManager(this))
        mRecyclerView.setAdapter(adapter)
        adapter.setList(entity)

        // 模拟新增node
        mRecyclerView.postDelayed(Runnable {
            val seNode = SecondNode(ArrayList(), "Second Node(This is added)")
            val seNode2 = SecondNode(ArrayList(), "Second Node(This is added)")
            val nodes: MutableList<SecondNode> = ArrayList()
            nodes.add(seNode)
            nodes.add(seNode2)
            //第一个夫node，位置为子node的3号位置
            adapter.nodeAddData(adapter.items[0], 2, nodes)
            //                adapter.nodeSetData(adapter.getData().get(0), 2, seNode2);
//                adapter.nodeReplaceChildData(adapter.getData().get(0), nodes);
            show("新插入了两个node", Toast.LENGTH_LONG)
        }, 2000)
    }

    private val entity: MutableList<BaseNode>
         get() {
            val list: MutableList<BaseNode> = ArrayList()
            for (i in 0..7) {
                val secondNodeList: MutableList<BaseNode> = ArrayList()
                for (n in 0..5) {
                    val thirdNodeList: MutableList<BaseNode> = ArrayList()
                    for (t in 0..3) {
                        val node = ThirdNode("Third Node $t")
                        thirdNodeList.add(node)
                    }
                    val seNode = SecondNode(thirdNodeList, "Second Node $n")
                    secondNodeList.add(seNode)
                }
                val entity = FirstNode(secondNodeList, "First Node $i")

                // 模拟 默认第0个是展开的
                entity.isExpanded = i == 0
                list.add(entity)
            }
            return list
        }
}
