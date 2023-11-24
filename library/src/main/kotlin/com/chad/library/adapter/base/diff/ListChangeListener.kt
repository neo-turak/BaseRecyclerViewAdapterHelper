package com.chad.library.adapter.base.diff

interface ListChangeListener<T> {
    /**
     * Called after the current List has been updated.
     *
     * @param previousList The previous list.
     * @param currentList The new current list.
     */
    fun onCurrentListChanged(previousList: List<T>, currentList: List<T>)
}
