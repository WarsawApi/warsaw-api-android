package com.ordonteam.home4jars.view.common

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.ordonteam.home4jars.R
import groovy.transform.CompileStatic

@CompileStatic
abstract class LoaderActivity extends Activity {

    @Override
    protected void onResume() {
        super.onResume()
        dismissLoader()
    }

    void showLoader() {
        findViewById(R.id.progress_bar).visibility = View.VISIBLE
        findViewById(R.id.progress_bar).onTouchListener = new EmptyTouchListener()
    }

    void dismissLoader() {
        findViewById(R.id.progress_bar).visibility = View.GONE
    }
}