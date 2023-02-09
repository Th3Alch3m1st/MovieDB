package com.neugelb.preference.di

import com.neugelb.preference.datastore.PreferenceDataStoreAPIImpl
import com.neugelb.preference.datastore.domain.IPreferenceDataStoreAPI
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created By Rafiqul Hasan
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreApiModule {

	@Binds
	@Singleton
	abstract fun providePreferenceDataStoreApi(sourceImpl: PreferenceDataStoreAPIImpl): IPreferenceDataStoreAPI
}