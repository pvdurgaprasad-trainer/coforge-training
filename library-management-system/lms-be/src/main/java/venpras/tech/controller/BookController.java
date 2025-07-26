package venpras.tech.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import venpras.tech.dto.BookDTO;
import venpras.tech.exceptions.NoBooksAvailableException;
import venpras.tech.exceptions.NoRequestsAvailableException;
import venpras.tech.service.BookService;

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
            response.setData(e.getMessage());
        }
        return response;
    }

    @GetMapping("/requests")
    public ResponseData fetchBookRequests(){
        ResponseData response = new ResponseData();
        try{
            List<StudentRequestDTO> books = bookService.getStudentBookRequests();
            response.setStatus("Success");
            response.setData(books);
        } catch (NoRequestsAvailableException e) {
            response.setStatus("Failed");
            response.setData(e.getMessage());
        }
        return response;
    }
    
    @PostMapping("/student/request")
    public ResponseData addStudentRequests(@RequestBody BookRequest bookRequest) {
        System.out.println("studentId-->"+bookRequest.getStudentId());
        bookRequest.getBookIds().forEach(System.out::println);
        return null;
    }

}
/*
ResponseData response = new ResponseData();
        try{
            String message = bookService.requestBooks(bookRequest.studentId,bookRequest.bookIds);
            response.setStatus("Success");
            response.setMessage(message);
        } catch (Exception e) {
            response.setStatus("Failed");
            response.setData(e.getMessage());
        }
        return response;
* */