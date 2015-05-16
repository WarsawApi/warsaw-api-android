package com.ordonteam.home4jars.view.search

import android.app.Activity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.SearchResult
import com.ordonteam.home4jars.service.SearchService
import de.greenrobot.event.EventBus
import groovy.transform.CompileStatic
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers

@CompileStatic
final class SearchActivity extends Activity {

    Subscription subscription

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        ViewPager pager = findViewById(R.id.search_pager) as ViewPager
        pager.setAdapter(new SearchPagerAdapter())
    }

    @Override
    protected void onResume() {
        super.onResume()
        EventBus.default.register(this)
    }

    @Override
    protected void onPause() {
        super.onPause()
        EventBus.default.unregister(this)
        subscription?.unsubscribe()
    }

    @SuppressWarnings('unused')
    void onEvent(SearchEvent event){
        subscription = new SearchService().call(event.searchParams)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this.&onSuccess, this.&onError)
    }

    void onSuccess(List<SearchResult> searchResults) {
        Log.e('success',searchResults.toString())
        ImageView mapView = findViewById(R.id.search_map) as ImageView
        String markers = searchResults.collect {
            it.markerString
        }.join('&')
        String center = searchResults.first().centerString
        String size = "size=${mapView.width}x${mapView.width}"
        String url = 'https://maps.googleapis.com/maps/api/staticmap?' +
                "$size&$center&$markers"
        Glide.with(this).load(url).into(mapView)
    }

    void onError(Throwable throwable) {
        Log.e('Call error', throwable.message, throwable)
    }

    private int getInt(EditText editText) {
        Integer.valueOf(editText.text.toString())
    }
}
