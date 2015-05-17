package com.ordonteam.home4jars.view.prefrences.item.first

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.NearbyPreferences
import com.ordonteam.home4jars.dto.TransportationPreferences
import com.ordonteam.home4jars.view.common.InflateHelper
import com.ordonteam.home4jars.view.common.ItemAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
final class NearbyPreferencesItemAdapter implements ItemAdapter {

    NearbyPreferences nearbyPreferences
    @Override
    int getViewType() {
        return 11
    }

    @Override
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = InflateHelper.inflate(parent, R.layout.prefrences_transportation_row)
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        Holder holder = viewHolder as Holder
    }

    final static class Holder extends RecyclerView.ViewHolder {

        Holder(View itemView) {
            super(itemView)
        }
    }
}