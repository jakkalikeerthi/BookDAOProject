package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import entity.Book;

public class BookDAOimple implements BookDAO {
	private Connection con;
	int rs;
		
	public BookDAOimple(Connection con) {
		this.con = con;
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		List<Book> books = null;
		try {
			books = new ArrayList<>();
				Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from book");
			while(rs.next()) {
				Book bObj = new Book();
				bObj.setBookID(rs.getInt("bookID"));
				bObj.setBookName(rs.getString("name"));
				bObj.setBookAuthor(rs.getString("author"));
				bObj.setBookPrice(rs.getFloat("price"));
				
				//adding book Object in collection
				books.add(bObj);
			}
		} catch (Exception e) {
			throw new RuntimeException("Error:"+e);
		}
		return books;
	}

	@Override
	public Book getBookByID(int bookID) {
		// TODO Auto-generated method stub
		Book bObj=null;
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from book where bookID = ?");
			pstmt.setInt(1, bookID);
			ResultSet rs = pstmt.executeQuery(); 
			if(rs.next()) {
				bObj = new Book();
				bObj.setBookID(rs.getInt("bookID"));
				bObj.setBookName(rs.getString("name"));
				bObj.setBookAuthor(rs.getString("author"));
				bObj.setBookPrice(rs.getFloat("price"));
			}
		} catch (Exception e) {
			throw new RuntimeException("Error : "+e);
		}
		return bObj;
		
	}
	@Override
	public int deleteBook(int bookID) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement pstmt = con.prepareStatement("Delete from book where bookID=?");
			pstmt.setInt(1, bookID);
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error : "+e);
		}
		return rs;
	}

	@Override
	public int updateBook(Book book) {
		try {
			PreparedStatement psmt=con.prepareStatement("update book set name=?,author=?,price=? where bookID=?");
		       psmt.setString(1,book.getBookName());
			   psmt.setString(2,book.getBookAuthor());
			   psmt.setFloat(3,book.getBookPrice());
			   psmt.setInt(4, book.getBookID());
			   rs = psmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException("Error : "+e);
		}
		return rs;
	}
	@Override
	public int addBook(Book book) {
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into book(name, author, price) values(?,?,?)");
			pstmt.setString(1, book.getBookName());
			pstmt.setString(2, book.getBookAuthor());
			pstmt.setFloat(3, book.getBookPrice());
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return rs;
	}

}
