package com.ordonteam.home4jars.view.common;

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import groovy.transform.CompileStatic

@CompileStatic
public interface ItemAdapter {

    int getViewType()

    RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent)

    void onBindViewHolder(RecyclerView.ViewHolder holder)
}