package br.com.bookslistorganizer.ui.books;

import android.os.Bundle;

import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.*;

import android.util.*;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.*;

import br.com.bookslistorganizer.*;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InsertFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InsertFragment extends Fragment{
   PagerAdapter mAdapter;
   ViewPager2 mViewPager2;
  
   // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
   private static final String ARG_PARAM1 = "param1";
   private static final String ARG_PARAM2 = "param2";

   private String mParam1;
   private String mParam2;
   
   public InsertFragment( ){
      // Required empty public constructor
   }
   
   /**
    * Use this factory method to create a new instance of
    * this fragment using the provided parameters.
    *
    * @param param1 Parameter 1.
    * @param param2 Parameter 2.
    * @return A new instance of fragment InsertFragment.
    */
   public static InsertFragment newInstance( String param1 , String param2 ){
      Log.i("static--------------", "new Instance InsertFragment" );
      InsertFragment fragment = new InsertFragment( );
      Bundle args = new Bundle( );
      args.putString( ARG_PARAM1 , param1 );
      args.putString( ARG_PARAM2 , param2 );
      fragment.setArguments( args );
      return fragment;
   }
   
   @Override
   public void onCreate( Bundle savedInstanceState ){
      super.onCreate( savedInstanceState );
      Log.i("onCreate -> ", "InsertFragment" );
     // (( ManagerBooks ) getActivity()).setTitle("Insert");
      if( getArguments( ) != null ){
         mParam1 = getArguments( ).getString( ARG_PARAM1 );
         mParam2 = getArguments( ).getString( ARG_PARAM2 );
      }
   }
   
   @Override
   public View onCreateView( LayoutInflater inflater , ViewGroup container ,
      Bundle savedInstanceState ){
      View view = inflater.inflate( R.layout.fragment_insert , container , false );
      return view;
   }
   
   @Override
   public void onActivityCreated( @Nullable Bundle savedInstanceState ){
      super.onActivityCreated( savedInstanceState );
      mAdapter = new PagerAdapter(getActivity());
      mViewPager2.setAdapter(mAdapter);
   }
}