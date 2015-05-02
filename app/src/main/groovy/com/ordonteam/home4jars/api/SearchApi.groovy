package com.ordonteam.home4jars.api

import com.ordonteam.home4jars.dto.SearchResult;
import groovy.transform.CompileStatic
import retrofit.http.GET
import retrofit.http.Query;

@CompileStatic
interface SearchApi {

    @GET('/search')
    rx.Observable<List<SearchResult>> call(
            @Query('school') Integer school,
            @Query('metro') Integer metro
    )
}
