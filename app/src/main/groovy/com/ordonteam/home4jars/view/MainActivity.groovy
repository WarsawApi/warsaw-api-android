package com.ordonteam.home4jars.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.ordonteam.home4jars.view.province.ProvinceActivity
import groovy.transform.CompileStatic

@CompileStatic
final class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        Intent intent = new Intent(this, ProvinceActivity)
        startActivity(intent)
        finish()
    }
}