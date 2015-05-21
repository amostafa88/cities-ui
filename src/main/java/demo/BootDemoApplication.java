package demo;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class BootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootDemoApplication.class, args);
    }
    
}

@Component
class BookCommandLineRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
		for(Book b : this.booksRepostiory.findAll()){
			System.out.println(b.toString());
		}
		
	}
	
	@Autowired BooksRepository booksRepostiory;
}

//===================
interface BooksRepository extends JpaRepository<Book, Long>{
	Collection<Book> findByBookName(String name);
}

//===================
@Entity
class Book{
	
	@Id
	@GeneratedValue
	private long bookId;
	
	private String bookName;

	public Book() {
		super();
	}

	public Book(String bookName) {
		super();
		this.bookName = bookName;
	}

	public long getBookId() {
		return bookId;
	}

	public String getBookName() {
		return bookName;
	}

	@Override
	public String toString() {
		return "Booking [bookId=" + bookId + ", bookName=" + bookName + "]";
	}
	
}

//============

@RestController
class BooksController {
	
	@RequestMapping("/books")
    Collection<Book> home() {
        return this.booksRepostiory.findAll();
    }
	
	@Autowired BooksRepository booksRepostiory;
}