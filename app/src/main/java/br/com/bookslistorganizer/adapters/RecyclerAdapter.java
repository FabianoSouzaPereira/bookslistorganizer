package br.com.bookslistorganizer.adapters;

import android.annotation.*;
import android.content.*;
import android.view.*;
import android.widget.*;

import androidx.recyclerview.widget.*;

import java.util.*;

import br.com.bookslistorganizer.*;
import br.com.bookslistorganizer.Models.*;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewholderBooks>
   implements  View.OnClickListener, View.OnTouchListener, View.OnLongClickListener {
   private View.OnClickListener clicklistener;
   private View.OnTouchListener touchListener;
   private View.OnLongClickListener longClickListener;
   private final List<Book> books;
   private Context context;
   
   public RecyclerAdapter( List <Book> books){
      this.books = books;
   }
   
   @Override
   public ViewholderBooks onCreateViewHolder( ViewGroup parent , int viewType ){
      View view = LayoutInflater.from( parent.getContext()).inflate(R.layout.list_item2,parent,false);
      view.setOnClickListener(this);
      view.setOnTouchListener(this);
      view.setOnLongClickListener(this);
      return new ViewholderBooks( view );
   }
   
   @Override
   public void onBindViewHolder( ViewholderBooks viewholder , int position ){
      Book book = books.get( position );
      viewholder.id.setId(book.getCode());
      viewholder.title.setText(book.getTitle());
      viewholder.author.setText(book.getAuthor());
   }
   
   @Override
   public int getItemCount( ){
      return books.size();
   }
   
   public void setOnClickListener(View.OnClickListener clicklistener){
      this.clicklistener = clicklistener;
   }
   public void setOnTouchListener(View.OnTouchListener touchListener){
      this.touchListener = touchListener;
   }
   public void setOnLongClickListener(View.OnLongClickListener longClickListener){
      this.longClickListener = longClickListener;
   }
   
   @Override
   public void onClick( View view ){
      if(clicklistener != null){
         clicklistener.onClick(view);
      }
   }
   
   @Override
   public boolean onLongClick( View view ){
      if(longClickListener != null){
         longClickListener.onLongClick(view);
      }
      return false;
   }
   
   @SuppressLint( "ClickableViewAccessibility" )
   @Override
   public boolean onTouch( View view , MotionEvent motionEvent ){
      if(touchListener != null){
         touchListener.onTouch(view, motionEvent) ;
      }
      return false;
   }
   
   public void removeItem(int position) {
      books.remove(position);
      notifyItemRemoved(position);
   }
   
   public void restoreItem(Book item, int position) {
      books.add(position, item);
      notifyItemInserted(position);
   }
   
   //classe interna ViewholderBook
   public static class ViewholderBooks extends RecyclerView.ViewHolder {
      TextView id;
      TextView title;
      TextView author;
   
      public ViewholderBooks( View itemView ){
         super( itemView );
         id = itemView.findViewById( R.id.tvBookId );
         title = itemView.findViewById( R.id.tvTitle );
         author = itemView.findViewById( R.id.tvAuthor );
      }
   }
   //Fim viewholder
  
}
