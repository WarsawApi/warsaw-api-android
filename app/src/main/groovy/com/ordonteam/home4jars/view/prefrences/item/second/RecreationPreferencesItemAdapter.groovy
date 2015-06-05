package com.ordonteam.home4jars.view.prefrences.item.second

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.preferences.RecreationPreferences
import com.ordonteam.home4jars.view.common.ItemAdapter
import com.ordonteam.home4jars.view.common.ItemGroup
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import static com.ordonteam.home4jars.view.common.ItemGroup.SECOND_ADDITIONAL_ROWS

@CompileStatic
@TupleConstructor
final class RecreationPreferencesItemAdapter extends ItemAdapter<Holder> {

    RecreationPreferences recreationPreferences

    @Override
    int getViewType() {
        return R.layout.prefrences_recreation_row
    }

    @Override
    boolean match(ItemGroup itemGroup) {
        return itemGroup == SECOND_ADDITIONAL_ROWS
    }

    @Override
    Holder onCreateViewHolder(View view) {
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(Holder holder) {
        holder.bikes.selected = recreationPreferences.bikes
        holder.bikes.onClickListener = this.&onBikesClick
        holder.parks.selected = recreationPreferences.parks
        holder.parks.onClickListener = this.&onParksClick
        holder.reservoirs.selected = recreationPreferences.reservoirs
        holder.reservoirs.onClickListener = this.&onReservoirsClick
    }

    void onBikesClick(View view){
        view.selected = !view.selected
        recreationPreferences.bikes = view.selected
    }

    void onParksClick(View view){
        view.selected = !view.selected
        recreationPreferences.parks = view.selected
    }

    void onReservoirsClick(View view){
        view.selected = !view.selected
        recreationPreferences.reservoirs = view.selected
    }

    final static class Holder extends RecyclerView.ViewHolder {

        View bikes
        View parks
        View reservoirs

        Holder(View itemView) {
            super(itemView)
            bikes = itemView.findViewById(R.id.recreation_bikes)
            parks = itemView.findViewById(R.id.recreation_parks)
            reservoirs = itemView.findViewById(R.id.recreation_reservoirs)
        }
    }
}