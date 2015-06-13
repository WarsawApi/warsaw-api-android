package com.ordonteam.home4jars.view.filters.item

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.GlobalAdapter
import com.ordonteam.home4jars.view.common.item.ItemAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import static com.ordonteam.home4jars.view.common.item.ItemGroup.FILTER

@CompileStatic
@TupleConstructor
final class FiltersHeaderItem extends ItemAdapter<Holder> {

    GlobalAdapter globalAdapter

    @Override
    int getViewType() {
        return R.layout.filters_header
    }

    @Override
    Holder onCreateViewHolder(View view) {
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(Holder holder) {
        holder.itemView.selected = true
        holder.itemView.onClickListener = this.&onHeaderClick
    }

    void onHeaderClick(View view) {
        view.selected = !view.selected
        if (view.selected) {
            globalAdapter.addBelow(this, new FilterPriceItem(globalAdapter))
            globalAdapter.addBelow(this, new FilterRoomsItem(globalAdapter))
            globalAdapter.addBelow(this, new FilterMeasurementItem(globalAdapter))
        } else {
            globalAdapter.removeGroup(FILTER)
        }
    }

    static class Holder extends RecyclerView.ViewHolder {

        Holder(View itemView) {
            super(itemView)
        }
    }
}