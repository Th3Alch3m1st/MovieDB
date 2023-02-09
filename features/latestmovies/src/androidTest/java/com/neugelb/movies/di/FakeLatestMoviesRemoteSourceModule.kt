package com.neugelb.movies.di


import com.neugelb.movies.data.remote.LatestMoviesRemoteSource
import com.neugelb.movies.fakeremotesource.FakeLatestMoviesRemoteSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import javax.inject.Singleton

/**
 * Created By Rafiqul Hasan
 */
@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [LatestMoviesRemoteSourceModule::class]
)
abstract class FakeLatestMoviesRemoteSourceModule {
    @Singleton
    @Binds
    abstract fun provideFakeLatestMoviesRemoteSource(impl: FakeLatestMoviesRemoteSourceImpl): LatestMoviesRemoteSource
}