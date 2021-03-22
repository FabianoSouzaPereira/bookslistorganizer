package br.com.bookslistorganizer.ui.main;

import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class PagerAdapter extends FragmentPagerAdapter{
   private final int numOfTabs;
   
   public PagerAdapter( @NonNull FragmentManager fm, int numOfTabs ){
      //noinspection deprecation
      super( fm );
      this.numOfTabs = numOfTabs;
   }
   
   @NonNull
   @Override
   public Fragment getItem( int position ){
      try{
         switch(position){
            case 0 :
               return new LibraryFragment();
            case 1:
               return new BuyBooksFragment();
            case 2:
               return new StatusFragment();
            default:
               return null;
         }
      }catch( Exception e ){
         e.printStackTrace( );
         return null;
      }
   }
   
   @Override
   public int getCount( ){
      return numOfTabs;
   }
}