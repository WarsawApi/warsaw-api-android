package com.ordonteam.home4jars.view.prefrences

import com.ordonteam.home4jars.view.common.BaseRecyclerViewAdapter
import com.ordonteam.home4jars.view.prefrences.item.FirstRowPreferencesItemAdapter
import com.ordonteam.home4jars.view.prefrences.item.SecondRowPreferencesItemAdapter
import groovy.transform.CompileStatic

@CompileStatic
final class PreferencesAdapter extends BaseRecyclerViewAdapter{
    PreferencesAdapter() {
        items.add(new FirstRowPreferencesItemAdapter())
        items.add(new SecondRowPreferencesItemAdapter())
    }
}