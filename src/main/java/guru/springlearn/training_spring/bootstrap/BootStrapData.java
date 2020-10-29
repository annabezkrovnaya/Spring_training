package guru.springlearn.training_spring.bootstrap;

import guru.springlearn.training_spring.entity.Author;
import guru.springlearn.training_spring.entity.Book;
import guru.springlearn.training_spring.entity.Publisher;
import guru.springlearn.training_spring.entity.Address;
import guru.springlearn.training_spring.repository.AuthorRepository;
import guru.springlearn.training_spring.repository.BookRepository;
import guru.springlearn.training_spring.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    @Autowired
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,
                         PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    public void run(String... args) throws Exception {

        Author pratchett = new Author("Terry", "Pratchett");
        Book pictures = new Book("Moving Pictures", "111-11-1");

        pratchett.getBooks().add(pictures);
        pictures.getAuthors().add(pratchett);

        authorRepository.save(pratchett);
        bookRepository.save(pictures);

        Author gaiman = new Author("Neil", "Gaiman");
        Book gods = new Book("American Gods", "222-22-2");

        gaiman.getBooks().add(gods);
        gods.getAuthors().add(gaiman);

        authorRepository.save(gaiman);
        bookRepository.save(gods);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());

        Publisher penguin = new Publisher("Penguin Random House");
        Address address = new Address("20 Vauxhall Bridge Rd", "London","SW1V 2SA", "UK");

        penguin.getAddresses().add(address);

        publisherRepository.save(penguin);

        System.out.println("Number of Publishers: " + publisherRepository.count());


    }
}
