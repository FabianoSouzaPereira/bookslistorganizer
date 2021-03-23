package br.com.bookslistorganizer.ui.books;

import androidx.arch.core.util.*;
import androidx.lifecycle.*;

public class PageView2Model extends ViewModel{
   private MutableLiveData < Integer > mIndex = new MutableLiveData <>( );
   
   private LiveData < String > mText = Transformations.map( mIndex , new Function < Integer, String >( ){
      @Override
      public String apply( Integer input ){
         return "Hello world from section: " + input;
      }
   } );
   
   public void setIndex( int index ){
      mIndex.setValue( index );
   }
   
   public LiveData < String > getText( ){
      return mText;
   }
}
