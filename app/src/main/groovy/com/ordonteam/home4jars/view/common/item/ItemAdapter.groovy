package com.ordonteam.home4jars.view.common.item

import android.support.v7.widget.RecyclerView
import android.view.View
import groovy.transform.CompileStatic

@CompileStatic
abstract class ItemAdapter<VH extends RecyclerView.ViewHolder> {

    abstract int getViewType()

    abstract VH onCreateViewHolder(View view)

    abstract void onBindViewHolder(VH viewHolder)

    boolean match(ItemGroup itemGroup){
        return false
    }
}