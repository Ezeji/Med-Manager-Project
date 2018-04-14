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
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class DocumentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void documentTest() {
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.email_provider), withText("Sign in with email"),
                        withParent(withId(R.id.btn_holder)),
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.email), isDisplayed()));
        appCompatEditText.perform(replaceText("franklinezeji@gmail.com"), closeSoftKeyboard());

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.button_ok), withText("Next"), isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.password), isDisplayed()));
        appCompatEditText2.perform(replaceText("softwaredeveloper"), closeSoftKeyboard());

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.button_done), withText("Next"), isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.edit_text1),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatEditText3.perform(replaceText("Procold"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.edit_text2),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatEditText4.perform(replaceText("For pnemonia patients"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.edit_text3),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatEditText5.perform(replaceText("Once daily"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.edit_text4),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatEditText6.perform(replaceText("5th April, 2018"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.edit_text5),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatEditText7.perform(replaceText("5th May, 2018"), closeSoftKeyboard());

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.submit_button), withText("Submit"),
                        withParent(allOf(withId(R.id.activity_main),
                                withParent(withId(android.R.id.content)))),
                        isDisplayed()));
        appCompatButton4.perform(click());

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

        ViewInteraction linearLayoutCompat = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.action_bar),
                                childAtPosition(
                                        withId(R.id.action_bar_container),
                                        0)),
                        1),
                        isDisplayed()));
        linearLayoutCompat.check(matches(isDisplayed()));

        ViewInteraction imageView = onView(
                allOf(withContentDescription("More options"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.action_bar),
                                        1),
                                0),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

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
                allOf(childAtPosition(
                        allOf(withId(android.R.id.content),
                                childAtPosition(
                                        withId(R.id.decor_content_parent),
                                        1)),
                        0),
                        isDisplayed()));
        relativeLayout.check(matches(isDisplayed()));

        ViewInteraction radioGroup = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        0),
                        isDisplayed()));
        radioGroup.check(matches(isDisplayed()));

        ViewInteraction radioButton = onView(
                allOf(withId(R.id.R_button13),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        0),
                                0),
                        isDisplayed()));
        radioButton.check(matches(isDisplayed()));

        ViewInteraction radioButton2 = onView(
                allOf(withId(R.id.R_button14),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        0),
                                1),
                        isDisplayed()));
        radioButton2.check(matches(isDisplayed()));

        ViewInteraction radioGroup2 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        1),
                        isDisplayed()));
        radioGroup2.check(matches(isDisplayed()));

        ViewInteraction radioButton3 = onView(
                allOf(withId(R.id.R_button11),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        1),
                                0),
                        isDisplayed()));
        radioButton3.check(matches(isDisplayed()));

        ViewInteraction radioButton4 = onView(
                allOf(withId(R.id.R_button12),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        1),
                                1),
                        isDisplayed()));
        radioButton4.check(matches(isDisplayed()));

        ViewInteraction radioGroup3 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        2),
                        isDisplayed()));
        radioGroup3.check(matches(isDisplayed()));

        ViewInteraction radioButton5 = onView(
                allOf(withId(R.id.R_button9),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        2),
                                0),
                        isDisplayed()));
        radioButton5.check(matches(isDisplayed()));

        ViewInteraction radioButton6 = onView(
                allOf(withId(R.id.R_button10),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        2),
                                1),
                        isDisplayed()));
        radioButton6.check(matches(isDisplayed()));

        ViewInteraction radioGroup4 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        3),
                        isDisplayed()));
        radioGroup4.check(matches(isDisplayed()));

        ViewInteraction radioButton7 = onView(
                allOf(withId(R.id.R_button7),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        3),
                                0),
                        isDisplayed()));
        radioButton7.check(matches(isDisplayed()));

        ViewInteraction radioButton8 = onView(
                allOf(withId(R.id.R_button8),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        3),
                                1),
                        isDisplayed()));
        radioButton8.check(matches(isDisplayed()));

        ViewInteraction radioGroup5 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        4),
                        isDisplayed()));
        radioGroup5.check(matches(isDisplayed()));

        ViewInteraction radioButton9 = onView(
                allOf(withId(R.id.R_button5),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        4),
                                0),
                        isDisplayed()));
        radioButton9.check(matches(isDisplayed()));

        ViewInteraction radioButton10 = onView(
                allOf(withId(R.id.R_button6),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        4),
                                1),
                        isDisplayed()));
        radioButton10.check(matches(isDisplayed()));

        ViewInteraction radioGroup6 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        5),
                        isDisplayed()));
        radioGroup6.check(matches(isDisplayed()));

        ViewInteraction radioButton11 = onView(
                allOf(withId(R.id.R_button3),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        5),
                                0),
                        isDisplayed()));
        radioButton11.check(matches(isDisplayed()));

        ViewInteraction radioButton12 = onView(
                allOf(withId(R.id.R_button4),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        5),
                                1),
                        isDisplayed()));
        radioButton12.check(matches(isDisplayed()));

        ViewInteraction radioGroup7 = onView(
                allOf(childAtPosition(
                        childAtPosition(
                                withId(android.R.id.content),
                                0),
                        6),
                        isDisplayed()));
        radioGroup7.check(matches(isDisplayed()));

        ViewInteraction radioButton13 = onView(
                allOf(withId(R.id.R_button1),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        6),
                                0),
                        isDisplayed()));
        radioButton13.check(matches(isDisplayed()));

        ViewInteraction radioButton14 = onView(
                allOf(withId(R.id.R_button2),
                        childAtPosition(
                                childAtPosition(
                                        IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class),
                                        6),
                                1),
                        isDisplayed()));
        radioButton14.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withText("DAY1:"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                7),
                        isDisplayed()));
        textView2.check(matches(withText("DAY1:")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.record_drug), withText("Record Drug Intake(Yes/No)"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                8),
                        isDisplayed()));
        textView3.check(matches(withText("Record Drug Intake(Yes/No)")));

        ViewInteraction textView4 = onView(
                allOf(withText("DAY2:"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                9),
                        isDisplayed()));
        textView4.check(matches(withText("DAY2:")));

        ViewInteraction textView5 = onView(
                allOf(withText("DAY3:"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                10),
                        isDisplayed()));
        textView5.check(matches(withText("DAY3:")));

        ViewInteraction textView6 = onView(
                allOf(withText("DAY4:"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                11),
                        isDisplayed()));
        textView6.check(matches(withText("DAY4:")));

        ViewInteraction textView7 = onView(
                allOf(withText("DAY5:"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                12),
                        isDisplayed()));
        textView7.check(matches(withText("DAY5:")));

        ViewInteraction textView8 = onView(
                allOf(withText("DAY6:"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                13),
                        isDisplayed()));
        textView8.check(matches(withText("DAY6:")));

        ViewInteraction textView9 = onView(
                allOf(withText("DAY7:"),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                14),
                        isDisplayed()));
        textView9.check(matches(withText("DAY7:")));

        ViewInteraction button = onView(
                allOf(withId(R.id.send_button),
                        childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                15),
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
