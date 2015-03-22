package com.ordonteam.functional.helper;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public final class Checker {

    public static void checkIfViewWithTextIsDisplayed(String text) {
        onView(withText(text)).check(matches(isDisplayed()));
    }
}
