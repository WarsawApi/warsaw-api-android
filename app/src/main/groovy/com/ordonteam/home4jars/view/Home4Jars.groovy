package com.ordonteam.home4jars.view

import android.app.Activity
import android.os.Bundle
import android.preference.Preference
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.prefrences.PreferenceController
import com.ordonteam.home4jars.view.prefrences.PreferencesAdapter
import groovy.transform.CompileStatic

@CompileStatic
final class Home4Jars extends Activity {

    PreferenceController preferenceController = new PreferenceController()

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_4_jars_activity)

        preferenceController.init(this)
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