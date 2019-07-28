package com.example.otuscourutines.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.domains.repo.Repository
import com.example.domains.usecase.FilmDetailUseCase
import com.example.domains.usecase.FilmDetailUseCaseImpl
import com.example.otuscourutines.di.ViewModelProviderFactory
import com.example.otuscourutines.view.film_detail.FilmDetailViewModel
import dagger.Module
import dagger.Provides

@Module
class FilmDetailModule {

    @Provides
    fun provideUseCase(repository: Repository): FilmDetailUseCase {
        return FilmDetailUseCaseImpl(repository)
    }

    @Provides
    fun provideViewModel(useCase: FilmDetailUseCase): FilmDetailViewModel {
        return FilmDetailViewModel(useCase)
    }

    @Provides
    fun provideViewModelFactory(viewModel: FilmDetailViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(viewModel)
    }
}