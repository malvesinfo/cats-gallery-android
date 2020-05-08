package com.maalves.cats.photogrid.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SimpleGridDecoration(
    private val horizontalSpace: Int,
    private val verticalSpace: Int
) : RecyclerView.ItemDecoration() {


    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val layoutParams = view.layoutParams as GridLayoutManager.LayoutParams

        val position = layoutParams.viewPosition
        if (position == RecyclerView.NO_POSITION) {
            outRect.set(0, 0, 0, 0)
            return
        }

        val itemSpanIndex = layoutParams.spanIndex
        outRect.left = horizontalSpace / 2
        outRect.top = if (itemSpanIndex == position) 0 else verticalSpace / 2
        outRect.right = horizontalSpace / 2
        outRect.bottom = verticalSpace / 2
    }
}