package web.springframework.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import web.springframework.spring5webapp.model.Author;
import web.springframework.spring5webapp.model.Book;
import web.springframework.spring5webapp.model.Publisher;
import web.springframework.spring5webapp.repositories.AuthorRepository;
import web.springframework.spring5webapp.repositories.BookRepository;
import web.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric","Evans");
        Publisher harper = new Publisher("Harper Collins", "USA");
        Book ddd = new Book( "Domain Driven Design", "1234", harper);
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        publisherRepository.save(harper);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Johnson");
        Publisher worx = new Publisher("Worx", "USA");
        Book noEJB = new Book( "J2EE Development without EJB", "23444", worx);
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        publisherRepository.save(worx);
        bookRepository.save(noEJB);
    }
}
