package venpras.tech.entity;

import jakarta.persistence.*;
import lombok.Data;
import venpras.tech.enums.BookStatus;

@Entity
@Table(name = "student_books")
@Data
public class StudentBooksEntity extends BaseEntity{

    private Long studId;

    private Long bookId;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    private String comment;
}
