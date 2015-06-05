package com.ordonteam.home4jars.view.prefrences

import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.common.ItemAdapter
import groovy.transform.CompileStatic

@CompileStatic
final class PreferencesHeaderItem extends ItemAdapter<Holder> {
    @Override
    int getViewType() {
        return R.layout.preferences_header
    }

    @Override
    Holder onCreateViewHolder(View view) {
        return new Holder(view)
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