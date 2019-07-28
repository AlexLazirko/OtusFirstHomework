package com.example.otuscourutines.di

import com.example.otuscourutines.di.modules.AppModule
import com.example.otuscourutines.di.modules.FilmDetailModule
import com.example.otuscourutines.di.modules.MainModule
import com.example.otuscourutines.view.film_detail.FilmDetailActivity
import com.example.otuscourutines.view.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector(modules = [AppModule::class, MainModule::class])
    abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector(modules = [AppModule::class, FilmDetailModule::class])
    abstract fun conributeFilmDetailActivity(): FilmDetailActivity
}