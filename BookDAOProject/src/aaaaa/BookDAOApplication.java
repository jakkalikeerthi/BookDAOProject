package aaaaa;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import dao.BookDAO;
import dao.BookDAOimple;
import entity.Book;
import utility.ConnectionFactory;


public class BookDAOApplication {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con= new ConnectionFactory().getConnection();
		BookDAO dao = new BookDAOimple(con);

		while(true) {
			System.out.println("DAO Design pattern Casestudy Example");
			System.out.println("1. Add Book");
			System.out.println("2. List Books");
			System.out.println("3. Search Book");
			System.out.println("4. Update Book");
			System.out.println("5. Delete Book");
			System.out.println("6. Exit");

			System.out.println("Enter choice between(1-6)");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:{
				/*Book bookObj = new Book();
					bookObj.setBookName("Design patterns in Java"); 
					bookObj.setBookAuthor("Herbert scheild");
					bookObj.setBookPrice(530f);*/
				System.out.println("Accpecting book details");
				sc.nextLine();
				System.out.println("Enter book name");
				String bname= sc.nextLine();
				System.out.println("Enter book author");
				String author = sc.nextLine();
				System.out.println("Enter book price");
				float price = sc.nextFloat();
				//Book bookObj = new Book("Design patterns in Java","Herbert scheild",530f);
				Book bookObj=new Book(bname, author, price);
				int rs = dao.addBook(bookObj); 
				if(rs>0) 
					System.out.println("Book Object added sucessfully");
				else
					System.out.println("Failed to add Book object");
				break;
			}
			case 2:{
				System.out.println("\n Listing book details:");
				System.out.println("========================\n");
				List<Book> books = dao.getAllBooks();
				for(Book bObj : books) {
					System.out.print(bObj.getBookID()+"---");
					System.out.print(bObj.getBookName()+"---");
					System.out.print(bObj.getBookAuthor()+"---");
					System.out.println(bObj.getBookPrice());
				}
				System.out.println("========================\n");
				break;
			}
			case 3:{
				System.out.println("Enter Book ID to search the book: ");
				int bookID = sc.nextInt();
				Book book = dao.getBookByID(bookID);
				if(book != null) {
					System.out.print(book.getBookID()+"---");
					System.out.print(book.getBookName()+"---");
					System.out.print(book.getBookAuthor()+"---");
					System.out.println(book.getBookPrice());
				}else
					System.out.println("No record found with this ID...!!!");
				break;
			}
			case 4:{
				System.out.println("Accepting updated book details");
				sc.nextLine();
				System.out.println("Enter the bookId who record you want to be update:");
				int bookID = sc.nextInt();
				sc.nextLine();
				System.out.println("Enter updatedbook name");
				String bname= sc.nextLine();
				System.out.println("Enter updated  book author");
				String author = sc.nextLine();
				System.out.println("Enter updated book price");
				float price = sc.nextFloat();
				Book bookObj=new Book();
			    bookObj.setBookID(bookID);
			    bookObj.setBookName(bname);
			    bookObj.setBookAuthor(author);
			    bookObj.setBookPrice(price);
				int rs = dao.updateBook(bookObj);
				if(rs>0) 
					System.out.println("Book Object updated sucessfully");
				else
					System.out.println("Failed to update Book object");
				break;
			}
            case 5:
            {
            	System.out.println("Enter whose record u want to be delete?");
				sc.nextLine();
				System.out.println("Enter delete bookID");
				int bookID= sc.nextInt();
			
				int rs = dao.deleteBook(bookID); 
				if(rs>0) 
					System.out.println("Book Object deleted sucessfully");
				else
					System.out.println("Failed to deleted Book object");
				break;
        	
            }
            case 6:{
            	 con.close();
            	 System.out.println("T1hank you..!");
            	 System.exit(0);
			}
			default:
				System.out.println("Wrong choice enter try again");
			}		
		}
	}	
}
				
