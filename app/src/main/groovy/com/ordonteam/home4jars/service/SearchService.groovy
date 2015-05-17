package com.ordonteam.home4jars.service

import com.google.gson.Gson
import com.ordonteam.home4jars.BuildConfig
import com.ordonteam.home4jars.api.SearchApi
import com.ordonteam.home4jars.dto.SearchResult
import com.ordonteam.home4jars.dto.SearchResults
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
                .setEndpoint('https://warsaw-api-backend.herokuapp.com/')
                .setClient(new OkClient(new OkHttpClient()))
                .setConverter(new GsonConverter(new Gson()))
                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                .build()
        searchApi = adapter.create(SearchApi)
    }

    rx.Observable<SearchResults> call(SearchParams params) {
        return searchApi.call(params.school, params.metro).map(this.&take5)
    }

    SearchResults take5(SearchResults searchResults){
        searchResults.items = searchResults.items.take(5)
        return searchResults
    }
}
