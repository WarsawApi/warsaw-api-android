package com.ordonteam.home4jars.view

import android.app.Activity
import android.os.Bundle
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.dto.Filters
import com.ordonteam.home4jars.dto.SearchResults
import com.ordonteam.home4jars.view.filters.FiltersController
import com.ordonteam.home4jars.view.prefrences.PreferenceController
import com.ordonteam.home4jars.view.results.ResultsController
import groovy.transform.CompileStatic

@CompileStatic
final class Home4Jars extends Activity {

    PreferenceController preferenceController = new PreferenceController()
    FiltersController filtersController = new FiltersController()
    ResultsController resultsController = new ResultsController()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_4_jars_activity)

        preferenceController.init(this)
        filtersController.init(this,new Filters())
        resultsController.init(this, new SearchResults())
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