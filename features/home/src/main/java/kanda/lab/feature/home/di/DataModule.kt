package kanda.lab.feature.home.di


import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kanda.lab.feature.home.repository.CharacterImpl
import kanda.lab.feature.home.repository.dataSource.CharacterDataSource
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class DataModule {
    @Singleton
    @Binds
    abstract fun provideCharacter(datasource: CharacterImpl): CharacterDataSource
}