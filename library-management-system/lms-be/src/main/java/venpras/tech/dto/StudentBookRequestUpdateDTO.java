package venpras.tech.dto;

import lombok.Data;

@Data
public class StudentBookRequestUpdateDTO {
    private String student;
    private String book;
    private String status;
    private String comment;
}
