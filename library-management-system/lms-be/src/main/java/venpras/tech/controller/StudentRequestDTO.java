package venpras.tech.controller;

import lombok.Data;

@Data
public class StudentRequestDTO {
    private String student;
    private String book;
    private String status;
    private String comment;
}
