package com.ordonteam.home4jars.view.filters.item

import android.view.View
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
final class FilterMeasurementItem extends ItemAdapter<FilterHolder> {

    private static final int tickCount = 11
    private static final int pricePerTick = 20
    private static final int maxPrice = 200

    GlobalAdapter globalAdapter

    @Override
    int getViewType() {
        return R.layout.filter_item
    }

    @Override
    FilterHolder onCreateViewHolder(View view) {
        return new FilterHolder(view)
    }

    @Override
    boolean match(ItemGroup itemGroup) {
        itemGroup == FILTER
    }

    @Override
    void onBindViewHolder(FilterHolder holder) {
        holder.title.text = 'Measurement'
        holder.range.tickCount = tickCount
        holder.range.onRangeBarChangeListener = this.&onIndexChangeListener.rcurry(holder)
        int left = priceToInt(globalAdapter.filters.measurement.min, 0)
        int right = priceToInt(globalAdapter.filters.measurement.max, tickCount - 1)
        holder.range.setThumbIndices(left, right)
    }

    private int priceToInt(String min, int aDefault) {
        if (min) {
            return (int) (min.toInteger() / pricePerTick)
        } else {
            aDefault
        }
    }

    private void onIndexChangeListener(RangeBar ignore, int min, int max, FilterHolder holder) {
        onMinRangeChange(min, holder)
        onMaxRangeChange(max, holder)
        EventBus.default.post(new DataChangedEvent())
    }

    private void onMinRangeChange(int min, FilterHolder holder) {
        int from = min * pricePerTick
        holder.fromText.text = 'From: ' + from
        globalAdapter.filters.measurement.min = from == 0 ? null : from.toString()
    }

    private void onMaxRangeChange(int max, FilterHolder holder) {
        int to = max * pricePerTick
        holder.toText.text = to == maxPrice ? 'To: ' + maxPrice + '+' : 'To: ' + to
        globalAdapter.filters.measurement.max = to == maxPrice ? null : to.toString()
    }
}