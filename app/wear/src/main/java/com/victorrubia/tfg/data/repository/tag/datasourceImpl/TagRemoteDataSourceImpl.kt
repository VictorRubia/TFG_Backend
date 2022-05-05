package com.victorrubia.tfg.data.repository.tag.datasourceImpl

import com.victorrubia.tfg.data.api.TFGService
import com.victorrubia.tfg.data.model.tag.Tag
import com.victorrubia.tfg.data.repository.tag.datasource.TagRemoteDataSource
import com.victorrubia.tfg.data.repository.user.datasource.UserCacheDataSource
import retrofit2.Response
import java.util.Date

class TagRemoteDataSourceImpl(
    private val tfgService: TFGService,
    private val user : UserCacheDataSource
) : TagRemoteDataSource{

    override suspend fun addTag(tag: String, datetime: Date, activityId: Int): Response<Tag> =
        tfgService.addTag("Bearer ${user.getUserFromCache()!!.apiKey}", tag, datetime, activityId)
}