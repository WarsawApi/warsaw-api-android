package com.ordonteam.home4jars.dto.preferences

import groovy.transform.CompileStatic

@CompileStatic
final class Preferences {
    NearbyPreferences nearbyPreferences = new NearbyPreferences()
    TransportationPreferences transportationPreferences = new TransportationPreferences()
    CulturePreferences culturePreferences = new CulturePreferences()

    EntertainmentPreferences entertainmentPreferences = new EntertainmentPreferences()
    SportPreferences sportPreferences = new SportPreferences()
    RecreationPreferences recreationPreferences = new RecreationPreferences()
}