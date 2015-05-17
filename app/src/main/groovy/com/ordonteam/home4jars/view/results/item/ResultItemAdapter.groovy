package com.ordonteam.home4jars.view.results.item

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.SearchResult
import com.ordonteam.home4jars.view.common.InflateHelper
import com.ordonteam.home4jars.view.common.ItemAdapter
import com.ordonteam.home4jars.view.prefrences.FirstRowController
import com.ordonteam.home4jars.view.prefrences.PreferencesAdapter
import com.ordonteam.home4jars.view.prefrences.item.first.NearbyPreferencesItemAdapter
import com.ordonteam.home4jars.view.prefrences.item.first.TransportationPreferencesItemAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
final class ResultItemAdapter implements ItemAdapter {

    SearchResult searchResult

    @Override
    int getViewType() {
        return 1
    }

    @Override
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = InflateHelper.inflate(parent, R.layout.result_item)
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(RecyclerView.ViewHolder viewHolder) {
        Holder holder = viewHolder as Holder
        Glide.with(holder.itemView.context).load(searchResult.imageUrl).into(holder.imageView)
        holder.addressView.text = searchResult.address
    }

    final static class Holder extends RecyclerView.ViewHolder {

        ImageView imageView
        TextView addressView

        Holder(View itemView) {
            super(itemView)
            imageView = itemView.findViewById(R.id.result_image) as ImageView
            addressView = itemView.findViewById(R.id.result_address) as TextView
        }
    }
}