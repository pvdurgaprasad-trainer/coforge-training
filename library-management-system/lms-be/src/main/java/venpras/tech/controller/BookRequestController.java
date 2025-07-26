package venpras.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import venpras.tech.dto.BookRequestDTO;
import venpras.tech.dto.ResponseData;
import venpras.tech.dto.StudentBookRequestDTO;
import venpras.tech.exceptions.NoRequestsAvailableException;
import venpras.tech.service.StudentBookRequestService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRequestController {

    @Autowired
    public StudentBookRequestService studentBookRequestService;


    @GetMapping("/book/requests")
    public ResponseData fetchBookRequests(){
        ResponseData response = new ResponseData();
        try{
            List<BookRequestDTO> books = studentBookRequestService.getStudentBookRequests();
            response.setStatus("Success");
            response.setData(books);
        } catch (NoRequestsAvailableException e) {
            response.setStatus("Failed");
            response.setData(e.getMessage());
        }
        return response;
    }

    @PostMapping("/student/request")
    public ResponseData addStudentRequests(@RequestBody StudentBookRequestDTO bookRequest) {
        ResponseData response = new ResponseData();
        try{
            String message = studentBookRequestService.requestBooks(bookRequest.getStudentId(),bookRequest.getBookIds());
            response.setStatus("Success");
            response.setMessage(message);
        } catch (Exception e) {
            response.setStatus("Failed");
            response.setData(e.getMessage());
        }
        return response;
    }

    @PostMapping("/student/request/update")
    public ResponseData updateStudentRequest(@RequestBody BookRequestUpdateDTO bookRequestUpdate ){
        ResponseData response = new ResponseData();
        try{
            String message = studentBookRequestService.updateStudentBookRequest(bookRequestUpdate);
            response.setStatus("Success");
            response.setMessage(message);
        } catch (Exception e) {
            response.setStatus("Failed");
            response.setData(e.getMessage());
        }
        return response;
    }

}