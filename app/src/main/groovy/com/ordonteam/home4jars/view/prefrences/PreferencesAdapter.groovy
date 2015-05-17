package com.ordonteam.home4jars.view.prefrences

import com.ordonteam.home4jars.dto.FirstRowPreferences
import com.ordonteam.home4jars.dto.Preferences
import com.ordonteam.home4jars.view.common.BaseRecyclerViewAdapter
import com.ordonteam.home4jars.view.common.ItemAdapter
import com.ordonteam.home4jars.view.prefrences.item.FirstRowPreferencesItemAdapter
import com.ordonteam.home4jars.view.prefrences.item.SecondRowPreferencesItemAdapter
import groovy.transform.CompileStatic

@CompileStatic
final class PreferencesAdapter extends BaseRecyclerViewAdapter {

    Preferences preferences = new Preferences()

    boolean isFirstAdditionalRowVisible = false
    boolean isSecondAdditionalRowVisible = false

    PreferencesAdapter() {
        items.add(new FirstRowPreferencesItemAdapter(this, new FirstRowController(preferences.firstRowPreferences)))
        items.add(new SecondRowPreferencesItemAdapter(this))
    }

    boolean isShownInFirstAdditionalRow(ItemAdapter itemAdapter) {
        return isFirstAdditionalRowVisible && items.get(1).viewType == itemAdapter.viewType
    }

    void showInFirstAdditionalRow(ItemAdapter itemAdapter) {
        removeFirstAdditionalRow()
        removeSecondAdditionalRow()
        isFirstAdditionalRowVisible = true
        isSecondAdditionalRowVisible = false
        items.add(1, itemAdapter)
        notifyItemInserted(1)
    }

    void hideFirstAdditionalRow() {
        removeFirstAdditionalRow()
        isFirstAdditionalRowVisible = false
    }

    void showInSecondAdditionalRow(ItemAdapter itemAdapter) {
        removeFirstAdditionalRow()
        removeSecondAdditionalRow()
        isFirstAdditionalRowVisible = false
        isSecondAdditionalRowVisible = true
        items.add(itemAdapter)
        notifyItemInserted(2)
    }

    private void removeFirstAdditionalRow() {
        if (isFirstAdditionalRowVisible) {
            items.remove(1)
            notifyItemRemoved(1)
        }
    }

    private void removeSecondAdditionalRow() {
        if (isSecondAdditionalRowVisible) {
            items.remove(2)
            notifyItemRemoved(2)
        }
    }
}