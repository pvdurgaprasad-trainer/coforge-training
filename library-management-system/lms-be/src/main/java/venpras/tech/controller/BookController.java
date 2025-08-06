package venpras.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import venpras.tech.dto.BookDTO;
import venpras.tech.dto.ResponseData;
import venpras.tech.exceptions.NoBooksAvailableException;
import venpras.tech.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    public BookService bookService;

    @GetMapping("/books")
    public ResponseData fetchBooks(){
        ResponseData response = new ResponseData();
        try{
            List<BookDTO> books = bookService.getBooks();
            response.setStatus("Success");
            response.setData(books);

        } catch (NoBooksAvailableException e) {
            response.setStatus("Failed");
            response.setMessage(e.getMessage());
        }catch (Exception e) {
            response.setStatus("Failed");
            response.setMessage(e.getMessage());
        }
        return response;
    }

}