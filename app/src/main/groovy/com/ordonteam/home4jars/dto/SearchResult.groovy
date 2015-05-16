package com.ordonteam.home4jars.dto

import android.os.Parcel
import android.os.Parcelable
import groovy.transform.CompileStatic

@CompileStatic
class SearchResult implements Parcelable{
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

    @Override
    int describeContents() {
        return 0
    }

    @Override
    void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id)
        dest.writeString(latitude)
        dest.writeString(longitude)
        dest.writeString(address)
        dest.writeString(url)
        dest.writeParcelable(distances, flags)
    }

    public static final Parcelable.Creator<SearchResult> CREATOR = new CreatorImpl()

    static final class CreatorImpl implements Parcelable.Creator<SearchResult> {

        @Override
        SearchResult createFromParcel(Parcel source) {
            return new SearchResult(
                    id: source.readString(),
                    latitude: source.readString(),
                    longitude: source.readString(),
                    address: source.readString(),
                    url: source.readString(),
                    distances: source.readParcelable(SearchResult.classLoader) as Distances
            )
        }

        @Override
        SearchResult[] newArray(int size) {
            return new SearchResult[size]
        }
    }
}
