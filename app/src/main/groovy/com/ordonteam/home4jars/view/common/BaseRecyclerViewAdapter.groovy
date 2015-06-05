package com.ordonteam.home4jars.view.common;

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ordonteam.home4jars.view.common.item.ItemAdapter
import com.ordonteam.home4jars.view.common.item.ItemGroup
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

    void addBelow(ItemAdapter itemAdapter, ItemAdapter itemToAdd) {
        addBelow(getItemPosition(itemAdapter), itemToAdd)
    }

    int getItemPosition(ItemAdapter itemAdapter) {
        return items.indexOf(itemAdapter)
    }

    void addBelow(ItemGroup itemGroup, ItemAdapter itemToAdd) {
        addBelow(getItemPosition(itemGroup), itemToAdd)
    }

    int getItemPosition(ItemGroup itemGroup) {
        return items.indexOf(items.find { it.match(itemGroup) })
    }

    void addBelow(int position, ItemAdapter itemToAdd) {
        int target = position + 1
        items.add(target, itemToAdd)
        notifyItemInserted(target)
    }
}