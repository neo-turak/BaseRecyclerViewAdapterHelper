package com.chad.baserecyclerviewadapterhelper.adapter

import com.chad.baserecyclerviewadapterhelper.R
import com.chad.baserecyclerviewadapterhelper.databinding.ItemMovieBinding
import com.chad.baserecyclerviewadapterhelper.entity.Movie
import com.chad.baserecyclerviewadapterhelper.entity.MoviePresenter
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder

/**
 * @author: limuyang
 * @date: 2019-12-05
 * @Description: DataBinding Adapter
 */
class DataBindingAdapter :
    BaseQuickAdapter<Movie, BaseDataBindingHolder<ItemMovieBinding>>(R.layout.item_movie) {
    private val mPresenter = MoviePresenter()
     override fun convert(holder: BaseDataBindingHolder<ItemMovieBinding>, item: Movie) {
        // 获取 Binding
        val binding = holder.dataBinding
        if (binding != null) {
            binding.setMovie(item)
            binding.setPresenter(mPresenter)
            binding.executePendingBindings()
        }
    }
}
