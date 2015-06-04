package com.ordonteam.home4jars.view.prefrences

import com.ordonteam.home4jars.dto.preferences.Preferences
import com.ordonteam.home4jars.view.prefrences.item.first.NearbyPreferencesItemAdapter
import com.ordonteam.home4jars.view.prefrences.item.first.TransportationPreferencesItemAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
final class FirstRowController {
    Preferences preferences

    TransportationPreferencesItemAdapter getTransportationItem() {
        return new TransportationPreferencesItemAdapter(preferences.transportationPreferences)
    }

    NearbyPreferencesItemAdapter getNearbyItem() {
        return new NearbyPreferencesItemAdapter(preferences.nearbyPreferences)
    }
}