package com.chad.baserecyclerviewadapterhelper.entity

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
data class Status(
    var isRetweet: Boolean = false,
    var text: String? = null,
    var userName: String? = null,
    var userAvatar: String? = null,
    var createdAt: String? = null
)
