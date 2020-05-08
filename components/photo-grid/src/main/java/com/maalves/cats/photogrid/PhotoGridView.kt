package com.maalves.cats.photogrid

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.maalves.cats.photogrid.adapter.PhotoGridAdapter
import com.maalves.cats.photogrid.decoration.SimpleGridDecoration
import kotlinx.android.synthetic.main.photo_grid_view.view.*

class PhotoGridView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private val adapter = PhotoGridAdapter()

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.photo_grid_view, this, true)
        gridRecycler.adapter = adapter
        gridRecycler.layoutManager = GridLayoutManager(context, 4)
        gridRecycler.addItemDecoration(
            SimpleGridDecoration(
                resources.getInteger(R.integer.horizontal_space),
                resources.getInteger(R.integer.vertical_space)
            )
        )
    }

    fun setData(items: List<PhotoGridItem>) {
        adapter.items = items
    }

}
