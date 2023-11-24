package com.chad.baserecyclerviewadapterhelper.adapter

import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.entity.Status
import com.chad.baserecyclerviewadapterhelper.utils.SpannableStringUtils
import com.chad.baserecyclerviewadapterhelper.utils.Tips
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder

/**
 * @author: limuyang
 * @date: 2019-12-04
 * @Description:
 */
class LoadMoreAdapter : BaseQuickAdapter<Status, BaseViewHolder>(R.layout.layout_animation),
    LoadMoreModule {
     override fun convert(holder: BaseViewHolder, item: Status) {
        when (holder.layoutPosition % 3) {
            0 -> holder.setImageResource(R.id.img, R.mipmap.animation_img1)
            1 -> holder.setImageResource(R.id.img, R.mipmap.animation_img2)
            2 -> holder.setImageResource(R.id.img, R.mipmap.animation_img3)
            else -> {}
        }
        holder.setText(R.id.tweetName, "Hoteis in Rio de Janeiro")
        val msg =
            "\"He was one of Australia's most of distinguished artistes, renowned for his portraits\""
        (holder.getView<View>(R.id.tweetText) as TextView).text =
            SpannableStringUtils.getBuilder(msg).append("landscapes and nedes")
                .setClickSpan(clickableSpan).create()
        (holder.getView<View>(R.id.tweetText) as TextView).movementMethod =
            LinkMovementMethod.getInstance()
    }

    var clickableSpan: ClickableSpan = object : ClickableSpan() {
        override fun onClick(widget: View) {
            Tips.show("事件触发了 landscapes and nedes")
        }

        override fun updateDrawState(ds: TextPaint) {
            ds.setColor(context.resources.getColor(R.color.clickspan_color))
            ds.isUnderlineText = true
        }
    }
}
