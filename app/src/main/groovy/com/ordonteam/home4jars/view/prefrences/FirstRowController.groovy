package com.ordonteam.home4jars.view.prefrences

import com.ordonteam.home4jars.dto.FirstRowPreferences
import com.ordonteam.home4jars.view.prefrences.item.TransportationPreferencesItemAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
final class FirstRowController {
    FirstRowPreferences firstRowPreferences

    TransportationPreferencesItemAdapter getTransportationItem() {
        return new TransportationPreferencesItemAdapter(firstRowPreferences.transportationPreferences)
    }
}