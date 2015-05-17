package com.ordonteam.home4jars.view.results.item

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.SearchResults
import com.ordonteam.home4jars.view.common.InflateHelper
import com.ordonteam.home4jars.view.common.ItemAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
final class ResultsMapItemAdapter implements ItemAdapter {

    SearchResults searchResults

    @Override
    int getViewType() {
        return 2
    }

    @Override
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = InflateHelper.inflate(parent, R.layout.results_map)
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        Holder holder = viewHolder as Holder
        Glide.with(holder.itemView.context).load(searchResults.mapUrl).into(holder.mapView)
    }

    final static class Holder extends RecyclerView.ViewHolder {

        ImageView mapView

        Holder(View itemView) {
            super(itemView)
            mapView = itemView.findViewById(R.id.results_map) as ImageView
        }
    }
}