package com.ordonteam.home4jars.api

import com.ordonteam.home4jars.dto.SearchResults
import com.ordonteam.home4jars.dto.filters.Filters
import com.ordonteam.home4jars.dto.preferences.Preferences
import groovy.transform.CompileStatic
import retrofit.http.GET
import retrofit.http.Query

@CompileStatic
interface SearchApi {

    @GET('/search')
    rx.Observable<SearchResults> call(
            @Query('preferences') Preferences preferences,
            @Query('filters') Filters filters
    )
}
