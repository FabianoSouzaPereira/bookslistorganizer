package br.com.bookslistorganizer.ui.main;

import android.content.*;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.*;

import com.google.android.material.floatingactionbutton.*;

import org.jetbrains.annotations.*;

import java.util.*;

import br.com.bookslistorganizer.*;
import br.com.bookslistorganizer.Models.*;
import br.com.bookslistorganizer.adapters.*;
import br.com.bookslistorganizer.database.*;

/**
 * A placeholder fragment containing a simple view.
 */
public class LibraryFragment extends Fragment{
   private Context context;
   Database db;
   private RecyclerView mRvBooksAcervo;
   private RecyclerAdapter mAdapter;
   private RecyclerView.LayoutManager layoutManager;
   private final ArrayList< Book > books = new ArrayList <>();
   private static final String ARG_SECTION_NUMBER = "section_number";
   private PageViewModel pageViewModel;
   
   public static LibraryFragment newInstance( int index ){
      LibraryFragment fragment = new LibraryFragment( );
      Bundle bundle = new Bundle( );
      bundle.putInt( ARG_SECTION_NUMBER , index );
      fragment.setArguments( bundle );
      return fragment;
   }
   
   @Override
   public void onAttach( @NotNull Context context) {
      this.context = context;
      db = new Database(context);
      super.onAttach(context);
   }
   
   @Override
   public void onCreate( Bundle savedInstanceState ){
      super.onCreate( savedInstanceState );
      pageViewModel = new ViewModelProvider( this ).get( PageViewModel.class );
      int index = 1;
      if( getArguments( ) != null ){
         index = getArguments( ).getInt( ARG_SECTION_NUMBER );
      }
      pageViewModel.setIndex( index );

   }
   
   @Override
   public View onCreateView(
      @NonNull LayoutInflater inflater , ViewGroup container ,
      Bundle savedInstanceState ){
      View root = inflater.inflate( R.layout.library_main , container , false );
      mRvBooksAcervo = root.findViewById(R.id.rvBooksAcervo);
      FloatingActionButton addBook = root.findViewById(R.id.btn_Addbook);
      addBook.setOnClickListener( new View.OnClickListener( ){
         @Override
         public void onClick( View view ){
            Intent intent = new Intent(getContext(), ManagerBooks.class);
            String insert = "Insert";
            intent.putExtra( "Title", insert );
            startActivity(intent);
//            root.getContext().getSupportFragmentManager()
//               .beginTransaction()
//               .add(R.id.content_login, new RegisterFragment ())
//               .addToBackStack (null)
//               .commit ();
         }
      } );
      readData();
      return root;
   }
   
   /** Load Books from DB */
   private void readData( ){
      final ArrayList<Book> books = new ArrayList <>();
      List<Book> bk = db.listAllBooks();
         for(Book b : bk){
            books.add( b );
         }
      List<Book> bookslist = books;
      mRvBooksAcervo.setHasFixedSize(true);
      layoutManager = new LinearLayoutManager(getContext());
      mRvBooksAcervo.setLayoutManager(layoutManager);
      mAdapter = new RecyclerAdapter(bookslist);
      mRvBooksAcervo.setAdapter(mAdapter);
   }
}