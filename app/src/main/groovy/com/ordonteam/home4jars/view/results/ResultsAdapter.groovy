package com.ordonteam.home4jars.view.results

import com.ordonteam.home4jars.dto.SearchResults
import com.ordonteam.home4jars.view.common.BaseRecyclerViewAdapter
import com.ordonteam.home4jars.view.results.item.ResultItemAdapter
import com.ordonteam.home4jars.view.results.item.ResultsMapItemAdapter
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
final class ResultsAdapter extends BaseRecyclerViewAdapter {

    void setSearchResults(SearchResults searchResults) {
        items.clear()
        searchResults.items.each {
            items.add(new ResultItemAdapter(it))
        }
        items.add(new ResultsMapItemAdapter(searchResults))
        notifyDataSetChanged()
    }
}