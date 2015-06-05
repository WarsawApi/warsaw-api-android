package com.ordonteam.home4jars.view.prefrences.item.first

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.preferences.CulturePreferences
import com.ordonteam.home4jars.view.common.ItemAdapter
import com.ordonteam.home4jars.view.common.ItemGroup
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import static com.ordonteam.home4jars.view.common.ItemGroup.FIRST_ADDITIONAL_ROWS

@CompileStatic
@TupleConstructor
final class CulturePreferencesItemAdapter extends ItemAdapter<Holder> {

    CulturePreferences culturePreferences = new CulturePreferences()

    @Override
    int getViewType() {
        return R.layout.prefrences_culture_row
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
        holder.cinemas.selected = culturePreferences.cinemas
        holder.cinemas.onClickListener = this.&onCinemasClick
        holder.theatres.selected = culturePreferences.theatre
        holder.theatres.onClickListener = this.&onTheatresClick
        holder.exhibitions.selected = culturePreferences.exhibitions
        holder.exhibitions.onClickListener = this.&onExhibitionsClick
    }

    void onCinemasClick(View view){
        view.selected = !view.selected
        culturePreferences.cinemas = view.selected
    }

    void onTheatresClick(View view){
        view.selected = !view.selected
        culturePreferences.theatre = view.selected
    }

    void onExhibitionsClick(View view){
        view.selected = !view.selected
        culturePreferences.exhibitions = view.selected
    }

    final static class Holder extends RecyclerView.ViewHolder {

        View cinemas
        View theatres
        View exhibitions

        Holder(View itemView) {
            super(itemView)
            cinemas = itemView.findViewById(R.id.culture_cinemas)
            theatres = itemView.findViewById(R.id.culture_theatres)
            exhibitions = itemView.findViewById(R.id.culture_exhibitions)
        }
    }
}