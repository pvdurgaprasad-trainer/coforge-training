package venpras.tech.controller;

import lombok.Data;

@Data
public class ResponseData {
    private String status;
    private String message;
    private Object data;
}
