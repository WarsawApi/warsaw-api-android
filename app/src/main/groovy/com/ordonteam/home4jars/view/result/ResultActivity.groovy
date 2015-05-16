package com.ordonteam.home4jars.view.result

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.ordonteam.home4jars.dto.SearchResults
import groovy.transform.CompileStatic

@CompileStatic
final class ResultActivity extends Activity {


    public static final String SEARCH__RESULTS = 'SEARCH_RESULTS'

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        Log.e('ResultActivity', intent.getParcelableExtra(SEARCH__RESULTS).toString())
    }

    static void start(Context context, SearchResults searchResults) {
        Intent intent = new Intent(context, ResultActivity)
        intent.putExtra(SEARCH__RESULTS, searchResults)
        context.startActivity(intent)
    }
}