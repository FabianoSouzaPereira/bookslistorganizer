package br.com.bookslistorganizer;

import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.*;
import androidx.viewpager.widget.*;
import androidx.viewpager2.widget.*;

import android.os.Bundle;
import android.view.*;

import br.com.bookslistorganizer.ui.books.*;
import br.com.bookslistorganizer.ui.books.PagerAdapter;

public class ManagerBooks extends AppCompatActivity{
   PagerAdapter adapter;
   ViewPager2 viewPager2;
   @Override
   protected void onCreate( Bundle savedInstanceState ){
      super.onCreate( savedInstanceState );
      setContentView( R.layout.activity_manager_books );
      viewPager2 = findViewById(R.id.viewPager2);
      
      adapter = new PagerAdapter(this);
      viewPager2.setAdapter(adapter);

   }

}