package com.ordonteam.home4jars.view.result

import android.app.Activity
import android.content.Context
import android.content.Intent
import groovy.transform.CompileStatic

@CompileStatic
final class ResultActivity extends Activity {
    static void start(Context context) {
        Intent intent = new Intent(context, ResultActivity)
        context.startActivity(intent)
    }
}