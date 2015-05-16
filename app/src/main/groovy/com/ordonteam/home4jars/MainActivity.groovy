package com.ordonteam.home4jars

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.ordonteam.home4jars.view.Home4Jars
import groovy.transform.CompileStatic

@CompileStatic
final class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState)
        Intent intent = new Intent(this, Home4Jars)
        startActivity(intent)
        finish()
    }
}