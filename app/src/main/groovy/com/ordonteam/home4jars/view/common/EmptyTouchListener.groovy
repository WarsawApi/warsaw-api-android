package com.ordonteam.home4jars.view.common

import android.view.MotionEvent
import android.view.View
import groovy.transform.CompileStatic

@CompileStatic
final class EmptyTouchListener implements View.OnTouchListener {
    @Override
    boolean onTouch(View v, MotionEvent event) {
        return true
    }
}