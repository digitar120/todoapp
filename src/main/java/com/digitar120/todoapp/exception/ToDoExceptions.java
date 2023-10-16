package com.digitar120.todoapp.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

// Hay dos tipos de excepciones: chequeadas y no chequeadas. Las chequeadas, en la firma de un método (?), incluye su nombre.
// Para las excepciones no chequeadas, se extiende desde RuntimeException
@Data
public class ToDoExceptions extends RuntimeException{
    private String message;
    private HttpStatus httpStatus;

    public ToDoExceptions(String message, HttpStatus httpStatus) {
        super(message);
        // Sobreescribir el método RuntimeException()
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
