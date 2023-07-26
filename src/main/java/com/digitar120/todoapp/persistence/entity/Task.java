package com.digitar120.todoapp.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Data
    // Notación de Lombok que genera getters y setters
public class Task {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime eta;
        // "Fecha de finalización"
    private boolean finished;
    private TaskStatus taskStatus;
}
