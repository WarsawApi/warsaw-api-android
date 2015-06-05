package com.ordonteam.home4jars.view.prefrences.item

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.GlobalAdapter
import com.ordonteam.home4jars.view.common.ItemAdapter
import com.ordonteam.home4jars.view.common.ItemGroup
import com.ordonteam.home4jars.view.prefrences.item.first.FirstRowPreferencesItemAdapter
import com.ordonteam.home4jars.view.prefrences.item.second.SecondRowPreferencesItemAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
final class PreferencesHeaderItem extends ItemAdapter<Holder> {

    GlobalAdapter globalAdapter

    @Override
    int getViewType() {
        return R.layout.prefrences_header
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
            globalAdapter.addBelow(this, new SecondRowPreferencesItemAdapter(globalAdapter))
            globalAdapter.addBelow(this, new FirstRowPreferencesItemAdapter(globalAdapter))
        } else {
            globalAdapter.removeGroup(ItemGroup.FIRST_ROW)
            globalAdapter.removeGroup(ItemGroup.FIRST_ADDITIONAL_ROWS)
            globalAdapter.removeGroup(ItemGroup.SECOND_ROW)
            globalAdapter.removeGroup(ItemGroup.SECOND_ADDITIONAL_ROWS)
        }
    }

    static class Holder extends RecyclerView.ViewHolder {

        Holder(View itemView) {
            super(itemView)
        }
    }
}