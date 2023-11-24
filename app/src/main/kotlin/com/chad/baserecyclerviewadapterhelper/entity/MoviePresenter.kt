package com.chad.baserecyclerviewadapterhelper.entity

import android.view.View
import com.chad.baserecyclerviewadapterhelper.utils.Tips.show

/**
 * Created by luoxiongwen on 16/10/24.
 */
class MoviePresenter {
    fun buyTicket(view: View?, movie: Movie) {
        show("buy ticket: " + movie.name)
    }
}
