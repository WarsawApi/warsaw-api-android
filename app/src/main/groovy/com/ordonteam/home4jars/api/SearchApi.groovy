package com.ordonteam.home4jars.api

import com.ordonteam.home4jars.dto.SearchResults
import groovy.transform.CompileStatic
import retrofit.http.Body
import retrofit.http.POST

@CompileStatic
interface SearchApi {

    @POST('/search')
    rx.Observable<SearchResults> call(@Body SearchRequest)
}
