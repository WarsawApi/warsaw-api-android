package com.ordonteam.home4jars.view.common

import android.text.Editable
import android.text.TextWatcher
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
final class EmptyTextWatcher implements TextWatcher {

    TextChangedWatcher textChangedWatcher

    @Override
    void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    void onTextChanged(CharSequence s, int start, int before, int count) {
        textChangedWatcher?.onTextChanged(s.toString())
    }

    @Override
    void afterTextChanged(Editable s) {

    }

    interface TextChangedWatcher {
        void onTextChanged(String text)
    }
}