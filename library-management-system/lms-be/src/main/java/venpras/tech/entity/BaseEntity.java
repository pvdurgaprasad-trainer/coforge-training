package venpras.tech.entity;

import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Random;

@Data
@MappedSuperclass
public abstract class BaseEntity {
    @Id
    private Long id;

    public void generateId() {
        this.id = new Random().nextLong();
    }
}
