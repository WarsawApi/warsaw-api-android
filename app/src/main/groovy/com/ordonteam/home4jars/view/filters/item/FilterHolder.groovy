package com.ordonteam.home4jars.view.filters.item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.edmodo.rangebar.RangeBar;
import com.ordonteam.home4jars.R;

class FilterHolder extends RecyclerView.ViewHolder {

    RangeBar range
    TextView fromText
    TextView toText
    TextView title

    FilterHolder(View itemView) {
        super(itemView)
        title = (TextView) itemView.findViewById(R.id.range_title)
        range = (RangeBar) itemView.findViewById(R.id.range)
        fromText = (TextView) itemView.findViewById(R.id.range_from)
        toText = (TextView) itemView.findViewById(R.id.range_to)
    }
}