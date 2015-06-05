package com.ordonteam.home4jars.view.prefrences.item.first

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.preferences.TransportationPreferences
import com.ordonteam.home4jars.view.GlobalAdapter
import com.ordonteam.home4jars.view.common.InflateHelper
import com.ordonteam.home4jars.view.common.ItemAdapter
import com.ordonteam.home4jars.view.common.ItemGroup
import com.ordonteam.home4jars.view.prefrences.FirstRowController
import com.ordonteam.home4jars.view.prefrences.PreferencesAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import static com.ordonteam.home4jars.view.common.ItemGroup.FIRST_ADDITIONAL_ROWS

@CompileStatic
@TupleConstructor
final class FirstRowPreferencesItemAdapter extends ItemAdapter<Holder> {

    GlobalAdapter globalAdapter

    @Override
    int getViewType() {
        return R.layout.prefrences_first_row
    }

    @Override
    Holder onCreateViewHolder(View view) {
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(Holder holder) {
        holder.nearby.onClickListener = this.&onNearbyClick
        holder.transportation.onClickListener = this.&onTransportationClick
    }

    void onNearbyClick(View view) {
        int position = globalAdapter.getItemPosition(this)
        globalAdapter.replace(position + 1, FIRST_ADDITIONAL_ROWS, new NearbyPreferencesItemAdapter())
    }

    void onTransportationClick(View view) {
        int position = globalAdapter.getItemPosition(this)
        globalAdapter.replace(position + 1, FIRST_ADDITIONAL_ROWS, new TransportationPreferencesItemAdapter(new TransportationPreferences()))
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