package venpras.tech.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import venpras.tech.entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity, Long>{

}
