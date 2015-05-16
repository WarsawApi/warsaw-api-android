package com.ordonteam.home4jars.view.choose

import android.app.Activity
import android.util.Log
import android.view.View
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.SearchResult
import com.ordonteam.home4jars.dto.SearchResults
import com.ordonteam.home4jars.service.SearchParams
import com.ordonteam.home4jars.service.SearchService
import com.ordonteam.home4jars.view.common.EmptyTouchListener
import groovy.transform.CompileStatic
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers

@CompileStatic
abstract class SearchingActivity extends Activity {

    Subscription subscription

    void search(SearchParams params) {
        showLoader()
        subscription = new SearchService().call(params)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this.&onSuccessWrapper, this.&onError)
    }

    void onSuccessWrapper(SearchResults searchResults){
        dismissLoader()
        onSuccess(searchResults)
    }

    abstract void onSuccess(SearchResults searchResults)

    void onError(Throwable throwable) {
        Log.e('SearchService', throwable.message, throwable)
    }

    void showLoader() {
        findViewById(R.id.progress_bar).visibility = View.VISIBLE
        findViewById(R.id.progress_bar).onTouchListener = new EmptyTouchListener()
    }

    void dismissLoader() {
        findViewById(R.id.progress_bar).visibility = View.GONE
    }
}