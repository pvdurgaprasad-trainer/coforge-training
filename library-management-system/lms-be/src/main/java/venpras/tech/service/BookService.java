package venpras.tech.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import venpras.tech.entity.BookEntity;
import venpras.tech.exceptions.NoBooksAvailableException;
import venpras.tech.repo.BookRepo;
import venpras.tech.dto.BookDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    public BookRepo bookRepo;

    public List<BookDTO> getBooks() throws NoBooksAvailableException {
        List<BookEntity> bookEntityList = bookRepo.findAll();
        if(bookEntityList!=null&&!bookEntityList.isEmpty()){
            List<BookDTO> books = new ArrayList<>();
            bookEntityList.forEach(e->{
                BookDTO book = new BookDTO();
                BeanUtils.copyProperties(e,book);
                books.add(book);
            });
            return books;
        }else{
            throw new NoBooksAvailableException("No Books Available.");
        }
    }
}
