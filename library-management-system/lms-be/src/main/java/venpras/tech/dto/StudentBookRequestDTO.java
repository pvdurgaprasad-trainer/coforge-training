package venpras.tech.dto;

import lombok.Data;

import java.util.List;

@Data
public class StudentBookRequestDTO {
    Long studentId; List<Long> bookIds;
}
