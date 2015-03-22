package com.ordonteam;

import android.app.Activity;
import android.os.Bundle
import groovy.transform.CompileStatic;

@CompileStatic
final class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

}
