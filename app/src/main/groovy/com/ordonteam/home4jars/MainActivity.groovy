package com.ordonteam.home4jars;

import android.app.Activity;
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
import com.arasthel.swissknife.annotations.OnClick
import com.bumptech.glide.Glide
import com.ordonteam.home4jars.dto.SearchResult
import com.ordonteam.home4jars.service.SearchService
import groovy.transform.CompileStatic
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers;

@CompileStatic
final class MainActivity extends Activity {

    @InjectView(R.id.school)
    EditText school
    @InjectView(R.id.metro)
    EditText metro
    Subscription subscription

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        SwissKnife.inject(this)
    }

    @OnClick(R.id.search)
    void onSearchClicked() {
        subscription = new SearchService().call(getInt(school), getInt(metro))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this.&onSuccess, this.&onError)
    }

    @Override
    protected void onPause() {
        super.onPause()
        subscription?.unsubscribe()
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
