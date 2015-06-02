package com.ordonteam.home4jars.api

import com.ordonteam.home4jars.dto.SearchResults
import groovy.transform.CompileStatic
import retrofit.http.GET
import retrofit.http.Query

@CompileStatic
interface SearchApi {

    @GET('/search')
    rx.Observable<SearchResults> call(
            @Query('school') Integer school,
            @Query('metro') Integer metro
    )
}
