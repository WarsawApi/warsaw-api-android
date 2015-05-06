package com.ordonteam.home4jars.dto

import groovy.transform.CompileStatic

@CompileStatic
class SearchResult {
    String id
    String latitude
    String longitude
    String name
    String url

    String getMarkerString() {
        return 'markers=' +
                'color:blue%7C' +
                "label:${name.charAt(0)}%7C" +
                "${latitude},${longitude}"
    }

    String getCenterString() {
        return "center=${latitude},${longitude}"
    }
}
