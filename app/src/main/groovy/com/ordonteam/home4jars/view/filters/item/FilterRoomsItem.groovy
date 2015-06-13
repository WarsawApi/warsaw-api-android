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
final class FilterRoomsItem extends ItemAdapter<FilterHolder> {

    private static final int tickCount = 5
    private static final int pricePerTick = 1
    private static final int maxPrice = 5

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
        holder.title.text = 'Rooms'
        holder.range.tickCount = tickCount
        holder.range.onRangeBarChangeListener = this.&onIndexChangeListener.rcurry(holder)
        int left = priceToInt(globalAdapter.filters.rooms.min, 0)
        int right = priceToInt(globalAdapter.filters.rooms.max, tickCount - 1)
        holder.range.setThumbIndices(left, right)
    }

    private int priceToInt(String string, int aDefault) {
        if (string) {
            return string.toInteger() -1
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
        int from = min * pricePerTick + pricePerTick
        holder.fromText.text = 'From: ' + from
        globalAdapter.filters.rooms.min = from == 1 ? null : from.toString()
    }

    private void onMaxRangeChange(int max, FilterHolder holder) {
        int to = max * pricePerTick + pricePerTick
        holder.toText.text = to == maxPrice ? 'To: ' + maxPrice + '+' : 'To: ' + to
        globalAdapter.filters.rooms.max = to == maxPrice ? null : to.toString()
    }
}