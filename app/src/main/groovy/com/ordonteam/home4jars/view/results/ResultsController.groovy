package com.ordonteam.home4jars.view.results

import android.app.Activity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.SearchResult
import com.ordonteam.home4jars.dto.SearchResults
import com.ordonteam.home4jars.service.SearchParams
import com.ordonteam.home4jars.service.SearchService
import groovy.transform.CompileStatic
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers

@CompileStatic
final class ResultsController {

    SearchResults searchResults = new SearchResults(items: [])

    RecyclerView recyclerView
    View title
    ResultsAdapter adapter
    View loader
    View content
    Subscription subscription

    void init(Activity activity) {
        content = activity.findViewById(R.id.results_content)
        loader = activity.findViewById(R.id.results_loader)

        recyclerView = activity.findViewById(R.id.results_recycler) as RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(activity))

        adapter = new ResultsAdapter()
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

        subscription = new SearchService().call(new SearchParams())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this.&onSuccess, this.&onError)
    }

    private void onSuccess(SearchResults searchResults) {
        loader.visibility = View.GONE
        recyclerView.visibility = View.VISIBLE
        adapter.searchResults = searchResults
    }

    void onError(Throwable throwable) {
        Log.e('SearchService', throwable.message, throwable)
    }
}