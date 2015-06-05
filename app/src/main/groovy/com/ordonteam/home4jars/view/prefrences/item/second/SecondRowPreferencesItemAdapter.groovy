package com.ordonteam.home4jars.view.prefrences.item.second

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.common.InflateHelper
import com.ordonteam.home4jars.view.common.ItemAdapter
import com.ordonteam.home4jars.view.prefrences.PreferencesAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
final class SecondRowPreferencesItemAdapter extends ItemAdapter<Holder> {

    PreferencesAdapter adapter

    @Override
    int getViewType() {
        return R.layout.prefrences_second_row
    }

    @Override
    Holder onCreateViewHolder(View view) {
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(Holder holder) {
        holder.entertainment.onClickListener = this.&onEntertainmentClick
    }

    void onEntertainmentClick(View view) {
        adapter.showInSecondAdditionalRow(new EntertainmentPreferencesItemAdapter())
    }

    final static class Holder extends RecyclerView.ViewHolder {

        View entertainment

        Holder(View itemView) {
            super(itemView)
            entertainment = itemView.findViewById(R.id.preferences_entertainment)
        }
    }
}