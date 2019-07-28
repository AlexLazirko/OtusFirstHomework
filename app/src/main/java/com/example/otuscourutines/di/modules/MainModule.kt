package com.example.otuscourutines.di.modules

import androidx.lifecycle.ViewModelProvider
import com.example.domains.repo.Repository
import com.example.domains.usecase.FilmsUseCase
import com.example.domains.usecase.FilmsUseCaseImpl
import com.example.otuscourutines.di.ViewModelProviderFactory
import com.example.otuscourutines.view.main.view.MainViewModel
import com.example.otuscourutines.view.mapper.Mapper
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun provideMapper(): Mapper {
        return Mapper()
    }

    @Provides
    fun provideUseCase(repository: Repository): FilmsUseCase {
        return FilmsUseCaseImpl(repository)
    }

    @Provides
    fun provideViewModel(useCase: FilmsUseCase): MainViewModel {
        return MainViewModel(useCase)
    }

    @Provides
    fun provideViewModelFactory(viewModel: MainViewModel): ViewModelProvider.Factory {
        return ViewModelProviderFactory(viewModel)
    }
}