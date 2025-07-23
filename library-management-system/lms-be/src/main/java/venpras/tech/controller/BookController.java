package venpras.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import venpras.tech.dto.BookDTO;
import venpras.tech.enums.BookStatus;
import venpras.tech.exceptions.NoBooksAvailableException;
import venpras.tech.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    public BookService bookService;

    @GetMapping("/")
    public ReponseData fetchBooks(){
        ReponseData response = new ReponseData();
        try{
            List<BookDTO> books = bookService.getBooks();
            response.setStatus("Success");
            response.setData(books);
        } catch (NoBooksAvailableException e) {
            response.setStatus("Failed");
            response.setData(e.getMessage());
        }
        return response;
    }

}
