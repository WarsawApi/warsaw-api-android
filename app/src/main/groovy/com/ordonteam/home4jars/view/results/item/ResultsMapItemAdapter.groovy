package com.ordonteam.home4jars.view.results.item

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.SearchResults
import com.ordonteam.home4jars.view.common.InflateHelper
import com.ordonteam.home4jars.view.common.ItemAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
final class ResultsMapItemAdapter extends ItemAdapter<Holder> {

    SearchResults searchResults

    @Override
    int getViewType() {
        return R.layout.results_map
    }

    @Override
    Holder onCreateViewHolder(View view) {
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(Holder holder) {
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