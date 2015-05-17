package com.ordonteam.home4jars.view.prefrences.item.first

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.common.InflateHelper
import com.ordonteam.home4jars.view.common.ItemAdapter
import com.ordonteam.home4jars.view.prefrences.FirstRowController
import com.ordonteam.home4jars.view.prefrences.PreferencesAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
final class FirstRowPreferencesItemAdapter implements ItemAdapter {

    PreferencesAdapter preferencesAdapter
    FirstRowController firstRowController

    @Override
    int getViewType() {
        return 1
    }

    @Override
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = InflateHelper.inflate(parent, R.layout.prefrences_first_row)
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        Holder holder = viewHolder as Holder
        holder.nearby.onClickListener = this.&onNearbyClick
        holder.transportation.onClickListener = this.&onTransportationClick
    }

    void onNearbyClick(View view) {
        NearbyPreferencesItemAdapter itemAdapter = firstRowController.getNearbyItem()
        if (preferencesAdapter.isShownInFirstAdditionalRow(itemAdapter)) {
            preferencesAdapter.hideFirstAdditionalRow()
        } else {
            preferencesAdapter.showInFirstAdditionalRow(itemAdapter)
        }
    }

    void onTransportationClick(View view) {
        TransportationPreferencesItemAdapter itemAdapter = firstRowController.getTransportationItem()
        if (preferencesAdapter.isShownInFirstAdditionalRow(itemAdapter)) {
            preferencesAdapter.hideFirstAdditionalRow()
        } else {
            preferencesAdapter.showInFirstAdditionalRow(itemAdapter)
        }
    }

    final static class Holder extends RecyclerView.ViewHolder {

        View nearby
        View transportation

        Holder(View itemView) {
            super(itemView)
            nearby = itemView.findViewById(R.id.nearby)
            transportation = itemView.findViewById(R.id.preferences_transportation)
        }
    }
}