package venpras.tech.dto;

import lombok.Data;

@Data
public class BookRequestDTO {
    private Long studId;
    private Long bookId;
    private String status;
    private String comment;
}
