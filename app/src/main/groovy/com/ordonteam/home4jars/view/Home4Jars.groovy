package com.ordonteam.home4jars.view

import android.app.Activity
import android.os.Bundle
import android.preference.Preference
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.prefrences.PreferencesAdapter
import groovy.transform.CompileStatic

@CompileStatic
final class Home4Jars extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_4_jars_activity)
        RecyclerView recyclerView = findViewById(R.id.preferences_recycler) as RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this))
        recyclerView.setAdapter(new PreferencesAdapter())
    }
}