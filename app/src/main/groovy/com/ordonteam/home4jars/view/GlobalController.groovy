package com.ordonteam.home4jars.view

import android.util.Log
import com.ordonteam.home4jars.dto.SearchResults
import com.ordonteam.home4jars.service.SearchService
import com.ordonteam.home4jars.view.common.event.DataChangedEvent
import com.ordonteam.home4jars.view.common.item.ItemGroup
import com.ordonteam.home4jars.view.results.item.ResultItemAdapter
import de.greenrobot.event.EventBus
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers

@CompileStatic
@TupleConstructor
final class GlobalController {
    GlobalAdapter globalAdapter
    protected Subscription subscription

    void onResume() {
        EventBus.default.register(this)
        call()
    }

    void onPause() {
        EventBus.default.unregister(this)
        subscription?.unsubscribe()
    }

    @SuppressWarnings('unused')
    void onEvent(DataChangedEvent dataChangedEvent){
        call()
    }

    private void call() {
        subscription?.unsubscribe()
        subscription = new SearchService()
                .call(globalAdapter.preferences, globalAdapter.filters)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this.&onSuccess, this.&onError)
    }



    private void onSuccess(SearchResults searchResults) {
        globalAdapter.removeGroup(ItemGroup.RESULT)
        searchResults.items.reverse().each {
            globalAdapter.addBelow(ItemGroup.RESULTS_HEADER, new ResultItemAdapter(it))
        }
    }

    void onError(Throwable throwable) {
        Log.e('SearchService', throwable.message, throwable)
    }
}