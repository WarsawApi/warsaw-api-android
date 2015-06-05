package com.ordonteam.home4jars.view.prefrences.item.second

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.preferences.EntertainmentPreferences
import com.ordonteam.home4jars.view.common.event.DataChangedEvent
import com.ordonteam.home4jars.view.common.item.ItemAdapter
import com.ordonteam.home4jars.view.common.item.ItemGroup
import de.greenrobot.event.EventBus
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import static ItemGroup.SECOND_ADDITIONAL_ROWS

@CompileStatic
@TupleConstructor
final class EntertainmentPreferencesItemAdapter extends ItemAdapter<Holder> {

    EntertainmentPreferences entertainmentPreferences

    @Override
    int getViewType() {
        return R.layout.prefrences_entertianment_row
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
        holder.clubs.selected = entertainmentPreferences.clubs
        holder.clubs.onClickListener = this.&onClubsClick
        holder.pubs.selected = entertainmentPreferences.pubs
        holder.pubs.onClickListener = this.&onPubsClick
        holder.restaurants.selected = entertainmentPreferences.restaurants
        holder.restaurants.onClickListener = this.&onRestaurantsClick
    }

    void onClubsClick(View view){
        view.selected = !view.selected
        entertainmentPreferences.clubs = view.selected
        EventBus.default.post(new DataChangedEvent())
    }

    void onPubsClick(View view){
        view.selected = !view.selected
        entertainmentPreferences.pubs = view.selected
        EventBus.default.post(new DataChangedEvent())
    }

    void onRestaurantsClick(View view){
        view.selected = !view.selected
        entertainmentPreferences.restaurants = view.selected
        EventBus.default.post(new DataChangedEvent())
    }

    final static class Holder extends RecyclerView.ViewHolder {

        View clubs
        View pubs
        View restaurants

        Holder(View itemView) {
            super(itemView)
            clubs = itemView.findViewById(R.id.entertainment_clubs)
            pubs = itemView.findViewById(R.id.entertainment_pubs)
            restaurants = itemView.findViewById(R.id.entertainment_restaurants)
        }
    }
}