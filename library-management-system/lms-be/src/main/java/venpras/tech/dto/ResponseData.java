package venpras.tech.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ResponseData {
    private String status;

    @JsonProperty("error_message")
    private String message;

    private Object data;
}
