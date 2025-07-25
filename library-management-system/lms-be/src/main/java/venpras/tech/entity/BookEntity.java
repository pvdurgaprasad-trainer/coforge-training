package venpras.tech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "books")
@Data
public class BookEntity extends BaseEntity{
    private String title;

    private String author;
}
