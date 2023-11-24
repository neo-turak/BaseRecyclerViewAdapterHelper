package com.chad.baserecyclerviewadapterhelper.entity

/**
 * https://github.com/CymChad/BaseRecyclerViewAdapterHelper
 */
class Video {
    var img: String
    var name: String
    var id = 0
        private set

    constructor(img: String, name: String) {
        this.img = img
        this.name = name
    }

    constructor(id: Int, img: String, name: String) {
        this.id = id
        this.img = img
        this.name = name
    }
}
