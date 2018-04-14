package com.example.franklinezeji.med_manager;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.email_provider), withText("Sign in with email"),
                        withParent(withId(R.id.btn_holder)),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.email), isDisplayed()));
        appCompatEditText.perform(replaceText(""), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.email), isDisplayed()));
        appCompatEditText2.perform(replaceText("franklinezeji@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.button_ok), withText("Next"), isDisplayed()));
        appCompatButton2.perform(click());

        pressBack();

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.password), isDisplayed()));
        appCompatEditText3.perform(replaceText("softwaredeveloper"), closeSoftKeyboard());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.button_done), withText("Next"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction viewGroup = onView(
                allOf(withId(R.id.decor_content_parent),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        viewGroup.check(matches(isDisplayed()));

        ViewInteraction frameLayout = onView(
                allOf(withId(R.id.action_bar_container),
                        childAtPosition(
                                allOf(withId(R.id.decor_content_parent),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                                0)),
                                0),
                        isDisplayed()));
        frameLayout.check(matches(isDisplayed()));

        ViewInteraction viewGroup2 = onView(
                allOf(withId(R.id.action_bar),
                        childAtPosition(
                                allOf(withId(R.id.action_bar_container),
                                        childAtPosition(
                                                withId(R.id.decor_content_parent),
                                                0)),
                                0),
                        isDisplayed()));
        viewGroup2.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withText("Med-Manager"),
                        childAtPosition(
                                allOf(withId(R.id.action_bar),
                                        childAtPosition(
                                                withId(R.id.action_bar_container),
                                                0)),
                                0),
                        isDisplayed()));
        textView.check(matches(withText("Med-Manager")));

        ViewInteraction frameLayout2 = onView(
                allOf(withId(android.R.id.content),
                        childAtPosition(
                                allOf(withId(R.id.decor_content_parent),
                                        childAtPosition(
                                                IsInstanceOf.<View>instanceOf(android.widget.FrameLayout.class),
                                                0)),
                                1),
                        isDisplayed()));
        frameLayout2.check(matches(isDisplayed()));

        ViewInteraction relativeLayout = onView(
                allOf(withId(R.id.activity_main),
                        childAtPosition(
                                allOf(withId(android.R.id.content),
                                        childAtPosition(
                                                withId(R.id.decor_content_parent),
                                                1)),
                                0),
                        isDisplayed()));
        relativeLayout.check(matches(isDisplayed()));

        ViewInteraction view = onView(
                allOf(withId(R.id.drug_image1),
                        childAtPosition(
                                allOf(withId(R.id.activity_main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                0),
                        isDisplayed()));
        view.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.medication), withText("Medication \n Information"),
                        childAtPosition(
                                allOf(withId(R.id.activity_main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                1),
                        isDisplayed()));
        textView2.check(matches(withText("Medication   Information")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.name), withText("Name:"),
                        childAtPosition(
                                allOf(withId(R.id.activity_main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                2),
                        isDisplayed()));
        textView3.check(matches(withText("Name:")));

        ViewInteraction editText = onView(
                allOf(withId(R.id.edit_text1),
                        childAtPosition(
                                allOf(withId(R.id.activity_main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                3),
                        isDisplayed()));
        editText.check(matches(withText("")));

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.description), withText("Description:"),
                        childAtPosition(
                                allOf(withId(R.id.activity_main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                4),
                        isDisplayed()));
        textView4.check(matches(withText("Description:")));

        ViewInteraction editText2 = onView(
                allOf(withId(R.id.edit_text2),
                        childAtPosition(
                                allOf(withId(R.id.activity_main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                5),
                        isDisplayed()));
        editText2.check(matches(withText("")));

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.interval), withText("Interval:"),
                        childAtPosition(
                                allOf(withId(R.id.activity_main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                6),
                        isDisplayed()));
        textView5.check(matches(withText("Interval:")));

        ViewInteraction editText3 = onView(
                allOf(withId(R.id.edit_text3),
                        childAtPosition(
                                allOf(withId(R.id.activity_main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                7),
                        isDisplayed()));
        editText3.check(matches(withText("")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.start_date_), withText("Start Date:"),
                        childAtPosition(
                                allOf(withId(R.id.activity_main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                8),
                        isDisplayed()));
        textView6.check(matches(withText("Start Date:")));

        ViewInteraction editText4 = onView(
                allOf(withId(R.id.edit_text4),
                        childAtPosition(
                                allOf(withId(R.id.activity_main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                9),
                        isDisplayed()));
        editText4.check(matches(withText("")));

        ViewInteraction textView7 = onView(
                allOf(withId(R.id.end_date_), withText("End Date:"),
                        childAtPosition(
                                allOf(withId(R.id.activity_main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                10),
                        isDisplayed()));
        textView7.check(matches(withText("End Date:")));

        ViewInteraction editText5 = onView(
                allOf(withId(R.id.edit_text5),
                        childAtPosition(
                                allOf(withId(R.id.activity_main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                11),
                        isDisplayed()));
        editText5.check(matches(withText("")));

        ViewInteraction button = onView(
                allOf(withId(R.id.submit_button),
                        childAtPosition(
                                allOf(withId(R.id.activity_main),
                                        childAtPosition(
                                                withId(android.R.id.content),
                                                0)),
                                12),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
