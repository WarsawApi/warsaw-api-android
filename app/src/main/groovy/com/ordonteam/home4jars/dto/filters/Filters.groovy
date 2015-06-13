package com.ordonteam.home4jars.dto.filters

import groovy.transform.CompileStatic

@CompileStatic
final class Filters {
    Filter price = new Filter()
    Filter measurement = new Filter()
    Filter rooms = new Filter()
}