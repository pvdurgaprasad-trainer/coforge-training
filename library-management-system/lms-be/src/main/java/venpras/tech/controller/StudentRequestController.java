package venpras.tech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import venpras.tech.dto.*;
import venpras.tech.exceptions.NoRequestsAvailableException;
import venpras.tech.service.StudentBookRequestService;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentRequestController {

    @Autowired
    public StudentBookRequestService studentBookRequestService;


    @GetMapping("/requests")
    public ResponseData fetchBookRequests(){
        ResponseData response = new ResponseData();
        try{
            List<BookRequestDTO> books = studentBookRequestService.getStudentBookRequests();
            response.setStatus("Success");
            response.setData(books);
        } catch (NoRequestsAvailableException e) {
            response.setStatus("Failed");
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @PostMapping("/request/add")
    public ResponseData addStudentRequests(@RequestBody StudentBookRequestDTO bookRequest) {
        ResponseData response = new ResponseData();
        try{
            String message = studentBookRequestService.requestBooks(bookRequest.getStudentId(),bookRequest.getBookIds());
            response.setStatus("Success");
            response.setData(message);
        } catch (Exception e) {
            response.setStatus("Failed");
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @PostMapping("/request/update")
    public ResponseData updateStudentRequest(@RequestBody BookRequestUpdateDTO bookRequestUpdate ){
        ResponseData response = new ResponseData();
        try{
            String message = studentBookRequestService.updateStudentBookRequest(bookRequestUpdate);
            response.setStatus("Success");
            response.setData(message);
        } catch (Exception e) {
            response.setStatus("Failed");
            response.setMessage(e.getMessage());
        }
        return response;
    }

    @PostMapping("/request/cancel")
    public ResponseData cancelStudentRequest(@RequestBody CancelBookRequestDTO cancelBookRequestDTO ){
        ResponseData response = new ResponseData();
        try{
            String message = studentBookRequestService.cancelStudentBookRequest(cancelBookRequestDTO);
            response.setStatus("Success");
            response.setData(message);
        } catch (Exception e) {
            response.setStatus("Failed");
            response.setMessage(e.getMessage());
        }
        return response;
    }
}