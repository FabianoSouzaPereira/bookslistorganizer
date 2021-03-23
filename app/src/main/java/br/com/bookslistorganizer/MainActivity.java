package br.com.bookslistorganizer;

import android.os.Bundle;

import com.google.android.material.tabs.*;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import java.util.*;

import br.com.bookslistorganizer.ui.main.*;

public class MainActivity extends AppCompatActivity{
   ViewPager viewPager;
   TabLayout tabLayout;
   TabItem tabLibrary;
   TabItem tabBuyBooks;
   TabItem tabStatus;
   
   @Override
   protected void onCreate( Bundle savedInstanceState ){
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_main );
      
      tabLayout = findViewById(R.id.tabLayout);
      tabLibrary = findViewById(R.id.tabLibrary);
      tabBuyBooks = findViewById(R.id.tabBuyBooks);
      tabStatus = findViewById(R.id.tabStatus);
      ViewPager viewPager = findViewById(R.id.viewPager);
      
      PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
      viewPager.setAdapter(pagerAdapter);
      
      tabLayout.addOnTabSelectedListener( new TabLayout.OnTabSelectedListener( ){
         @Override
         public void onTabSelected( TabLayout.Tab tab ){
            viewPager.setCurrentItem(tab.getPosition());
      
         }
   
         @Override
         public void onTabUnselected( TabLayout.Tab tab ){
      
         }
   
         @Override
         public void onTabReselected( TabLayout.Tab tab ){
      
         }
      } );
   }
   
   @Override
   public boolean equals( Object o ){
      if( this == o ){
         return true;
      }
      if( !( o instanceof MainActivity ) ){
         return false;
      }
      MainActivity that = ( MainActivity ) o;
      return Objects.equals( viewPager , that.viewPager ) &&
         Objects.equals( tabLayout , that.tabLayout ) &&
         Objects.equals( tabLibrary , that.tabLibrary ) &&
         Objects.equals( tabBuyBooks , that.tabBuyBooks ) &&
         Objects.equals( tabStatus , that.tabStatus );
   }
   
   @Override
   public int hashCode( ){
      return Objects.hash( viewPager , tabLayout , tabLibrary , tabBuyBooks , tabStatus );
   }
}