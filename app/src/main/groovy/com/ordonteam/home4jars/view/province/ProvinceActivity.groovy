package com.ordonteam.home4jars.view.province

import android.app.Activity
import android.os.Bundle
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.OnClick
import com.ordonteam.home4jars.R
import com.ordonteam.home4jars.view.choose.ChooseActivity
import groovy.transform.CompileStatic

@CompileStatic
final class ProvinceActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.province_activity)
        SwissKnife.inject(this)
    }

    @OnClick(R.id.next)
    void onNext(){
        ChooseActivity.start(this)
    }
}