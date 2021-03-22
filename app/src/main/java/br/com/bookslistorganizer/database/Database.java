package br.com.bookslistorganizer.database;

import android.content.*;
import android.database.*;
import android.database.sqlite.*;

import androidx.annotation.*;

import java.util.*;

import br.com.bookslistorganizer.Models.*;

public class Database  extends SQLiteOpenHelper{
   private Book book;
   private static final int DB_VERSION = 1;
   private static final String DB_BOOKS = "db_books";
   private static final String BOOK_TABLE = "tb_book";
   private static final String CODE_COLUMN = "code";
   private static final String TITLE_COLUMN = "title";
   private static final String AUTHOR_COLUMN = "author";
   private static final String ILUSTRATOR_COLUMN = "ilustrator";
   private static final String COVER_COLUMN = "cover";
   private static final String EDITION_COLUMN  = "edition"; // editor /local de edição /data de edição
   private static final String PRINT_COLUMN = "print";
   private static final String FINESHING_COLUMN = "fineshing";
   private static final String DATE_COLUMN = "date";
   private static final String LEGALDEPOSIT_COLUMN = "legaldeposit"; // deposito legal - lei (Portugal)
   private static final String ISBN_COLUMN = "isbn";
   private static final String EMAIL_COLUMN = "email";
   
   private static final String SQL_CREATE_BOOK_TABLE =
      "CREATE TABLE IF NOT EXISTS " + BOOK_TABLE + "(" +
         CODE_COLUMN + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
         TITLE_COLUMN + " TEXT NOT NULL," +
         AUTHOR_COLUMN + " TEXT NOT NULL," +
         ILUSTRATOR_COLUMN + " TEXT NOT NULL," +
         COVER_COLUMN + " TEXT NOT NULL," +
         EDITION_COLUMN + " TEXT NOT NULL," +
         PRINT_COLUMN + " TEXT NOT NULL," +
         FINESHING_COLUMN + " TEXT NOT NULL," +
         DATE_COLUMN + " TEXT NOT NULL," +
         LEGALDEPOSIT_COLUMN + " TEXT NOT NULL," +
         ISBN_COLUMN + " TEXT NOT NULL," +
         EMAIL_COLUMN + " TEXT)";
   
   private static final String[] Bookcol = {
      CODE_COLUMN,
      TITLE_COLUMN,
      AUTHOR_COLUMN,
      ILUSTRATOR_COLUMN,
      COVER_COLUMN,
      EDITION_COLUMN,
      PRINT_COLUMN,
      FINESHING_COLUMN,
      DATE_COLUMN,
      LEGALDEPOSIT_COLUMN,
      ISBN_COLUMN,
      EMAIL_COLUMN
   };
   
   private static final String SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + BOOK_TABLE;
   private static final String SQL_UPDATE_ENTRIES = "UPDATE "  + BOOK_TABLE;
   
   public Database( @Nullable Context context ){
      super( context , DB_BOOKS , null , DB_VERSION );
   }
   
   @Override
   public void onCreate( SQLiteDatabase db ){
      db.execSQL(SQL_CREATE_BOOK_TABLE);
   }
   
   @Override
   public void onUpgrade( SQLiteDatabase sqLiteDatabase , int i , int i1 ){
   }
   
   public void addBook( Book book){
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues values = new ContentValues();
      values.put(CODE_COLUMN,book.getCode());
      values.put(TITLE_COLUMN,book.getTitle());
      values.put(AUTHOR_COLUMN,book.getAuthor());
      values.put(ILUSTRATOR_COLUMN,book.getIlustrator());
      values.put(COVER_COLUMN,book.getCover());
      values.put(EDITION_COLUMN,book.getEdition());
      values.put(PRINT_COLUMN,book.getPrint());
      values.put(FINESHING_COLUMN,book.getFineshing());
      values.put(DATE_COLUMN,book.getDate());
      values.put(LEGALDEPOSIT_COLUMN,book.getLegaldeposit());
      values.put(ISBN_COLUMN,book.getIsbn());
      values.put(EMAIL_COLUMN,book.getEmail());
      db.insert( BOOK_TABLE,null,values );
      db.close();
   }
   
   public Book selectBook(int code){
      SQLiteDatabase db = this.getWritableDatabase();
      Cursor c = db.query(BOOK_TABLE, Bookcol,CODE_COLUMN + " = ?",
         new String[]{String.valueOf(code)},null,null,null,null);
   
      if(c != null){ c.moveToFirst();  }
         Book book = new Book(
            Integer.parseInt( Objects.requireNonNull( c, "0" ).getString( 0 ) ),
            c.getString( 1 ),
            c.getString( 2 ),
            c.getString( 3 ),
            c.getString( 4 ),
            c.getString( 5 ),
            c.getString( 6 ),
            c.getString( 7 ),
            c.getString( 8 ),
            c.getString( 9 ),
            c.getString( 10 ),
            c.getString( 11 )
         );
         c.close();
         db.close();
      
      return book;
   }
   
   public List<Book> listAllBooks(){
      List<Book> books = new ArrayList<>();
      String query = "SELECT * FROM " + BOOK_TABLE;
      SQLiteDatabase db = this.getWritableDatabase();
      Cursor c = db.rawQuery(query,null);
      
      if(c.moveToFirst()){
         do{
            Book book = new Book();
            book.setCode(Integer.parseInt(c.getString(0)));
            book.setTitle(c.getString(1));
            book.setAuthor(c.getString(2));
            book.setIlustrator(c.getString(3));
            book.setCover(c.getString(4));
            book.setEdition(c.getString(5));
            book.setPrint(c.getString(6));
            book.setFineshing(c.getString(7));
            book.setDate(c.getString(8));
            book.setLegaldeposit(c.getString(9));
            book.setIsbn(c.getString(10));
            book.setEmail(c.getString(11));
            books.add(book);
         }while(c.moveToNext());
         c.close();
         db.close();
      }
      return books;
   }
   
   public void updateBook(Book book){
      SQLiteDatabase db = this.getWritableDatabase();
      ContentValues values = new ContentValues();
      values.put(CODE_COLUMN,book.getCode());
      values.put(TITLE_COLUMN,book.getTitle());
      values.put(AUTHOR_COLUMN,book.getAuthor());
      values.put(ILUSTRATOR_COLUMN,book.getIlustrator());
      values.put(COVER_COLUMN,book.getCover());
      values.put(EDITION_COLUMN,book.getEdition());
      values.put(PRINT_COLUMN,book.getPrint());
      values.put(FINESHING_COLUMN,book.getFineshing());
      values.put(DATE_COLUMN,book.getDate());
      values.put(LEGALDEPOSIT_COLUMN,book.getLegaldeposit());
      values.put(ISBN_COLUMN,book.getIsbn());
      values.put(EMAIL_COLUMN,book.getEmail());
      db.update( BOOK_TABLE, values,CODE_COLUMN + " = ?", new String[]{ String.valueOf(book.getCode())});
      db.close();
   }
   
   public void deleteDevice(int code){
      SQLiteDatabase db = this.getWritableDatabase();
      db.delete(BOOK_TABLE,CODE_COLUMN + " = ?", new String[]{ String.valueOf(code)});
      db.close();
   }
}
