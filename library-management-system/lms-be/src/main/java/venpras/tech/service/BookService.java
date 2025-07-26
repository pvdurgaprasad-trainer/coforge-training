package venpras.tech.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import venpras.tech.controller.BookRequestUpdateDTO;
import venpras.tech.dto.StudentBookRequestDTO;
import venpras.tech.dto.BookDTO;
import venpras.tech.entity.BookEntity;
import venpras.tech.entity.StudentBooksEntity;
import venpras.tech.entity.StudentEntity;
import venpras.tech.enums.BookStatus;
import venpras.tech.exceptions.*;
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
}
