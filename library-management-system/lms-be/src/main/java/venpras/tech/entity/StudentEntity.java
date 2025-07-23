package venpras.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="students")
@Data
public class StudentEntity {
    @Id
    private String studId;

    private String name;
}
