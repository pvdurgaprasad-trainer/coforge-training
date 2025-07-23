package venpras.tech.entity;

import jakarta.persistence.*;
import lombok.Data;
import venpras.tech.enums.BookStatus;

@Entity
@Table(name = "student_books")
@Data
public class StudentBooks {
    @Id
    private String sbId;

    private String studId;

    private String bookId;

    @Enumerated(EnumType.STRING)
    private BookStatus status;
}
