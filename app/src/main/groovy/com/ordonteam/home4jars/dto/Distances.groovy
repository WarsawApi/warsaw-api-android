package com.ordonteam.home4jars.dto

import android.os.Parcel
import android.os.Parcelable
import groovy.transform.CompileStatic

@CompileStatic
final class Distances implements Parcelable {
    String metro
    String school

    @Override
    int describeContents() {
        return 0
    }

    @Override
    void writeToParcel(Parcel dest, int flags) {
        dest.writeString(metro)
        dest.writeString(school)
    }

    public static final Parcelable.Creator<Distances> CREATOR = new CreatorImpl()

    static final class CreatorImpl implements Parcelable.Creator<Distances> {

        @Override
        Distances createFromParcel(Parcel source) {
            return new Distances(
                    metro: source.readString(),
                    school: source.readString(),
            )
        }

        @Override
        Distances[] newArray(int size) {
            return new Distances[size]
        }
    }
}