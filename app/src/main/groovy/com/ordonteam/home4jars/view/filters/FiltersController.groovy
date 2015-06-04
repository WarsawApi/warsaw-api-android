package com.ordonteam.home4jars.view.filters

import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.filters.Filters
import groovy.transform.CompileStatic

@CompileStatic
final class FiltersController {
    RecyclerView recyclerView
    View title
    FiltersAdapter adapter

    void init(Activity activity, Filters filters) {
        recyclerView = activity.findViewById(R.id.filters_recycler) as RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(activity))

        adapter = new FiltersAdapter(filters)
        recyclerView.setAdapter(adapter)

        title = activity.findViewById(R.id.filters_title)
        title.onClickListener = this.&showOnClick
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