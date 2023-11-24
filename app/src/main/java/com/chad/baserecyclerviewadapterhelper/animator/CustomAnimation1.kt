package com.chad.baserecyclerviewadapterhelper.animator

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.DecelerateInterpolator
import com.chad.library.adapter.base.animation.BaseAnimation

/**
 * 自定义动画1
 */
class CustomAnimation1 : BaseAnimation {
    override fun animators(view: View): Array<Animator> {
        val scaleY: Animator = ObjectAnimator.ofFloat(view, "scaleY", 1.3f, 1f)
        val scaleX: Animator = ObjectAnimator.ofFloat(view, "scaleX", 1.3f, 1f)
        val alpha: Animator = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
        scaleY.setDuration(350)
        scaleX.setDuration(350)
        alpha.setDuration(350)
        scaleY.interpolator = DecelerateInterpolator()
        scaleX.interpolator = DecelerateInterpolator()
        return arrayOf(scaleY, scaleX, alpha)
    }
}