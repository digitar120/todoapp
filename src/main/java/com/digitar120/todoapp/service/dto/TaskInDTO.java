package com.digitar120.todoapp.service.dto;

import com.digitar120.todoapp.persistence.entity.TaskStatus;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
public class TaskInDTO {
    // Tarea de entrada DTO

    // private Long id;
        // No es necesario, se genera automáticamente.
    private String title;
    private String description;
    // private LocalDateTime createDate;
        // Se ingresa al momento que el usuario crea la tarea
    private LocalDateTime eta;
        // "Fecha de finalización"
    // private boolean finished;
        // Por defecto se crea como sin resolver, no es necesario ingresarla
    // private TaskStatus taskStatus;

}
