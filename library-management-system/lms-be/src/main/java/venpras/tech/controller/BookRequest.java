package venpras.tech.controller;

import lombok.Data;

import java.util.List;

@Data
public class BookRequest {
    Long studentId; List<Long> bookIds;
}
