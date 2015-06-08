package com.ordonteam.home4jars.dto

import com.google.gson.annotations.SerializedName
import com.ordonteam.home4jars.dto.filters.Filters
import com.ordonteam.home4jars.dto.preferences.Preferences
import groovy.transform.CompileStatic

@CompileStatic
final class SearchRequest {

    @SerializedName('preferences')
    Preferences preferences

    @SerializedName('filters')
    Filters filters
}
