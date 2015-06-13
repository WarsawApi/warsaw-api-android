package com.ordonteam.home4jars.view.filters.item

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.TextView
import com.edmodo.rangebar.RangeBar
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.GlobalAdapter
import com.ordonteam.home4jars.view.common.item.ItemAdapter
import com.ordonteam.home4jars.view.common.item.ItemGroup
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
        holder.range.onRangeBarChangeListener = this.&onIndexChangeListener.rcurry(holder)
    }

    void onIndexChangeListener(RangeBar rangeBar, int min, int max, Holder holder) {
        Log.e('aaaaa', "min=$min max=$max")
        if (min == 0) {
            globalAdapter.filters.price.min = null
            holder.fromText.text = 'From: 0'
        } else {
            String from = (min * 350).toString()
            globalAdapter.filters.price.min = from
            holder.fromText.text = 'From: '+from
        }
        if (max == 9) {
            globalAdapter.filters.price.max = null
            holder.toText.text = 'To: 3500+'
        } else {
            int to = max * 350
            globalAdapter.filters.price.max = to.toString()
            holder.toText.text = 'To: ' + to
        }
    }

    static class Holder extends RecyclerView.ViewHolder {

        RangeBar range
        TextView fromText
        TextView toText

        Holder(View itemView) {
            super(itemView)
            range = (RangeBar) itemView.findViewById(R.id.range)
            fromText = (TextView) itemView.findViewById(R.id.range_from)
            toText = (TextView) itemView.findViewById(R.id.range_to)
        }
    }
}