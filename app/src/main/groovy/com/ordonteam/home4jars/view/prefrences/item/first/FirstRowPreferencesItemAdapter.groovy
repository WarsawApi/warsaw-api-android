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
import static com.ordonteam.home4jars.view.common.ItemGroup.FIRST_ROW
import static com.ordonteam.home4jars.view.common.ItemGroup.SECOND_ADDITIONAL_ROWS

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
    boolean match(ItemGroup itemGroup) {
        return itemGroup == FIRST_ROW
    }

    @Override
    void onBindViewHolder(Holder holder) {
        holder.nearby.onClickListener = this.&onNearbyClick
        holder.transportation.onClickListener = this.&onTransportationClick
        holder.culture.onClickListener = this.&onCultureClick
    }

    void onNearbyClick(View view) {
        globalAdapter.removeGroup(SECOND_ADDITIONAL_ROWS)
        replace(new NearbyPreferencesItemAdapter(globalAdapter.preferences.nearbyPreferences))
    }

    void onTransportationClick(View view) {
        globalAdapter.removeGroup(SECOND_ADDITIONAL_ROWS)
        replace(new TransportationPreferencesItemAdapter(globalAdapter.preferences.transportationPreferences))
    }

    void onCultureClick(View view) {
        globalAdapter.removeGroup(SECOND_ADDITIONAL_ROWS)
        replace(new CulturePreferencesItemAdapter(globalAdapter.preferences.culturePreferences))
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