package br.com.bookslistorganizer.Models;

public class Book{
 private int mCode = 0;
 private String mTitle = "";
 private String mAuthor = "";
 private String mIlustrator = "";
 private String mCover = "";
 private String mEdition  = ""; // editor /local de edição /data de edição
 private String mPrint = "";
 private String mFineshing = "";
 private String mDate = "";
 private String mLegaldeposit = ""; // deposito legal - lei (Portugal)
 private String mIsbn = "";
 private String mEmail = "";
   
   public Book( ){
   }
   
   public Book( int mCode , String mTitle , String mAuthor , String mIlustrator , String mCover , String mEdition , String mPrint , String mFineshing , String mDate , String mLegaldeposit , String mIsbn , String mEmail ){
      this.mCode = mCode;
      this.mTitle = mTitle;
      this.mAuthor = mAuthor;
      this.mIlustrator = mIlustrator;
      this.mCover = mCover;
      this.mEdition = mEdition;
      this.mPrint = mPrint;
      this.mFineshing = mFineshing;
      this.mDate = mDate;
      this.mLegaldeposit = mLegaldeposit;
      this.mIsbn = mIsbn;
      this.mEmail = mEmail;
   }
   
   public int getCode( ){
      return mCode;
   }
   
   public void setCode( int mCode){
     this.mCode = mCode;
   }
   
   public String getTitle( ){
      return mTitle;
   }
   
   public void setTitle( String mTitle ){
      this.mTitle = mTitle;
   }
   
   public String getAuthor( ){
      return mAuthor;
   }
   
   public void setAuthor( String mAuthor ){
      this.mAuthor = mAuthor;
   }
   
   public String getIlustrator( ){
      return mIlustrator;
   }
   
   public void setIlustrator( String mIlustrator ){
      this.mIlustrator = mIlustrator;
   }
   
   public String getCover( ){
      return mCover;
   }
   
   public void setCover( String mCover ){
      this.mCover = mCover;
   }
   
   public String getEdition( ){
      return mEdition;
   }
   
   public void setEdition( String mEdition ){
      this.mEdition = mEdition;
   }
   
   public String getPrint( ){
      return mPrint;
   }
   
   public void setPrint( String mPrint ){
      this.mPrint = mPrint;
   }
   
   public String getFineshing( ){
      return mFineshing;
   }
   
   public void setFineshing( String mFineshing ){
      this.mFineshing = mFineshing;
   }
   
   public String getDate( ){
      return mDate;
   }
   
   public void setDate( String mDate ){
      this.mDate = mDate;
   }
   
   public String getLegaldeposit( ){
      return mLegaldeposit;
   }
   
   public void setLegaldeposit( String mLegaldeposit ){
      this.mLegaldeposit = mLegaldeposit;
   }
   
   public String getIsbn( ){
      return mIsbn;
   }
   
   public void setIsbn( String mIsbn ){
      this.mIsbn = mIsbn;
   }
   
   public String getEmail( ){
      return mEmail;
   }
   
   public void setEmail( String mEmail ){
      this.mEmail = mEmail;
   }
}
