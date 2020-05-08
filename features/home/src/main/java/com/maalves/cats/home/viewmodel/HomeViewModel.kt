package com.maalves.cats.home.viewmodel

import androidx.lifecycle.ViewModel
import com.maalves.cats.domain.repository.CatsRepository

class HomeViewModel : ViewModel() {

    fun fetchCats() = CatsRepository.fetchCats()

}