package com.in28minutes.rest.webservices.restfulwebservices.exception;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorModel {
    private LocalDateTime timestamp;
    private String message;
    private String details;
}
