package venpras.tech.repo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import venpras.tech.entity.StudentBooksEntity;

import java.util.List;

@Repository
@Transactional
public interface StudentBooksRepo extends JpaRepository<StudentBooksEntity, Long> {
    List<StudentBooksEntity> findByStudIdAndBookId(Long studentId, Long bookId);
}
