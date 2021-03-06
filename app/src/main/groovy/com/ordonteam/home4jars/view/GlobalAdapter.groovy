package com.ordonteam.home4jars.view

import com.ordonteam.home4jars.dto.filters.Filters
import com.ordonteam.home4jars.dto.preferences.Preferences
import com.ordonteam.home4jars.view.common.BaseRecyclerViewAdapter
import com.ordonteam.home4jars.view.common.item.ItemAdapter
import com.ordonteam.home4jars.view.common.item.ItemGroup
import com.ordonteam.home4jars.view.filters.item.FilterMeasurementItem
import com.ordonteam.home4jars.view.filters.item.FilterPriceItem
import com.ordonteam.home4jars.view.filters.item.FilterRoomsItem
import com.ordonteam.home4jars.view.filters.item.FiltersHeaderItem
import com.ordonteam.home4jars.view.prefrences.item.PreferencesHeaderItem
import com.ordonteam.home4jars.view.prefrences.item.first.FirstRowPreferencesItemAdapter
import com.ordonteam.home4jars.view.prefrences.item.second.SecondRowPreferencesItemAdapter
import com.ordonteam.home4jars.view.results.item.ResultsHeaderItem
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
final class GlobalAdapter extends BaseRecyclerViewAdapter {

    Preferences preferences
    Filters filters

    GlobalAdapter(Preferences preferences, Filters filters) {
        this.preferences = preferences
        this.filters = filters
        items.add(new PreferencesHeaderItem(this))
        items.add(new FirstRowPreferencesItemAdapter(this))
        items.add(new SecondRowPreferencesItemAdapter(this))
        items.add(new FiltersHeaderItem(this))
        items.add(new FilterPriceItem(this))
        items.add(new FilterRoomsItem(this))
        items.add(new FilterMeasurementItem(this))
        items.add(new ResultsHeaderItem(this))
    }

    void replace(int position, ItemGroup itemGroup, ItemAdapter itemAdapter) {
        if (items[position].class == itemAdapter.class) {
            items.remove(position)
            notifyItemRemoved(position)
            return
        }
        removeGroup(itemGroup)
        items.add(position, itemAdapter)
        notifyItemInserted(position)
    }

    void removeGroup(ItemGroup itemGroup) {
        for (int index = 0; index < itemCount; index++) {
            if (items[index].match(itemGroup)) {
                items.remove(index)
                notifyItemRemoved(index)
                index--
            }
        }
    }
}