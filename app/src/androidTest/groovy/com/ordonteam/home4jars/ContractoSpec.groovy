package com.ordonteam.home4jars

import contracto.Contracto
import spock.lang.Specification

public final class ContractoSpec extends Specification {

    def "Spock example should run and pass"() {
        expect:
        new Contracto().checkContracts([],[])
    }
}
