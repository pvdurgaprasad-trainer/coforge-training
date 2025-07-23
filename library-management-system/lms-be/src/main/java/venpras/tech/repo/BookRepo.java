package venpras.tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import venpras.tech.entity.BookEntity;

@Repository
public interface BookRepo extends JpaRepository<BookEntity, Integer> {
}
