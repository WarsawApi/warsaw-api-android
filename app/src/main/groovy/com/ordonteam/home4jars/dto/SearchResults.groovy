package com.ordonteam.home4jars.dto

import android.os.Parcel
import android.os.Parcelable
import groovy.transform.CompileStatic

@CompileStatic
final class SearchResults implements Parcelable {
    List<SearchResult> items

    String getMapUrl() {
        String markers = items.collect { it.markerString }.join('&')
        return "https://maps.googleapis.com/maps/api/staticmap?center=${items.first().coordsAsString}&zoom=14&size=700x300&scale=2&${markers}"
    }

    @Override
    int describeContents() {
        return 0
    }

    @Override
    void writeToParcel(Parcel dest, int flags) {
        dest.writeList(items)
    }

    public static final Parcelable.Creator<SearchResults> CREATOR = new CreatorImpl()

    static final class CreatorImpl implements Parcelable.Creator<SearchResults> {

        @Override
        SearchResults createFromParcel(Parcel source) {
            return new SearchResults(
                    items: source.readArrayList(SearchResults.classLoader) as List<SearchResult>,
            )
        }

        @Override
        SearchResults[] newArray(int size) {
            return new SearchResults[size]
        }
    }
}