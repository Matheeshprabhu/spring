package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author pauloCoelho = new Author("Paulo", "Coelho");
        Book alchemist = new Book("The Alchemist", "123");

        pauloCoelho.getBooks().add(alchemist);
        alchemist.getAuthors().add(pauloCoelho);

        Author charlesDickens = new Author("Charles", "Dickens");
        Book oliverTwist = new Book("Oliver twist", "213");

        charlesDickens.getBooks().add(oliverTwist);
        oliverTwist.getAuthors().add(charlesDickens);

        authorRepository.save(pauloCoelho);
        authorRepository.save(charlesDickens);
        bookRepository.save(alchemist);
        bookRepository.save(oliverTwist);

        System.out.println("The counts of authors and books are - ");
        System.out.println(authorRepository.count());
        System.out.println(bookRepository.count());






    }
}
