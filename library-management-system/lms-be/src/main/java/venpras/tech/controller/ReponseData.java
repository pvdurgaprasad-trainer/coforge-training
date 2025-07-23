package venpras.tech.controller;

import lombok.Data;

@Data
public class ReponseData {
    private String status;
    private String message;
    private Object data;
}
