package br.com.bookslistorganizer;


import android.view.*;

import androidx.test.core.app.*;
import androidx.test.espresso.*;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.*;
import androidx.test.rule.*;
import androidx.test.runner.*;

import org.hamcrest.Description;
import org.hamcrest.*;
import org.junit.*;
import org.junit.runner.*;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.*;

@LargeTest
@RunWith( AndroidJUnit4.class )
public class MainActivityTest{
   
   /**
    * Use {@link ActivityScenario} to create and launch of the activity.
    */
   @Before
   public void launchActivity() {
      ActivityScenario.launch(MainActivity.class);
   }
   
   @Test
   public void mainActivityTest( ){
      ViewInteraction floatingActionButton = onView(
         allOf( withId( R.id.btn_Addbook ) , withContentDescription( "Buttom Add Book" ) ,
            childAtPosition(
               allOf( withId( R.id.constraintLayout ) ,
                  withParent( withId( R.id.viewPager ) ) ) ,
               1 ) ,
            isDisplayed( ) ) );
      floatingActionButton.perform( click( ) );
      
      // Library Fragment
      ViewInteraction textInputEditText1 = onView(
         allOf( withId( R.id.tiTitle ) ,
            childAtPosition(
               childAtPosition(
                  withId( R.id.ftTitle_input ) ,
                  0 ) ,
               0 ) ) );
      textInputEditText1.perform( scrollTo( ) , replaceText( "Livro 1" ) , closeSoftKeyboard( ) );
      textInputEditText1.perform( pressImeActionButton( ) );
      
      ViewInteraction textInputEditText2 = onView(
         allOf( withId( R.id.tiAuthor ) ,
            childAtPosition(
               childAtPosition(
                  withId( R.id.ftAuthor_input ) ,
                  0 ) ,
               0 ) ) );
      textInputEditText2.perform( scrollTo( ) , replaceText( "Autor 1" ) , closeSoftKeyboard( ) );
      textInputEditText2.perform( pressImeActionButton( ) );
      
      ViewInteraction textInputEditText3 = onView(
         allOf( withId( R.id.tiIlustrator ) ,
            childAtPosition(
               childAtPosition(
                  withId( R.id.ftIlustrator_input ) ,
                  0 ) ,
               0 ) ) );
      textInputEditText3.perform( scrollTo( ) , replaceText( "Ilustrador 1" ) , closeSoftKeyboard( ) );
      textInputEditText3.perform( pressImeActionButton( ) );
      
      ViewInteraction textInputEditText4 = onView(
         allOf( withId( R.id.tiCover ) ,
            childAtPosition(
               childAtPosition(
                  withId( R.id.ftCover_input ) ,
                  0 ) ,
               0 ) ) );
      textInputEditText4.perform( scrollTo( ) , replaceText( "Cover 1" ) , closeSoftKeyboard( ) );
      textInputEditText4.perform( pressImeActionButton( ) );
      
      ViewInteraction textInputEditText5 = onView(
         allOf( withId( R.id.tiEdition ) ,
            childAtPosition(
               childAtPosition(
                  withId( R.id.ftEdition_input ) ,
                  0 ) ,
               0 ) ) );
      textInputEditText5.perform( scrollTo( ) , replaceText( "Edition 1" ) , closeSoftKeyboard( ) );
      textInputEditText5.perform( pressImeActionButton( ) );
      
      ViewInteraction textInputEditText6 = onView(
         allOf( withId( R.id.tiPrint ) ,
            childAtPosition(
               childAtPosition(
                  withId( R.id.ftPrint_input ) ,
                  0 ) ,
               0 ) ) );
      textInputEditText6.perform( scrollTo( ) , replaceText( "EUA" ) , closeSoftKeyboard( ) );
      textInputEditText6.perform( pressImeActionButton( ) );
      
      ViewInteraction textInputEditText7 = onView(
         allOf( withId( R.id.tiFineshing ) ,
            childAtPosition(
               childAtPosition(
                  withId( R.id.ftFineshing_input ) ,
                  0 ) ,
               0 ) ) );
      textInputEditText7.perform( scrollTo( ) , replaceText( "Atlanta Printer" ) , closeSoftKeyboard( ) );
      textInputEditText7.perform( pressImeActionButton( ) );
      
      ViewInteraction textInputEditText8 = onView(
         allOf( withId( R.id.tiDate ) ,
            childAtPosition(
               childAtPosition(
                  withId( R.id.ftDate_input ) ,
                  0 ) ,
               0 ) ) );
      textInputEditText8.perform( scrollTo( ) , replaceText( "02/02/1990" ) , closeSoftKeyboard( ) );
      textInputEditText8.perform( pressImeActionButton( ) );
      
      ViewInteraction textInputEditText9 = onView(
         allOf( withId( R.id.tiLegaldeposit ) ,
            childAtPosition(
               childAtPosition(
                  withId( R.id.ftLegaldeposit_input ) ,
                  0 ) ,
               0 ) ) );
      textInputEditText9.perform( scrollTo( ) , replaceText( "sim" ) , closeSoftKeyboard( ) );
      textInputEditText9.perform( pressImeActionButton( ) );
      
      ViewInteraction textInputEditText10 = onView(
         allOf( withId( R.id.tiIsbn ) ,
            childAtPosition(
               childAtPosition(
                  withId( R.id.ftIsbn_input ) ,
                  0 ) ,
               0 ) ) );
      textInputEditText10.perform( scrollTo( ) , replaceText( "isbn" ) , closeSoftKeyboard( ) );
      textInputEditText10.perform( pressImeActionButton( ) );
      
      ViewInteraction materialButton = onView(
         allOf( withId( R.id.btn_Addbook ) , withText( "Save" ) ,
            childAtPosition(
               childAtPosition(
                  withClassName( is( "android.widget.LinearLayout" ) ) ,
                  10 ) ,
               1 ) ) );
      materialButton.perform( scrollTo( ) , click( ) );
   }
   
   private static Matcher < View > childAtPosition(
      final Matcher < View > parentMatcher , final int position ){
      
      return new TypeSafeMatcher < View >( ){
         @Override
         public void describeTo( Description description ){
            description.appendText( "Child at position " + position + " in parent " );
            parentMatcher.describeTo( description );
         }
         
         @Override
         public boolean matchesSafely( View view ){
            ViewParent parent = view.getParent( );
            return parent instanceof ViewGroup && parentMatcher.matches( parent )
               && view.equals( ( ( ViewGroup ) parent ).getChildAt( position ) );
         }
      };
   }
}
