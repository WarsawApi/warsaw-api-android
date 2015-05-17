package com.ordonteam.home4jars.view.prefrences.item

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.TransportationPreferences
import com.ordonteam.home4jars.view.common.InflateHelper
import com.ordonteam.home4jars.view.common.ItemAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
final class TransportationPreferencesItemAdapter implements ItemAdapter {

    TransportationPreferences transportationPreferences

    @Override
    int getViewType() {
        return 12
    }

    @Override
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = InflateHelper.inflate(parent, R.layout.prefrences_transportation_row)
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        Holder holder = viewHolder as Holder
        holder.subway.selected = transportationPreferences.subway
        holder.tramway.selected = transportationPreferences.subway
        holder.subway.selected = transportationPreferences.subway
    }

    final static class Holder extends RecyclerView.ViewHolder {

        View subway
        View tramway
        View onFoot

        Holder(View itemView) {
            super(itemView)
            subway = itemView.findViewById(R.id.subway)
            tramway = itemView.findViewById(R.id.tramway)
            onFoot = itemView.findViewById(R.id.on_foot)
        }
    }
}