package com.ordonteam.home4jars.view.choose

import android.app.Activity
import android.content.Context
import android.content.Intent
import groovy.transform.CompileStatic

@CompileStatic
final class ChooseActivity extends Activity {

    static void start(Context context) {
        Intent intent = new Intent(context, ChooseActivity)
        context.startActivity(intent)
    }
}