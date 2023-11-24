package com.chad.baserecyclerviewadapterhelper.adapter.multi

import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.entity.DelegateMultiEntity
import com.chad.baserecyclerviewadapterhelper.entity.QuickMultipleEntity
import com.chad.library.adapter.base.BaseDelegateMultiAdapter
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class DelegateMultiAdapter : BaseDelegateMultiAdapter<DelegateMultiEntity, BaseViewHolder>() {
    init {
        // 方式一，使用匿名内部类，进行如下两步：
        // 第一步，设置代理
        setMultiTypeDelegate(object : BaseMultiTypeDelegate<DelegateMultiEntity>() {
            override fun getItemType(data: List<DelegateMultiEntity>, position: Int): Int {
                when (position % 3) {
                    0 -> return DelegateMultiEntity.TEXT
                    1 -> return DelegateMultiEntity.IMG
                    2 -> return DelegateMultiEntity.IMG_TEXT
                    else -> {}
                }
                return 0
            }
        })
        // 第二部，绑定 item 类型
        getMultiTypeDelegate()
            ?.addItemType(DelegateMultiEntity.TEXT, R.layout.item_text_view)
            ?.addItemType(DelegateMultiEntity.IMG, R.layout.item_image_view)
            ?.addItemType(DelegateMultiEntity.IMG_TEXT, R.layout.item_img_text_view)


        //******************************************************************************************
        // 方式二，实现自己的代理类：
        setMultiTypeDelegate(MyMultiTypeDelegate())
    }

    protected override fun convert(holder: BaseViewHolder, item: DelegateMultiEntity) {
        when (holder.itemViewType) {
            QuickMultipleEntity.TEXT -> holder.setText(R.id.tv, "CymChad " + holder.adapterPosition)
            QuickMultipleEntity.IMG_TEXT -> {
                when (holder.layoutPosition % 2) {
                    0 -> holder.setImageResource(R.id.iv, R.mipmap.animation_img1)
                    1 -> holder.setImageResource(R.id.iv, R.mipmap.animation_img2)
                    else -> {}
                }
                holder.setText(R.id.tv, "ChayChan " + holder.adapterPosition)
            }

            else -> {}
        }
    }

    // 方式二：实现自己的代理类
    internal class MyMultiTypeDelegate : BaseMultiTypeDelegate<DelegateMultiEntity>() {
        init {
            addItemType(DelegateMultiEntity.TEXT, R.layout.item_text_view)
            addItemType(DelegateMultiEntity.IMG, R.layout.item_image_view)
            addItemType(DelegateMultiEntity.IMG_TEXT, R.layout.item_img_text_view)
        }

        override fun getItemType(data: List<DelegateMultiEntity>, position: Int): Int {
            when (position % 3) {
                0 -> return DelegateMultiEntity.TEXT
                1 -> return DelegateMultiEntity.IMG
                2 -> return DelegateMultiEntity.IMG_TEXT
                else -> {}
            }
            return 0
        }
    }
}
