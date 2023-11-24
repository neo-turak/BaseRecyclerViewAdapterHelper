package com.chad.baserecyclerviewadapterhelper.activity.node

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.base.BaseActivity

class ChooseNodeUseTypeActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_node_use_type)
        setTitle("Node Use")
        setBackBtn()
        findViewById<View>(R.id.card_view1).setOnClickListener {
            startActivity(
                Intent(
                    this@ChooseNodeUseTypeActivity,
                    NodeSectionUseActivity::class.java
                )
            )
        }
        findViewById<View>(R.id.card_view2).setOnClickListener {
            startActivity(
                Intent(
                    this@ChooseNodeUseTypeActivity,
                    NodeTreeUseActivity::class.java
                )
            )
        }
    }
}
