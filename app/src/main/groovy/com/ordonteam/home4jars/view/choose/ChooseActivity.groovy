package com.ordonteam.home4jars.view.choose

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.OnClick
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.result.ResultActivity
import groovy.transform.CompileStatic

@CompileStatic
final class ChooseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.choose_activity)
        SwissKnife.inject(this)
    }

    @OnClick(R.id.next)
    void onNext() {
        ResultActivity.start(this)
    }

    static void start(Context context) {
        Intent intent = new Intent(context, ChooseActivity)
        context.startActivity(intent)
    }
}