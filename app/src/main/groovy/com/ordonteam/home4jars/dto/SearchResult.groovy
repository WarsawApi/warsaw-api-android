package com.ordonteam.home4jars.dto

import groovy.transform.CompileStatic

@CompileStatic
class SearchResult {
    String id
    String latitude
    String longitude
    String address
    String url
    Distances distances

    String getMarkerString() {
        return 'markers=' +
                'color:blue%7C' +
                "label:${address.charAt(0)}%7C" +
                "${latitude},${longitude}"
    }

    String getCenterString() {
        return "center=${latitude},${longitude}"
    }
}
