package com.ordonteam.home4jars.view.prefrences.item.first

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.preferences.TransportationPreferences
import com.ordonteam.home4jars.view.common.event.DataChangedEvent
import com.ordonteam.home4jars.view.common.item.ItemAdapter
import com.ordonteam.home4jars.view.common.item.ItemGroup
import de.greenrobot.event.EventBus
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import static ItemGroup.FIRST_ADDITIONAL_ROWS

@CompileStatic
@TupleConstructor
final class TransportationPreferencesItemAdapter extends ItemAdapter<Holder> {

    TransportationPreferences transportationPreferences

    @Override
    int getViewType() {
        return R.layout.prefrences_transportation_row
    }

    @Override
    boolean match(ItemGroup itemGroup) {
        return itemGroup == FIRST_ADDITIONAL_ROWS
    }

    @Override
    Holder onCreateViewHolder(View view) {
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(Holder holder) {
        holder.subway.selected = transportationPreferences.subway
        holder.subway.onClickListener = this.&onSubwayClick
        holder.tramway.selected = transportationPreferences.tramway
        holder.tramway.onClickListener = this.&onTramwayClick
        holder.onFoot.selected = transportationPreferences.onFoot
        holder.onFoot.onClickListener = this.&onOnFootClick
    }

    void onSubwayClick(View view){
        view.selected = !view.selected
        transportationPreferences.subway = view.selected
        EventBus.default.post(new DataChangedEvent())
    }

    void onTramwayClick(View view){
        view.selected = !view.selected
        transportationPreferences.tramway = view.selected
        EventBus.default.post(new DataChangedEvent())
    }

    void onOnFootClick(View view){
        view.selected = !view.selected
        transportationPreferences.onFoot = view.selected
        EventBus.default.post(new DataChangedEvent())
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