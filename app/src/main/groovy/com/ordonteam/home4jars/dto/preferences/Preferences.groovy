package com.ordonteam.home4jars.dto.preferences

import com.google.gson.annotations.SerializedName
import groovy.transform.CompileStatic

@CompileStatic
final class Preferences {
    @SerializedName('nearby')
    NearbyPreferences nearbyPreferences = new NearbyPreferences()
    @SerializedName('transportation')
    TransportationPreferences transportationPreferences = new TransportationPreferences()
    @SerializedName('culture')
    CulturePreferences culturePreferences = new CulturePreferences()

    @SerializedName('entertainment')
    EntertainmentPreferences entertainmentPreferences = new EntertainmentPreferences()
    @SerializedName('sport')
    SportPreferences sportPreferences = new SportPreferences()
    @SerializedName('recreation')
    RecreationPreferences recreationPreferences = new RecreationPreferences()
}