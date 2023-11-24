package com.chad.baserecyclerviewadapterhelper.adapter.diffUtil

import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.entity.DiffUtilDemoEntity
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * Create adapter
 */
class DiffUtilAdapter(list: MutableList<DiffUtilDemoEntity>) :
    BaseQuickAdapter<DiffUtilDemoEntity, BaseViewHolder>(
        R.layout.layout_animation, list
    ) {
     override fun convert(holder: BaseViewHolder, item: DiffUtilDemoEntity) {
        holder.setText(R.id.tweetName, item.title)
            .setText(R.id.tweetText, item.content)
            .setText(R.id.tweetDate, item.date)
    }

    /**
     * This method will only be executed when there is payload info
     *
     * 当有 payload info 时，只会执行此方法
     *
     * @param holder   A fully initialized helper.
     * @param item     The item that needs to be displayed.
     * @param payloads payload info.
     */
     override fun convert(
        holder: BaseViewHolder,
        item: DiffUtilDemoEntity,
        payloads: MutableList<Any>
    ) {
        for (p in payloads) {
            val payload = p as Int
            if (payload == ITEM_0_PAYLOAD) {
                holder.setText(R.id.tweetName, item.title)
                    .setText(R.id.tweetText, item.content)
            }
        }
    }



    companion object {
        const val ITEM_0_PAYLOAD = 901
    }
}
