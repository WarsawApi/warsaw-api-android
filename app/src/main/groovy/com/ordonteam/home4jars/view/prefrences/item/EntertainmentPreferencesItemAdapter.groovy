package com.ordonteam.home4jars.view.prefrences.item

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.common.InflateHelper
import com.ordonteam.home4jars.view.common.ItemAdapter
import groovy.transform.CompileStatic

@CompileStatic
final class EntertainmentPreferencesItemAdapter implements ItemAdapter {
    @Override
    int getViewType() {
        return 21
    }

    @Override
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = InflateHelper.inflate(parent, R.layout.prefrences_transportation_row)
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(RecyclerView.ViewHolder holder) {

    }

    final static class Holder extends RecyclerView.ViewHolder {

        Holder(View itemView) {
            super(itemView)
        }
    }
}