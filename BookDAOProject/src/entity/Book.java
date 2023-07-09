package entity;

public class Book {
	private int bookID; 
	   private String bookName;
	   private String bookAuthor;
	   private float bookPrice;
	   public Book(){
	   		
	   	}
		public Book(String bookName, String bookAuthor, float bookPrice) {
			super();
			this.bookName = bookName;
			this.bookAuthor = bookAuthor;
			this.bookPrice = bookPrice;
		}
		
			public int getBookID() {
			return bookID;
		}
			public void setBookID(int bookID) {
				this.bookID = bookID;
			}


			public String getBookName() {
				return bookName;
			}


			public void setBookName(String bookName) {
				this.bookName = bookName;
			}
			public String getBookAuthor() {
				return bookAuthor;
			}
			public void setBookAuthor(String bookAuthor) {
				this.bookAuthor = bookAuthor;
			}
			public float getBookPrice() {
				return bookPrice;
			}
			public void setBookPrice(float bookPrice) {
				this.bookPrice = bookPrice;
			}   	  
		}