package com.ordonteam.home4jars.view.prefrences.item.first

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.preferences.NearbyPreferences
import com.ordonteam.home4jars.view.common.item.ItemAdapter
import com.ordonteam.home4jars.view.common.item.ItemGroup
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import static ItemGroup.FIRST_ADDITIONAL_ROWS

@CompileStatic
@TupleConstructor
final class NearbyPreferencesItemAdapter extends ItemAdapter<Holder> {

    NearbyPreferences nearbyPreferences

    @Override
    int getViewType() {
        return R.layout.prefrences_nearby_row
    }

    @Override
    Holder onCreateViewHolder(View view) {
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(Holder viewHolder) {
    }

    @Override
    boolean match(ItemGroup itemGroup) {
        return itemGroup == FIRST_ADDITIONAL_ROWS
    }

    final static class Holder extends RecyclerView.ViewHolder {

        Holder(View itemView) {
            super(itemView)
        }
    }
}