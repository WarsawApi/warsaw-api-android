package com.ordonteam.home4jars.view.prefrences.item.second

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.preferences.SportPreferences
import com.ordonteam.home4jars.view.common.ItemAdapter
import com.ordonteam.home4jars.view.common.ItemGroup
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import static com.ordonteam.home4jars.view.common.ItemGroup.SECOND_ADDITIONAL_ROWS

@CompileStatic
@TupleConstructor
final class SportPreferencesItemAdapter extends ItemAdapter<Holder> {

    SportPreferences sportPreferences

    @Override
    int getViewType() {
        return R.layout.prefrences_sport_row
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
        holder.fitness.selected = sportPreferences.fitness
        holder.fitness.onClickListener = this.&onFitnessClick
        holder.pools.selected = sportPreferences.pools
        holder.pools.onClickListener = this.&onPoolsClick
        holder.tennis.selected = sportPreferences.tennis
        holder.tennis.onClickListener = this.&onTennisClick
    }

    void onFitnessClick(View view){
        view.selected = !view.selected
        sportPreferences.fitness = view.selected
    }

    void onPoolsClick(View view){
        view.selected = !view.selected
        sportPreferences.pools = view.selected
    }

    void onTennisClick(View view){
        view.selected = !view.selected
        sportPreferences.tennis = view.selected
    }

    final static class Holder extends RecyclerView.ViewHolder {

        View fitness
        View pools
        View tennis

        Holder(View itemView) {
            super(itemView)
            fitness = itemView.findViewById(R.id.sport_fitness)
            pools = itemView.findViewById(R.id.sport_pools)
            tennis = itemView.findViewById(R.id.sport_tennis)
        }
    }
}