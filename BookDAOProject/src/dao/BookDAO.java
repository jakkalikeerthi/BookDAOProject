package dao;

import java.util.List;

import entity.Book;

public interface BookDAO {
	public List<Book> getAllBooks();
	public Book getBookByID(int bookID);
	public int deleteBook(int bookID);
	public int updateBook(Book book);
	public int addBook(Book book);
}
