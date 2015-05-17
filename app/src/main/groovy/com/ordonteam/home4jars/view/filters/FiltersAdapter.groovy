package com.ordonteam.home4jars.view.filters

import com.ordonteam.home4jars.dto.Filters
import com.ordonteam.home4jars.view.common.BaseRecyclerViewAdapter
import groovy.transform.CompileStatic

@CompileStatic
final class FiltersAdapter extends BaseRecyclerViewAdapter {

    Filters filters

    FiltersAdapter(Filters filters) {
        this.filters = filters
    }
}