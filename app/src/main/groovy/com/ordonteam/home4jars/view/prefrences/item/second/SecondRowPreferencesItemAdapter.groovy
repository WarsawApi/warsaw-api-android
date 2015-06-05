package com.ordonteam.home4jars.view.prefrences.item.second

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.common.ItemGroup
import com.ordonteam.home4jars.view.common.SectionItemAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor(includeSuperProperties = true)
final class SecondRowPreferencesItemAdapter extends SectionItemAdapter<Holder> {

    final ItemGroup itemGroup = ItemGroup.SECOND_ADDITIONAL_ROWS

    @Override
    int getViewType() {
        return R.layout.prefrences_second_row
    }

    @Override
    Holder onCreateViewHolder(View view) {
        return new Holder(view)
    }

    @Override
    void onBindViewHolder(Holder holder) {
        holder.entertainment.onClickListener = this.&onEntertainmentClick
    }

    void onEntertainmentClick(View view) {
        replace(new EntertainmentPreferencesItemAdapter())
    }

    final static class Holder extends RecyclerView.ViewHolder {

        View entertainment

        Holder(View itemView) {
            super(itemView)
            entertainment = itemView.findViewById(R.id.preferences_entertainment)
        }
    }
}