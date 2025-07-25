package venpras.tech.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import venpras.tech.controller.StudentRequestDTO;
import venpras.tech.dto.BookDTO;
import venpras.tech.entity.BookEntity;
import venpras.tech.entity.StudentBooksEntity;
import venpras.tech.entity.StudentEntity;
import venpras.tech.enums.BookStatus;
import venpras.tech.exceptions.InvalidBookException;
import venpras.tech.exceptions.NoBooksAvailableException;
import venpras.tech.exceptions.NoRequestsAvailableException;
import venpras.tech.exceptions.StudentNotFoundException;
import venpras.tech.repo.BookRepo;
import venpras.tech.repo.StudentBooksRepo;
import venpras.tech.repo.StudentRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

	@Autowired
	public BookRepo bookRepo;

	@Autowired
	public StudentRepo studentRepo;

	@Autowired
	public StudentBooksRepo studentBooksRepo;

	public List<BookDTO> getBooks() throws NoBooksAvailableException {
		List<BookEntity> bookEntityList = bookRepo.findAll();
		if (null!=bookEntityList && !bookEntityList.isEmpty()) {
			List<BookDTO> books = new ArrayList<>();
			bookEntityList.forEach(e -> {
				BookDTO book = new BookDTO();
				BeanUtils.copyProperties(e, book);
				books.add(book);
			});
			return books;
		} else {
			throw new NoBooksAvailableException("No Books Available.");
		}
	}

	public String requestBooks(Long studentId, List<Long> bookIds) throws StudentNotFoundException, InvalidBookException {
		if(studentId!=null) {
			Optional<StudentEntity> studentEntity = studentRepo.findById(studentId);
			if (!studentEntity.isPresent()) {
				throw new StudentNotFoundException("Student not found");
			} else if(bookIds!=null){
				List<BookEntity> books = bookRepo.findAllById(bookIds);
				if(books.size()!=books.size()) {
					throw new InvalidBookException("Invalid Books Exception");
				}else{
					List<StudentBooksEntity> studentBooks = new ArrayList<>();
					for(Long bookId:bookIds){
						Optional<BookEntity> bookEntity = bookRepo.findById(bookId);
						if(bookEntity.isEmpty()){
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
		}else{
			throw new StudentNotFoundException("Student not found");
		}
		return "Student saved successfully";
	}

	public List<StudentRequestDTO> getStudentBookRequests() throws NoRequestsAvailableException {
		List<StudentBooksEntity> bookRequestsEntityList = studentBooksRepo.findAll();
		if (null!=bookRequestsEntityList && !bookRequestsEntityList.isEmpty()) {
			List<StudentRequestDTO> bookRequests = new ArrayList<>();
			bookRequestsEntityList.forEach(e -> {
				StudentRequestDTO book = new StudentRequestDTO();
				BeanUtils.copyProperties(e, book);
				bookRequests.add(book);
			});
			return bookRequests;
		} else {
			throw new NoRequestsAvailableException("No Books Available.");
		}
	}
}
