package app.v.verbundstudium.com.verbundstudiumapp.di

import app.v.verbundstudium.com.verbundstudiumapp.interactors.BaseLoginInteractor
import app.v.verbundstudium.com.verbundstudiumapp.interactors.LoginInteractor
import dagger.Module
import dagger.Provides

@Module
class InteractorModule {
    @Provides
    fun provideLoginInteractor(interactor: BaseLoginInteractor): LoginInteractor = interactor


}