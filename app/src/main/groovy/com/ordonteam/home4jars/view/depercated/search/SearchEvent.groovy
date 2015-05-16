package com.ordonteam.home4jars.view.depercated.search

import com.ordonteam.home4jars.service.SearchParams
import groovy.transform.CompileStatic
import groovy.transform.TupleConstructor

@CompileStatic
@TupleConstructor
final class SearchEvent {
    SearchParams searchParams
}
