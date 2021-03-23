package br.com.bookslistorganizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.*;
import android.os.Bundle;
import android.util.*;
import android.widget.*;

import java.util.*;

import br.com.bookslistorganizer.ui.books.*;

public class ManagerBooks extends AppCompatActivity{
   
   private static String tbTitle = "ManagerBooks";

   @Override
   protected void onCreate( Bundle savedInstanceState ){
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_manager_books );
      setTitle(tbTitle);

      Intent intent = getIntent();
      tbTitle = intent.getStringExtra("Title");
      
      if( tbTitle.equals( "Insert" ) ){
         try{
            Toast.makeText( this , "Title is equals insert." , Toast.LENGTH_SHORT ).show( );
            getSupportFragmentManager().beginTransaction()
               .add(R.id.viewPager2, new InsertFragment())
               .commit();
         }catch( Exception e ){
            e.printStackTrace( );
         }
      }
   }
   
   public void setPageTitle( String title){
      tbTitle = title;
   }
   
   @Override
   public boolean equals( Object o ){
      if( this == o ){
         return true;
      }
      if( !( o instanceof ManagerBooks ) ){
         return false;
      }
      ManagerBooks that = ( ManagerBooks ) o;
      return Objects.equals( tbTitle, tbTitle );
   }
   
   @Override
   public int hashCode( ){
      return Objects.hash( tbTitle );
   }
}