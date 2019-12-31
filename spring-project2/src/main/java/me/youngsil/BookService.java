package me.youngsil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class BookService {

    @Autowired
    List<BookRepository> bookRepository;

    @PostConstruct
    public void setUp() {
        System.out.println(bookRepository.getClass());
    }
}
