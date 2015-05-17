package com.ordonteam.home4jars.view.prefrences.item

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.common.Bus
import com.ordonteam.home4jars.view.common.InflateHelper
import com.ordonteam.home4jars.view.common.ItemAdapter
import com.ordonteam.home4jars.view.prefrences.event.EntertainmentClickEvent
import groovy.transform.CompileStatic

@CompileStatic
final class SecondRowPreferencesItemAdapter implements ItemAdapter {
    @Override
    int getViewType() {
        return 2
    }

    @Override
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = InflateHelper.inflate(parent, R.layout.prefrences_second_row)
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        Holder holder = viewHolder as Holder
        holder.entertainment.onClickListener = this.&onEntertainmentClick
    }

    void onEntertainmentClick(View view) {
        Bus.post(new EntertainmentClickEvent())
    }

    final static class Holder extends RecyclerView.ViewHolder {

        View entertainment

        Holder(View itemView) {
            super(itemView)
            entertainment = itemView.findViewById(R.id.preferences_entertainment)
        }
    }
}