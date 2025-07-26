package venpras.tech.controller;

import lombok.Data;
import venpras.tech.enums.BookStatus;

@Data
public class BookRequestUpdateDTO {
    private Long studId;
    private Long bookId;
    private BookStatus status;
    private String comment;

}
