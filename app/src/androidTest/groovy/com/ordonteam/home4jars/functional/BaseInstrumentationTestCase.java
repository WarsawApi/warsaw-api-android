package com.ordonteam.home4jars.functional;

import android.test.ActivityInstrumentationTestCase2;

import com.ordonteam.home4jars.view.depercated.search.SearchActivity;


public abstract class BaseInstrumentationTestCase extends ActivityInstrumentationTestCase2<SearchActivity> {

    public BaseInstrumentationTestCase() {
        super(SearchActivity.class);
    }

}
