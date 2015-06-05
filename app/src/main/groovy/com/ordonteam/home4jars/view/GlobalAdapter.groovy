package com.ordonteam.home4jars.view

import com.ordonteam.home4jars.dto.preferences.Preferences
import com.ordonteam.home4jars.view.common.BaseRecyclerViewAdapter
import com.ordonteam.home4jars.view.common.ItemAdapter
import com.ordonteam.home4jars.view.common.ItemGroup
import com.ordonteam.home4jars.view.prefrences.FirstRowController
import com.ordonteam.home4jars.view.prefrences.PreferencesAdapter
import com.ordonteam.home4jars.view.prefrences.PreferencesHeaderItem
import com.ordonteam.home4jars.view.prefrences.item.first.FirstRowPreferencesItemAdapter
import com.ordonteam.home4jars.view.prefrences.item.first.NearbyPreferencesItemAdapter
import com.ordonteam.home4jars.view.prefrences.item.second.SecondRowPreferencesItemAdapter
import groovy.transform.CompileStatic

import static com.ordonteam.home4jars.view.common.ItemGroup.FIRST_ADDITIONAL_ROWS

@CompileStatic
final class GlobalAdapter extends BaseRecyclerViewAdapter {

    final Preferences preferences = new Preferences()

    GlobalAdapter() {
        items.add(new PreferencesHeaderItem())
        items.add(new FirstRowPreferencesItemAdapter(this))

        FirstRowController firstRowController = new FirstRowController(preferences)
        PreferencesAdapter adapter = new PreferencesAdapter(firstRowController)
        items.add(new SecondRowPreferencesItemAdapter(adapter))
    }

    void addItem(int position, ItemAdapter itemAdapter) {
        items.add(position, itemAdapter)
        notifyItemInserted(position)
    }

    void replace(int position, ItemGroup itemGroup, ItemAdapter itemAdapter) {
        if(items[position].class == itemAdapter.class ){
            items.remove(position)
            notifyItemRemoved(position)
            return
        }
        if (items[position].match(FIRST_ADDITIONAL_ROWS)) {
            items.remove(position)
            notifyItemRemoved(position)
        }
        items.add(position, itemAdapter)
        notifyItemInserted(position)
    }
}