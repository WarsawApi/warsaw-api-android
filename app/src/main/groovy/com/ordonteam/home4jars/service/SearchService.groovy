package com.ordonteam.home4jars.service

import com.google.gson.Gson
import com.ordonteam.home4jars.BuildConfig
import com.ordonteam.home4jars.api.SearchApi
import com.ordonteam.home4jars.dto.SearchResult
import com.squareup.okhttp.OkHttpClient
import groovy.transform.CompileStatic
import retrofit.RestAdapter
import retrofit.client.OkClient
import retrofit.converter.GsonConverter

@CompileStatic
class SearchService {
    SearchApi searchApi

    SearchService() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint('http://10.0.2.2:13579/')
                .setClient(new OkClient(new OkHttpClient()))
                .setConverter(new GsonConverter(new Gson()))
                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                .build()
        searchApi = adapter.create(SearchApi)
    }

    rx.Observable<List<SearchResult>> call(Integer school, Integer metro) {
        return searchApi.call(school, metro)
    }
}
