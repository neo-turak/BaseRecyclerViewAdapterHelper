package com.chad.baserecyclerviewadapterhelper.animator

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.View
import android.view.animation.DecelerateInterpolator
import com.chad.library.adapter.base.animation.BaseAnimation

class CustomAnimation3 : BaseAnimation {
    override fun animators(view: View): Array<Animator> {
        val alpha: Animator = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
        alpha.setDuration(450)
        val translationY: Animator =
            ObjectAnimator.ofFloat(view, "translationY", view.getRootView().height.toFloat(), 0f)
        translationY.setDuration(450)
        translationY.interpolator = DecelerateInterpolator(1.2f)
        return arrayOf(alpha, translationY)
    }
}
