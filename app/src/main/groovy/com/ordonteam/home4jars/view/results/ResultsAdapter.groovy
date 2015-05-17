package com.ordonteam.home4jars.view.results

import com.ordonteam.home4jars.dto.SearchResults
import com.ordonteam.home4jars.view.common.BaseRecyclerViewAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
final class ResultsAdapter extends BaseRecyclerViewAdapter {

    SearchResults searchResults
}