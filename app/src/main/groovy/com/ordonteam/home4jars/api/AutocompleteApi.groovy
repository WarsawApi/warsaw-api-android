package com.ordonteam.home4jars.api

import com.ordonteam.home4jars.dto.Predictions
import groovy.transform.CompileStatic
import retrofit.http.GET
import retrofit.http.Query
import rx.Observable

@CompileStatic
interface AutocompleteApi {

    @GET('/place/autocomplete/json?location=52.23166339,21&key=AIzaSyDJzgzQoraNLXFuGhG6a4CRGtSFCUvJy_U')//&types=address
    Observable<Predictions> call(@Query('input') String input)
}