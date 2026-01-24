package com.example.minor.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime timestamp;   // When the error occurred
    private int status;                // HTTP status code (e.g., 400, 500)
    private String error;              // Short description (e.g., "Bad Request")
    private String message;            // Detailed error message
    private String path;               // The request path that caused the error

}
