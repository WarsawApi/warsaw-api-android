package com.ordonteam.home4jars.view.prefrences

import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.common.Bus
import com.ordonteam.home4jars.view.prefrences.event.EntertainmentClickEvent
import com.ordonteam.home4jars.view.prefrences.event.TransportationClickEvent
import com.ordonteam.home4jars.view.prefrences.item.EntertainmentPreferencesItemAdapter
import com.ordonteam.home4jars.view.prefrences.item.TransportationPreferencesItemAdapter
import groovy.transform.CompileStatic

@CompileStatic
final class PreferenceController implements Bus.Listener {
    RecyclerView recyclerView
    View title
    PreferencesAdapter adapter

    void init(Activity activity) {
        recyclerView = activity.findViewById(R.id.preferences_recycler) as RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(activity))
        adapter = new PreferencesAdapter()
        recyclerView.setAdapter(adapter)

        title = activity.findViewById(R.id.preferences_title)
        title.onClickListener = this.&hideOnClick
    }

    void onResume() {
        Bus.register(this)
    }

    void onPause() {
        Bus.unregister(this)
    }

    @SuppressWarnings('unused')
    void onEvent(TransportationClickEvent event) {
        adapter.showInFirstAdditionalRow(new TransportationPreferencesItemAdapter())
    }

    @SuppressWarnings('unused')
    void onEvent(EntertainmentClickEvent event) {
        adapter.showInSecondAdditionalRow(new EntertainmentPreferencesItemAdapter())
    }

    void hideOnClick(View view) {
        recyclerView.visibility = View.GONE
        title.backgroundResource = R.drawable.title_background_collapsed
        title.onClickListener = this.&showOnClick
    }

    void showOnClick(View view) {
        recyclerView.visibility = View.VISIBLE
        title.backgroundResource = R.drawable.title_background
        title.onClickListener = this.&hideOnClick
    }
}