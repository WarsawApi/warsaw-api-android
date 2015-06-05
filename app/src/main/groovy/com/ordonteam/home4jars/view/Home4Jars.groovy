package com.ordonteam.home4jars.view

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.filters.Filters
import com.ordonteam.home4jars.dto.preferences.Preferences
import com.ordonteam.home4jars.view.filters.FiltersController
import com.ordonteam.home4jars.view.prefrences.PreferenceController
import com.ordonteam.home4jars.view.results.ResultsController
import groovy.transform.CompileStatic

@CompileStatic
final class Home4Jars extends Activity {


//    PreferenceController preferenceController = new PreferenceController()
//    FiltersController filtersController = new FiltersController()
//    ResultsController resultsController = new ResultsController()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_4_jars_activity)

        RecyclerView globalRecyclerView = (RecyclerView) findViewById(R.id.global_recycler_view)
        globalRecyclerView.layoutManager = new LinearLayoutManager(this)
        globalRecyclerView.adapter = new GlobalAdapter()

//        preferenceController.init(this)
//        filtersController.init(this,new Filters())
//        resultsController.init(this)
    }

    @Override
    protected void onResume() {
        super.onResume()
//        preferenceController.onResume()
    }

    @Override
    protected void onPause() {
        super.onPause()
//        preferenceController.onPause()
    }
}