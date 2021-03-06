package com.ordonteam.home4jars.view.prefrences.item.second

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.common.item.ItemGroup
import com.ordonteam.home4jars.view.common.item.SectionItemAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import static ItemGroup.FIRST_ADDITIONAL_ROWS
import static ItemGroup.SECOND_ROW

@CompileStatic
@TupleConstructor(includeSuperProperties = true)
final class SecondRowPreferencesItemAdapter extends SectionItemAdapter<Holder> {

    final ItemGroup itemGroup = ItemGroup.SECOND_ADDITIONAL_ROWS

    @Override
    int getViewType() {
        return R.layout.prefrences_second_row
    }

    @Override
    Holder onCreateViewHolder(View view) {
        return new Holder(view)
    }

    @Override
    boolean match(ItemGroup itemGroup) {
        return itemGroup == SECOND_ROW
    }

    @Override
    void onBindViewHolder(Holder holder) {
        holder.entertainment.onClickListener = this.&onEntertainmentClick
        holder.sport.onClickListener = this.&onSportClick
        holder.recreation.onClickListener = this.&onRecreationClick
    }

    void onEntertainmentClick(View view) {
        globalAdapter.removeGroup(FIRST_ADDITIONAL_ROWS)
        replace(new EntertainmentPreferencesItemAdapter(globalAdapter.preferences.entertainmentPreferences))
    }

    void onSportClick(View view) {
        globalAdapter.removeGroup(FIRST_ADDITIONAL_ROWS)
        replace(new SportPreferencesItemAdapter(globalAdapter.preferences.sportPreferences))
    }

    void onRecreationClick(View view) {
        globalAdapter.removeGroup(FIRST_ADDITIONAL_ROWS)
        replace(new RecreationPreferencesItemAdapter(globalAdapter.preferences.recreationPreferences))
    }

    final static class Holder extends RecyclerView.ViewHolder {

        View entertainment
        View sport
        View recreation

        Holder(View itemView) {
            super(itemView)
            entertainment = itemView.findViewById(R.id.preferences_entertainment)
            sport = itemView.findViewById(R.id.preferences_sport)
            recreation = itemView.findViewById(R.id.preferences_recreation)
        }
    }
}