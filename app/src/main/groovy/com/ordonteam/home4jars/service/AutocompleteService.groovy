package com.ordonteam.home4jars.service

import com.google.gson.Gson
import com.ordonteam.home4jars.BuildConfig
import com.ordonteam.home4jars.api.AutocompleteApi
import com.ordonteam.home4jars.dto.Predictions
import com.squareup.okhttp.OkHttpClient
import groovy.transform.CompileStatic
import retrofit.RestAdapter
import retrofit.client.OkClient
import retrofit.converter.GsonConverter
import rx.Observable

@CompileStatic
class AutocompleteService {
    AutocompleteApi autocompleteApi

    AutocompleteService() {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint('https://maps.googleapis.com/maps/api')
                .setClient(new OkClient(new OkHttpClient()))
                .setConverter(new GsonConverter(new Gson()))
                .setLogLevel(BuildConfig.DEBUG ? RestAdapter.LogLevel.FULL : RestAdapter.LogLevel.NONE)
                .build()
        autocompleteApi = adapter.create(AutocompleteApi)
    }

    Observable<Predictions> call(String input) {
        return autocompleteApi.call(input)
    }

}
