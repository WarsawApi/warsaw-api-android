package com.ordonteam.home4jars.view.common;

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import groovy.transform.CompileStatic

@CompileStatic
public class BaseRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<ItemAdapter> items = new ArrayList<>()

    @Override
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return items.find { it.viewType == viewType }.onCreateViewHolder(parent)
    }

    @Override
    int getItemViewType(int position) {
        return items[position].viewType
    }

    @Override
    void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        items[position].onBindViewHolder(holder)
    }

    @Override
    int getItemCount() {
        return items.size()
    }
}