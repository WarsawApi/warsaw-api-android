package com.ordonteam.home4jars.service

import com.ordonteam.home4jars.api.SearchApi
import com.ordonteam.home4jars.dto.SearchResult
import groovy.transform.CompileStatic
import retrofit.RestAdapter

@CompileStatic
class SearchService {
    SearchApi searchApi

    SearchService() {
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint('http://localhost:13579').build()
        searchApi = adapter.create(SearchApi)
    }

    List<SearchResult> call(Integer school, Integer metro){
        return searchApi.call(school, metro)
    }
}
