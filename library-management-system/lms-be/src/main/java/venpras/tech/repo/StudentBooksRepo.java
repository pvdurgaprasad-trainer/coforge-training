package venpras.tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import venpras.tech.entity.StudentBooksEntity;

import java.util.List;

public interface StudentBooksRepo extends JpaRepository<StudentBooksEntity, Long>{
    List<StudentBooksEntity> findByStudIdAndBookId(Long studentId, Long bookId);
}
