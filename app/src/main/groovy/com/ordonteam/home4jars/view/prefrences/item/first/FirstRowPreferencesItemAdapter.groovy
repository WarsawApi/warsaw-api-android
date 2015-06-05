package com.ordonteam.home4jars.view.prefrences.item.first

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.preferences.TransportationPreferences
import com.ordonteam.home4jars.view.common.ItemGroup
import com.ordonteam.home4jars.view.common.SectionItemAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import static com.ordonteam.home4jars.view.common.ItemGroup.FIRST_ADDITIONAL_ROWS

@CompileStatic
@TupleConstructor(includeSuperProperties = true)
final class FirstRowPreferencesItemAdapter extends SectionItemAdapter<Holder> {

    final ItemGroup itemGroup = FIRST_ADDITIONAL_ROWS

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
        holder.culture.onClickListener = this.&onCultureClick
    }

    void onNearbyClick(View view) {
        replace(new NearbyPreferencesItemAdapter())
    }

    void onTransportationClick(View view) {
        replace(new TransportationPreferencesItemAdapter(new TransportationPreferences()))
    }

    void onCultureClick(View view) {
        replace(new CulturePreferencesItemAdapter())
    }

    final static class Holder extends RecyclerView.ViewHolder {

        View nearby
        View transportation
        View culture

        Holder(View itemView) {
            super(itemView)
            nearby = itemView.findViewById(R.id.nearby)
            transportation = itemView.findViewById(R.id.transportation)
            culture = itemView.findViewById(R.id.culture)
        }
    }
}