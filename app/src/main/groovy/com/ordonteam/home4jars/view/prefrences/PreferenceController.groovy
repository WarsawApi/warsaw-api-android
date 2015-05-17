package com.ordonteam.home4jars.view.prefrences

import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import groovy.transform.CompileStatic

@CompileStatic
final class PreferenceController {
    RecyclerView recyclerView
    View title

    void init(Activity activity) {
        recyclerView = activity.findViewById(R.id.preferences_recycler) as RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(activity))
        recyclerView.setAdapter(new PreferencesAdapter())

        title = activity.findViewById(R.id.preferences_title)
        title.onClickListener = this.&hideOnClick
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