package com.ordonteam.home4jars.view.common;

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import groovy.transform.CompileStatic

@CompileStatic
public class BaseRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected List<ItemAdapter> items = new ArrayList<>()

    @Override
    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = InflateHelper.inflate(parent, viewType)
        return items.find { it.viewType == viewType }.onCreateViewHolder(inflatedView)
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

    int getItemPosition(ItemAdapter itemAdapter) {
        return items.indexOf(itemAdapter)
    }

    int getItemPosition(ItemGroup itemGroup) {
        return items.indexOf(items.find { it.match(itemGroup) })
    }

    void addBelow(ItemAdapter itemAdapter, ItemAdapter itemToAdd) {
        int position = getItemPosition(itemAdapter) + 1
        items.add(position, itemToAdd)
        notifyItemInserted(position)
    }

    void addBelow(ItemGroup itemGroup, ItemAdapter itemToAdd) {
        int position = getItemPosition(itemGroup) + 1
        items.add(position, itemToAdd)
        notifyItemInserted(position)
    }
}