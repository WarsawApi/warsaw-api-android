package com.ordonteam.home4jars.view.common

import android.support.v7.widget.RecyclerView
import com.ordonteam.home4jars.view.GlobalAdapter
import groovy.transform.CompileStatic

@CompileStatic
abstract class SectionItemAdapter<VH extends RecyclerView.ViewHolder> extends ItemAdapter<VH> {
    GlobalAdapter globalAdapter

    abstract ItemGroup getItemGroup()

    void replace(ItemAdapter itemAdapter) {
        int position = globalAdapter.getItemPosition(this)
        globalAdapter.replace(position + 1, itemGroup, itemAdapter)
    }
}