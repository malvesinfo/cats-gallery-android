package com.maalves.cats.home.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import com.maalves.cats.core.hide
import com.maalves.cats.core.show
import com.maalves.cats.domain.Response
import com.maalves.cats.home.R
import com.maalves.cats.home.viewmodel.HomeViewModel
import com.maalves.cats.home.viewmodel.HomeViewModelFactory
import com.maalves.cats.photogrid.PhotoGridItem
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private val viewModel: HomeViewModel by viewModels {
        HomeViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        loadData()
        configView()
    }

    private fun loadData() {
        viewModel.fetchCats().observe(this, Observer {
            when (it) {
                is Response.Loading -> {
                    swipeRefreshLayout?.isRefreshing = true
                    textError.hide()
                }

                is Response.Success -> {
                    swipeRefreshLayout?.isRefreshing = false
                    photoGridView.setData(
                        it.data?.map { cat ->
                            PhotoGridItem(cat.photosUrl.firstOrNull().orEmpty())
                        }.orEmpty()
                    )
                }

                is Response.Error -> {
                    swipeRefreshLayout?.isRefreshing = false
                    textError.show()
                }
            }
        })
    }

    private fun configView() {
        val color = ContextCompat.getColor(this, R.color.colorPrimary)
        swipeRefreshLayout.setColorSchemeColors(color, color, color)
        swipeRefreshLayout.setOnRefreshListener {
            loadData()
        }
    }

}