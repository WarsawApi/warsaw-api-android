package com.ordonteam.home4jars.api

import com.ordonteam.home4jars.dto.SearchResults
import com.ordonteam.home4jars.dto.filters.Filters
import com.ordonteam.home4jars.dto.preferences.Preferences
import groovy.transform.CompileStatic
import retrofit.http.Body
import retrofit.http.GET
import retrofit.http.POST
import retrofit.http.Query
import retrofit.http.QueryMap

@CompileStatic
interface SearchApi {

    @POST('/search')
    rx.Observable<SearchResults> call(@Body Map<String, String> map)
}
