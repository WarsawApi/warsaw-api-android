package com.ordonteam.home4jars.functional

import static com.ordonteam.home4jars.functional.helper.Checker.checkIfViewWithTextIsDisplayed

public final class FunctionalExampleTestCase extends BaseInstrumentationTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp()
        getActivity()
    }

    public void testIsHelloWorldDisplayed() {
        checkIfViewWithTextIsDisplayed("Metro")
    }

}
