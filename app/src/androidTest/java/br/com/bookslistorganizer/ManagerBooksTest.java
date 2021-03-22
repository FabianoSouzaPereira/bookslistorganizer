package br.com.bookslistorganizer;

import android.content.*;

import androidx.test.ext.junit.runners.*;
import androidx.test.platform.app.*;

import org.junit.*;
import org.junit.runner.*;

import static org.junit.Assert.assertEquals;


@RunWith( AndroidJUnit4.class )
public class ManagerBooksTest{
   @Test
   public void useAppContext( ){
      // Context of the app under test.
      Context appContext = InstrumentationRegistry.getInstrumentation( ).getTargetContext( );
      assertEquals( "br.com.bookslistorganizer" , appContext.getPackageName( ) );
   }
}