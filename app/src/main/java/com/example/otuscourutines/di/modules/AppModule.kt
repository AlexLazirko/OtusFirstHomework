package com.example.otuscourutines.di.modules

import com.example.data.mapper.Mapper
import com.example.data.repo.RepositoryImpl
import com.example.domains.repo.Repository
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideMapper(): Mapper {
        return Mapper()
    }

    @Provides
    fun provideRepository(mapper: Mapper): Repository {
        return RepositoryImpl(mapper)
    }
}