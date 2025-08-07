package venpras.tech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import venpras.tech.dto.BookRequestUpdateDTO;
import venpras.tech.dto.BookRequestDTO;
import venpras.tech.dto.CancelBookRequestDTO;
import venpras.tech.entity.BookEntity;
import venpras.tech.entity.StudentBooksEntity;
import venpras.tech.entity.StudentEntity;
import venpras.tech.enums.BookStatus;
import venpras.tech.exceptions.BookNotFoundException;
import venpras.tech.exceptions.InvalidBookException;
import venpras.tech.exceptions.NoRequestsAvailableException;
import venpras.tech.exceptions.StudentNotFoundException;
import venpras.tech.repo.BookRepo;
import venpras.tech.repo.StudentBooksRepo;
import venpras.tech.repo.StudentRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentBookRequestService {

    @Autowired
    public BookRepo bookRepo;

    @Autowired
    public StudentRepo studentRepo;

    @Autowired
    public StudentBooksRepo studentBooksRepo;

    public String requestBooks(Long studentId, List<Long> bookIds) throws StudentNotFoundException, InvalidBookException {
        if (studentId != null) {
            Optional<StudentEntity> studentEntity = studentRepo.findById(studentId);
            if (!studentEntity.isPresent()) {
                throw new StudentNotFoundException("Student not found");
            } else if (bookIds != null) {
                List<BookEntity> books = bookRepo.findAllById(bookIds);
                if (books.size() != books.size()) {
                    throw new InvalidBookException("Invalid Books Exception");
                } else {
                    List<StudentBooksEntity> studentBooks = new ArrayList<>();
                    for (Long bookId : bookIds) {
                        Optional<BookEntity> bookEntity = bookRepo.findById(bookId);
                        if (bookEntity.isEmpty()) {
                            StudentBooksEntity entity = new StudentBooksEntity();
                            entity.setBookId(bookEntity.get().getId());
                            entity.setStudId(studentId);
                            entity.setStatus(BookStatus.REQ);
                            studentBooks.add(entity);
                        }
                    }
                    studentBooksRepo.saveAll(studentBooks);
                }
            }
        } else {
            throw new StudentNotFoundException("Student not found");
        }
        return "Student request saved successfully";
    }

    public List<BookRequestDTO> getStudentBookRequests() throws NoRequestsAvailableException {
        List<StudentBooksEntity> bookRequestsEntityList = studentBooksRepo.findAll();
        if (null != bookRequestsEntityList && !bookRequestsEntityList.isEmpty()) {
            bookRequestsEntityList.forEach(System.out::println);
            List<BookRequestDTO> bookRequests = new ArrayList<>();
            bookRequestsEntityList.forEach(e -> {
                BookRequestDTO book = new BookRequestDTO();
                book.setStudId(e.getStudId());
                book.setBookId(e.getBookId());
                bookRequests.add(book);
            });
            return bookRequests;
        } else {
            throw new NoRequestsAvailableException("No Requests Available.");
        }
    }

    public String updateStudentBookRequest(BookRequestUpdateDTO bookRequestUpdate) throws StudentNotFoundException, BookNotFoundException, NoRequestsAvailableException {
        if (bookRequestUpdate.getStudId() != null) {
            if (bookRequestUpdate.getBookId() != null) {
                List<StudentBooksEntity> studentBookRequests = studentBooksRepo.findByStudIdAndBookId(bookRequestUpdate.getStudId(), bookRequestUpdate.getBookId());
                if(studentBookRequests!=null&&!studentBookRequests.isEmpty()){
                    studentBookRequests.forEach(e -> {
                        e.setStatus(bookRequestUpdate.getStatus());
                        e.setComment(bookRequestUpdate.getComment());
                    });
                    studentBooksRepo.saveAll(studentBookRequests);
                }else{
                    throw new NoRequestsAvailableException("No requests available");
                }
            } else {
                throw new BookNotFoundException("Books cannot be empty");
            }
        } else {
            throw new StudentNotFoundException("Student Id cannot be empty");
        }
        return "student request updated";
    }

    public String cancelStudentBookRequest(CancelBookRequestDTO cancelBookRequestDTO) throws StudentNotFoundException, BookNotFoundException, NoRequestsAvailableException {
        if (cancelBookRequestDTO.getStudId() != null) {
            if (cancelBookRequestDTO.getBookId() != null) {
                List<StudentBooksEntity> studentBookRequests = studentBooksRepo.findByStudIdAndBookId(cancelBookRequestDTO.getStudId(), cancelBookRequestDTO.getBookId());
                if (studentBookRequests != null) {
                    studentBooksRepo.deleteAll(studentBookRequests);
                } else {
                    throw new NoRequestsAvailableException("No Requests Available");
                }
            } else {
                throw new BookNotFoundException("Books cannot be empty");
            }
        } else {
            throw new StudentNotFoundException("Student Id cannot be empty");
        }
        return "student request updated";
    }
}
