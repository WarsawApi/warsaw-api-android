package com.ordonteam.home4jars.view

import com.ordonteam.home4jars.dto.preferences.Preferences
import com.ordonteam.home4jars.view.common.BaseRecyclerViewAdapter
import com.ordonteam.home4jars.view.common.ItemAdapter
import com.ordonteam.home4jars.view.common.ItemGroup
import com.ordonteam.home4jars.view.prefrences.PreferencesHeaderItem
import com.ordonteam.home4jars.view.prefrences.item.first.FirstRowPreferencesItemAdapter
import com.ordonteam.home4jars.view.prefrences.item.second.SecondRowPreferencesItemAdapter
import groovy.transform.CompileStatic

@CompileStatic
final class GlobalAdapter extends BaseRecyclerViewAdapter {

    final Preferences preferences = new Preferences()

    GlobalAdapter() {
        items.add(new PreferencesHeaderItem())
        items.add(new FirstRowPreferencesItemAdapter(this))
        items.add(new SecondRowPreferencesItemAdapter(this))
    }

    void addItem(int position, ItemAdapter itemAdapter) {
        items.add(position, itemAdapter)
        notifyItemInserted(position)
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

    private void removeGroup(ItemGroup itemGroup) {
        for (int index = 0; index < itemCount; index++) {
            if (items[index].match(itemGroup)) {
                items.remove(index)
                notifyItemRemoved(index)
            }
        }
    }
}