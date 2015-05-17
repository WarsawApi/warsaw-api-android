package com.ordonteam.home4jars.functional;

import android.test.ActivityInstrumentationTestCase2;

import com.ordonteam.home4jars.MainActivity;


public abstract class BaseInstrumentationTestCase extends ActivityInstrumentationTestCase2<MainActivity> {

    public BaseInstrumentationTestCase() {
        super(MainActivity.class);
    }

}
