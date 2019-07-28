package com.example.otuscourutines.view.main.view

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domains.entity.Film
import com.example.domains.usecase.FilmsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private var filmUseCase: FilmsUseCase
) : ViewModel() {

    private var films: MutableLiveData<List<Film>> = MutableLiveData()

    init {
        viewModelScope.launch {
            try {
                films.value = filmUseCase.getFilms()
            } catch (ex: Exception) {
                throw java.lang.Exception("FILMS DIDN'T LOAD")
            }
        }
    }

    fun getData() = films
}