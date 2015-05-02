package com.ordonteam.home4jars;

import android.app.Activity;
import android.os.Bundle
import android.widget.EditText
import com.arasthel.swissknife.SwissKnife
import com.arasthel.swissknife.annotations.InjectView
import com.arasthel.swissknife.annotations.OnClick
import com.ordonteam.home4jars.service.SearchService
import groovy.transform.CompileStatic;

@CompileStatic
final class MainActivity extends Activity {

    @InjectView(R.id.school)
    EditText school
    @InjectView(R.id.metro)
    EditText metro

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        SwissKnife.inject(this)
    }

    @OnClick(R.id.search)
    void onSearchClicked(){
        new SearchService().call(getInt(school), getInt(metro))
    }

    private int getInt(EditText editText) {
        Integer.valueOf(editText.text.toString())
    }
}
