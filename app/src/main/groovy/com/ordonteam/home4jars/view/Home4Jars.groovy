package com.ordonteam.home4jars.view

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.ordonteam.home4jars.R
import groovy.transform.CompileStatic

@CompileStatic
final class Home4Jars extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_4_jars_activity)

        RecyclerView globalRecyclerView = (RecyclerView) findViewById(R.id.global_recycler_view)
        globalRecyclerView.layoutManager = new LinearLayoutManager(this)
        globalRecyclerView.adapter = new GlobalAdapter()
    }

}