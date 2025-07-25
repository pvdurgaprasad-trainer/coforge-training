package venpras.tech.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import venpras.tech.entity.BookEntity;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Long> {


}
