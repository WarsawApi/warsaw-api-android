package com.ordonteam.home4jars.view.prefrences

import com.ordonteam.home4jars.view.common.BaseRecyclerViewAdapter
import com.ordonteam.home4jars.common.Bus
import com.ordonteam.home4jars.view.common.ItemAdapter
import com.ordonteam.home4jars.view.prefrences.item.FirstRowPreferencesItemAdapter
import com.ordonteam.home4jars.view.prefrences.item.SecondRowPreferencesItemAdapter
import com.ordonteam.home4jars.view.prefrences.item.TransportationPreferencesItemAdapter
import groovy.transform.CompileStatic

@CompileStatic
final class PreferencesAdapter extends BaseRecyclerViewAdapter {

    boolean isFirstAditionalRowVisible = false

    PreferencesAdapter() {
        items.add(new FirstRowPreferencesItemAdapter())
        items.add(new SecondRowPreferencesItemAdapter())
    }

    void show(ItemAdapter itemAdapter) {
        if (isFirstAditionalRowVisible) {
            items.remove(1)
            notifyItemRemoved(1)
        }
        isFirstAditionalRowVisible = true
        items.add(1, itemAdapter)
        notifyItemInserted(1)
    }
}