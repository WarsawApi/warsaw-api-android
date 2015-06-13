package com.ordonteam.home4jars.view.filters.item

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.edmodo.rangebar.RangeBar
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.GlobalAdapter
import com.ordonteam.home4jars.view.common.event.DataChangedEvent
import com.ordonteam.home4jars.view.common.item.ItemAdapter
import com.ordonteam.home4jars.view.common.item.ItemGroup
import de.greenrobot.event.EventBus
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

import static com.ordonteam.home4jars.view.common.item.ItemGroup.FILTER

@CompileStatic
@TupleConstructor
final class FilterPriceItem extends ItemAdapter<Holder> {

    private static final int tickCount = 11
    private static final int pricePerTick = 350
    private static final int maxPrice = 3500

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
        holder.range.tickCount = tickCount
        holder.range.onRangeBarChangeListener = this.&onIndexChangeListener.rcurry(holder)
        int left = priceToInt(globalAdapter.filters.price.min, 0)
        int right = priceToInt(globalAdapter.filters.price.max, tickCount-1)
        holder.range.setThumbIndices(left, right)
    }

    private int priceToInt(String min, int aDefault) {
        if(min){
            return (int) (min.toInteger() / pricePerTick)
        }else {
            aDefault
        }
    }

    private void onIndexChangeListener(RangeBar ignore, int min, int max, Holder holder) {
        onMinRangeChange(min, holder)
        onMaxRangeChange(max, holder)
        EventBus.default.post(new DataChangedEvent())
    }

    private void onMinRangeChange(int min, Holder holder) {
        int from = min * pricePerTick
        holder.fromText.text = 'From: ' + from
        globalAdapter.filters.price.min = from == 0 ? null : from.toString()
    }

    private void onMaxRangeChange(int max, Holder holder) {
        int to = max * pricePerTick
        holder.toText.text = to == maxPrice ? 'To: 3500+' : 'To: ' + to
        globalAdapter.filters.price.max = to == maxPrice ? null : to.toString()
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