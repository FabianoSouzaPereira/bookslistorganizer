package br.com.bookslistorganizer.ui.books;

import androidx.annotation.*;
import androidx.fragment.app.*;
import androidx.viewpager2.adapter.*;

public class PagerAdapter extends FragmentStateAdapter{
   
   public PagerAdapter( @NonNull FragmentActivity fragmentActivity ){
      super( fragmentActivity );
   }
   
   @NonNull
   @Override
   public Fragment createFragment( int position ){
      return InsertFragment.newInstance("" + position, null);
   }
   
   @Override
   public int getItemCount( ){
      return 1;
   }
}
