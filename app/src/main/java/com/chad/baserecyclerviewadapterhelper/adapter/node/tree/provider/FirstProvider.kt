package com.chad.baserecyclerviewadapterhelper.adapter.node.tree.provider

import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.ImageView
import androidx.core.view.ViewCompat
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.adapter.node.tree.NodeTreeAdapter
import com.chad.baserecyclerviewadapterhelper.entity.node.tree.FirstNode
import com.chad.library.adapter.base.entity.node.BaseNode
import com.chad.library.adapter.base.provider.BaseNodeProvider
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class FirstProvider : BaseNodeProvider() {
    override val itemViewType: Int
        get() = 1
    override val layoutId: Int
        get() = R.layout.item_node_first

    override fun convert(helper: BaseViewHolder, item: BaseNode) {
        val entity = item as FirstNode
        helper.setText(R.id.title, entity.title)
        helper.setImageResource(R.id.iv, R.mipmap.arrow_r)
        setArrowSpin(helper, item, false)
    }

    override fun convert(helper: BaseViewHolder, item: BaseNode, payloads: MutableList<Any>) {
        for (payload in payloads) {
            if (payload is Int && payload == NodeTreeAdapter.EXPAND_COLLAPSE_PAYLOAD) {
                // 增量刷新，使用动画变化箭头
                setArrowSpin(helper, item, true)
            }
        }
    }

    private fun setArrowSpin(helper: BaseViewHolder, item: BaseNode, isAnimate: Boolean) {
        val entity = item as FirstNode
        val imageView = helper.getView<ImageView>(R.id.iv)
        if (entity.isExpanded) {
            if (isAnimate) {
                ViewCompat.animate(imageView).setDuration(200)
                    .setInterpolator(DecelerateInterpolator())
                    .rotation(0f)
                    .start()
            } else {
                imageView.rotation = 0f
            }
        } else {
            if (isAnimate) {
                ViewCompat.animate(imageView).setDuration(200)
                    .setInterpolator(DecelerateInterpolator())
                    .rotation(90f)
                    .start()
            } else {
                imageView.rotation = 90f
            }
        }
    }

    override fun onClick(helper: BaseViewHolder, view: View, item: BaseNode, position: Int) {
        // 这里使用payload进行增量刷新（避免整个item刷新导致的闪烁，不自然）
        getAdapter()!!.expandOrCollapse(
            position,
            animate = true,
            notify = true,
            NodeTreeAdapter.EXPAND_COLLAPSE_PAYLOAD
        )
    }
}
