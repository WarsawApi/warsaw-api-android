package com.ordonteam.home4jars.api

import com.ordonteam.home4jars.dto.SearchResult;
import groovy.transform.CompileStatic
import retrofit.http.GET;

@CompileStatic
interface SearchApi {

    @GET('/search')
    List<SearchResult> call()
}
