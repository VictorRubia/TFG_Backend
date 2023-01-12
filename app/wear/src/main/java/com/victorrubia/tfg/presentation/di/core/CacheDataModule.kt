package com.victorrubia.tfg.presentation.di.core

import com.victorrubia.tfg.data.repository.activity.datasource.ActivityCacheDataSource
import com.victorrubia.tfg.data.repository.activity.datasourceImpl.ActivityCacheDataSourceImpl
import com.victorrubia.tfg.data.repository.ppg_measure.datasource.PPGMeasureCacheDataSource
import com.victorrubia.tfg.data.repository.ppg_measure.datasourceImpl.PPGMeasureCacheDataSourceImpl
import com.victorrubia.tfg.data.repository.tag.datasource.TagCacheDataSource
import com.victorrubia.tfg.data.repository.tag.datasourceImpl.TagCacheDataSourceImpl
import com.victorrubia.tfg.data.repository.user.datasource.UserCacheDataSource
import com.victorrubia.tfg.data.repository.user.datasourceImpl.UserCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Dagger module that provides the cache data sources.
 */
@Module
class CacheDataModule {

    /**
     * Provides the [ActivityCacheDataSource].
     * Singleton annotation is used to make sure that there is only one instance of the data source.
     *
     * @param ActivityCacheDataSourceImpl the implementation of the [ActivityCacheDataSource]
     * @return the [ActivityCacheDataSource]
     */
    @Singleton
    @Provides
    fun provideActivityCacheDataSource() : ActivityCacheDataSource{
        return ActivityCacheDataSourceImpl()
    }

    /**
     * Provides the [UserCacheDataSource].
     * Singleton annotation is used to make sure that there is only one instance of the data source.
     *
     * @param UserCacheDataSourceImpl the implementation of the [UserCacheDataSource]
     * @return the [UserCacheDataSource]
     */
    @Singleton
    @Provides
    fun provideUserCacheDataSource() : UserCacheDataSource {
        return UserCacheDataSourceImpl()
    }

    /**
     * Provides the [PPGMeasureCacheDataSource].
     * Singleton annotation is used to make sure that there is only one instance of the data source.
     *
     * @param PPGMeasureCacheDataSourceImpl the implementation of the [PPGMeasureCacheDataSource]
     * @return the [PPGMeasureCacheDataSource]
     */
    @Singleton
    @Provides
    fun providePPGMeasureCacheDataSource() : PPGMeasureCacheDataSource {
        return PPGMeasureCacheDataSourceImpl()
    }

    /**
     * Provides the [TagCacheDataSource].
     * Singleton annotation is used to make sure that there is only one instance of the data source.
     *
     * @param TagCacheDataSourceImpl the implementation of the [TagCacheDataSource]
     * @return the [TagCacheDataSource]
     */
    @Singleton
    @Provides
    fun provideTagCacheDataSource() : TagCacheDataSource {
        return TagCacheDataSourceImpl()
    }
}