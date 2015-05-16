package com.ordonteam.home4jars.view.common;

import android.support.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import groovy.transform.CompileStatic

@CompileStatic
public final class InflateHelper {

    static View inflate(ViewGroup parent, @LayoutRes int layoutId) {
        def inflater = LayoutInflater.from(parent.context)
        def view = inflater.inflate(layoutId, parent, false)
        return view
    }
}