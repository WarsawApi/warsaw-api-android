package com.ordonteam.home4jars.view.prefrences.item

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.common.InflateHelper
import com.ordonteam.home4jars.view.common.ItemAdapter
import groovy.transform.CompileStatic

@CompileStatic
final class FirstRowPreferencesItemAdapter implements ItemAdapter {
    @Override
    int getViewType() {
        return 1
    }

    @Override
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = InflateHelper.inflate(parent, R.layout.prefrences_first_row)
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        Holder holder = viewHolder as Holder
        holder.transportation.onClickListener = this.&onTransportationClick
    }

    void onTransportationClick(View view){

    }

    final static class Holder extends RecyclerView.ViewHolder {

        View transportation

        Holder(View itemView) {
            super(itemView)
            transportation = itemView.findViewById(R.id.preferences_transportation)
        }
    }
}