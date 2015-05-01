package com.ordonteam.home4jars

import com.ordonteam.home4jars.api.SearchApi
import contracto.Contracto
import spock.lang.Specification

public final class ContractoSpec extends Specification {

    def "ContractoSpec should pass"() {
        given:
        List<Class> apis = [
                SearchApi
        ]
        List<String> urls = [
                'https://raw.githubusercontent.com/WarsawApi/warsaw-api-contracts/master/search.contract.json',
        ]
        expect:
        new Contracto().checkContracts(apis, urls)
    }
}
