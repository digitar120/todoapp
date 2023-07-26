package com.digitar120.todoapp.controller;

import com.digitar120.todoapp.persistence.entity.Task;
import com.digitar120.todoapp.persistence.entity.TaskStatus;
import com.digitar120.todoapp.service.TaskService;
import com.digitar120.todoapp.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")
    // Conviene que los endpoints para ésta clase de cosas se escriba en plural.
public class TaskController {
    // La capa de controlador sólo debe comunicarse con la capa de servicio.

    private final TaskService taskService;
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findAll(){
        return this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllByTaskStatus(@PathVariable("status") TaskStatus status){
        return this.taskService.findAllByTaskStatus(status);
    }


    @PatchMapping("/mark_as_finished/{id}")
        // @PatchMapping es un método HTTP especializado en tareas de actualización.
    public ResponseEntity<Void> markAsFinished(@PathVariable("id") Long id){
        this.taskService.updateTaskFinished(id);

        // Es conveniente incluir una respuesta HTTP para que el consumidor de la API esté al tanto de la respuesta del programa.
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    // @PatchMapping es un método HTTP especializado en tareas de actualización.
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        this.taskService.deleteById(id);

        // Es conveniente incluir una respuesta HTTP para que el consumidor de la API esté al tanto de la respuesta del programa.
        return ResponseEntity.noContent().build();
    }
}
