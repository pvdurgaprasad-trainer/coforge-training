package venpras.tech.repo;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;
import venpras.tech.entity.StudentEntity;

@Transactional
@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {

}
