package com.ordonteam.home4jars.view.results.item

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.GlobalAdapter
import com.ordonteam.home4jars.view.common.ItemAdapter
import com.ordonteam.home4jars.view.common.ItemGroup
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import static com.ordonteam.home4jars.view.common.ItemGroup.RESULTS_HEADER

@CompileStatic
@TupleConstructor
final class ResultsHeaderItem extends ItemAdapter<Holder> {

    GlobalAdapter globalAdapter

    @Override
    int getViewType() {
        return R.layout.results_header
    }

    @Override
    Holder onCreateViewHolder(View view) {
        return new Holder(view)
    }

    @Override
    boolean match(ItemGroup itemGroup) {
        return itemGroup == RESULTS_HEADER
    }

    @Override
    void onBindViewHolder(Holder holder) {
        holder.itemView.onClickListener = this.&onHeaderClick
    }

    void onHeaderClick(View view) {
        view.selected = !view.selected
    }

    static class Holder extends RecyclerView.ViewHolder {

        Holder(View itemView) {
            super(itemView)
        }
    }
}