package sp.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import sp.bookstore.domain.Book;
import sp.bookstore.domain.BookRepository;
import sp.bookstore.domain.Category;
import sp.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			
			log.info("save a couple of categories");
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Classics"));
			crepository.save(new Category("Autobiography"));
			
			log.info("save a couple of books");
			repository.save(new Book("George Orwell", "Animal Farm", "1212121-1", 1945, crepository.findByName("Fiction").get(0)));
			repository.save(new Book("Ernest Hemingway", "A Farewell to Arms", "21212121-1", 1929, crepository.findByName("Classics").get(0)));	
			repository.save(new Book("Phil Collins", "Not Dead yet", "3232332-1", 2016, crepository.findByName("Autobiography").get(0)));

		};
	}
}
