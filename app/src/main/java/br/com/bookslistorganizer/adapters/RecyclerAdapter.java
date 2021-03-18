package br.com.bookslistorganizer.adapters;

import android.content.*;
import android.view.*;
import android.widget.*;

import androidx.annotation.*;
import androidx.recyclerview.widget.*;

import java.util.*;

import br.com.bookslistorganizer.*;
import br.com.bookslistorganizer.Models.*;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewholderBooks>
   implements  View.OnClickListener, View.OnTouchListener, View.OnLongClickListener {
   private View.OnClickListener clicklistener;
   private View.OnTouchListener touchListener;
   private View.OnLongClickListener longClickListener;
   private List<Book> books;
   private Context context;
   
   public RecyclerAdapter( List <Book> books){
      this.books = books;
   }
   
   public ViewholderBooks onCreateViewHolder(ViewGroup parent, int ViewType){
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item2,parent,false );
      view.setOnClickListener(this);
      view.setOnTouchListener(this);
      view.setOnLongClickListener(this);
      return new ViewholderBooks(view);
   }
   
   @Override
   public void onClick( View view ){
   
   }
   
   @Override
   public boolean onLongClick( View view ){
      return false;
   }
   
   @Override
   public boolean onTouch( View view , MotionEvent motionEvent ){
      return false;
   }
   
   @NonNull
   @Override
   public ViewholderBooks onCreateViewHolder( @NonNull ViewGroup parent , int viewType ){
      return null;
   }
   
   @Override
   public void onBindViewHolder( @NonNull ViewholderBooks holder , int position ){
   
   }
   
   @Override
   public int getItemCount( ){
      return 0;
   }
   
   
   //classe interna ViewholderBook
   public class ViewholderBooks extends RecyclerView.ViewHolder {
      EditText nome;
   
      public ViewholderBooks( @NonNull View itemView ){
         super( itemView );
         nome = itemView.findViewById( R.id.nome );
      }
   }
   //FIm viewholder
  
}
