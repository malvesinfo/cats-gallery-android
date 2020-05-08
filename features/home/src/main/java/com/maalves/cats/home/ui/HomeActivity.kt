package com.maalves.cats.home.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
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

        viewModel.fetchCats().observe(this, Observer {
            when (it) {
                is Response.Loading -> {
                    progress.show()
                }

                is Response.Success -> {
                    progress.hide()
                    photoGridView.setData(
                        it.data?.map { cat ->
                            PhotoGridItem(cat.photosUrl.firstOrNull().orEmpty())
                        }.orEmpty()
                    )
                }

                is Response.Error -> {
                    progress.hide()
                }
            }
        })
    }
}