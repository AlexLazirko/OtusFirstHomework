package com.example.otuscourutines.view.film_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domains.entity.FilmDetail
import com.example.domains.usecase.FilmDetailUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class FilmDetailViewModel @Inject constructor(
    var filmDetailUseCase: FilmDetailUseCase
) : ViewModel() {

    private var filmDetail: MutableLiveData<FilmDetail> = MutableLiveData()

    fun getData(id: String): LiveData<FilmDetail> {
        if (filmDetail.value == null) {
            viewModelScope.launch {
                try {
                    filmDetail.value = filmDetailUseCase.getFilmDetail(id)
                } catch (ex: Exception) {
                    throw Exception("FILM DETAIL DIDN'T LOAD")
                }
            }
        }
        return filmDetail
    }
}