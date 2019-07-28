package com.example.otuscourutines.di


import com.example.otuscourutines.view.FilmsApp
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, ActivityBuilder::class])
interface AppComponent : AndroidInjector<FilmsApp> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<FilmsApp>() {}
}