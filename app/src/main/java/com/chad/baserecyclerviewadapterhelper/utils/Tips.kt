package com.chad.baserecyclerviewadapterhelper.utils

import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.ShapeDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast

/**
 * @author: limuyang
 * @date: 2019-11-29
 * @Description:
 */
object Tips {
    /**
     * 显示 Toast
     * @param message 提示信息
     * @param duration 显示时间长短
     */
    /**
     * 显示 Toast
     * @param message 提示信息
     */
    @JvmStatic
    @JvmOverloads
    fun show(message: String, duration: Int = Toast.LENGTH_SHORT) {
        val toast = Toast(Utils.getContext())
        toast.setDuration(duration)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.view = createTextToastView(message)
        toast.show()
    }

    /**
     * 创建自定义 Toast View
     *
     * @param message 文本消息
     * @return View
     */
    private fun createTextToastView(message: String): View {
        // 画圆角矩形背景
        val rc = dp2px(6f).toFloat()
        val shape = RoundRectShape(floatArrayOf(rc, rc, rc, rc, rc, rc, rc, rc), null, null)
        val drawable = ShapeDrawable(shape)
        drawable.paint.setColor(Color.argb(225, 240, 240, 240))
        drawable.paint.style = Paint.Style.FILL
        drawable.paint.isAntiAlias = true
        drawable.paint.flags = Paint.ANTI_ALIAS_FLAG

        // 创建View
        val layout = FrameLayout(Utils.getContext())
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layout.setLayoutParams(layoutParams)
        layout.setPadding(dp2px(16f), dp2px(12f), dp2px(16f), dp2px(12f))
        layout.background = drawable
        val textView = TextView(Utils.getContext())
        textView.setLayoutParams(
            FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
            )
        )
        textView.textSize = 15f
        textView.text = message
        textView.setLineSpacing(dp2px(4f).toFloat(), 1f)
        textView.setTextColor(Color.BLACK)
        layout.addView(textView)
        return layout
    }

    private fun dp2px(dpValue: Float): Int {
        val scale = Utils.getContext().resources.displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }
}
