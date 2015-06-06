package com.ordonteam.home4jars.view.filters.item

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.GlobalAdapter
import com.ordonteam.home4jars.view.common.item.ItemAdapter
import com.ordonteam.home4jars.view.common.item.ItemGroup
import com.ordonteam.home4jars.view.prefrences.item.first.FirstRowPreferencesItemAdapter
import com.ordonteam.home4jars.view.prefrences.item.second.SecondRowPreferencesItemAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import static com.ordonteam.home4jars.view.common.item.ItemGroup.FILTER

@CompileStatic
@TupleConstructor
final class FilterPriceItem extends ItemAdapter<Holder> {

    GlobalAdapter globalAdapter

    @Override
    int getViewType() {
        return R.layout.filter_item
    }

    @Override
    Holder onCreateViewHolder(View view) {
        return new Holder(view)
    }

    @Override
    boolean match(ItemGroup itemGroup) {
        itemGroup == FILTER
    }

    @Override
    void onBindViewHolder(Holder holder) {

    }

    static class Holder extends RecyclerView.ViewHolder {

        Holder(View itemView) {
            super(itemView)
        }
    }
}