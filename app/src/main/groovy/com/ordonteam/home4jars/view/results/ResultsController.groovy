package com.ordonteam.home4jars.view.results

import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.SearchResults
import groovy.transform.CompileStatic

@CompileStatic
final class ResultsController {

    SearchResults searchResults = new SearchResults(items: [])

    RecyclerView recyclerView
    View title
    ResultsAdapter adapter
    View loader
    View content

    void init(Activity activity) {
        content = activity.findViewById(R.id.results_content)
        loader = activity.findViewById(R.id.results_loader)

        recyclerView = activity.findViewById(R.id.results_recycler) as RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(activity))

        adapter = new ResultsAdapter(searchResults)
        recyclerView.setAdapter(adapter)

        title = activity.findViewById(R.id.results_title)
        title.onClickListener = this.&showOnClick
    }

    void hideOnClick(View view) {
        content.visibility = View.GONE
        loader.visibility = View.GONE
        recyclerView.visibility = View.GONE
        title.backgroundResource = R.drawable.title_background_collapsed
        title.onClickListener = this.&showOnClick
    }

    void showOnClick(View view) {
        content.visibility = View.VISIBLE
        loader.visibility = View.VISIBLE
        title.backgroundResource = R.drawable.title_background
        title.onClickListener = this.&hideOnClick
        loader.post{
            onSuccess()
        }
    }

    private void onSuccess() {
        loader.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
    }
}