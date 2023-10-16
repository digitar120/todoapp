package com.digitar120.todoapp.service;

import com.digitar120.todoapp.exception.ToDoExceptions;
import com.digitar120.todoapp.mapper.TaskInDTOToTask;
import com.digitar120.todoapp.persistence.entity.Task;
import com.digitar120.todoapp.persistence.entity.TaskStatus;
import com.digitar120.todoapp.persistence.repository.TaskRepository;
import com.digitar120.todoapp.service.dto.TaskInDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
    // Para esta clase, se usa el estereotipo Service para que se genere un Bean, que a su vez sea indexado para ser utilizado donde se necesite.
public class TaskService {

    // @Autowired
    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    // Inyección de dependencias basada en constructor. Es la buena práctica porque facilita el testeo.
    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO){
        // Aquí se usa un DTO, para mantener simple el traspaso de información
        // Es necesario un mecanismo que convierta la información del DTO en la información de la entidad real. Para ésto se usa un Mapper.
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);
    }

    public List<Task> findAll() {
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus taskStatus){
        return this.repository.findAllByTaskStatus(taskStatus);
    }

    @Transactional
        // ? -- Transactional annotation provides the application the ability to declaratively control transaction boundaries on CDI managed beans
    public void updateTaskFinished(Long id){
        // Denegar una actualización a un ID que no existe.
        Optional<Task> optionalTask = this.repository.findById(id);
        if(optionalTask.isEmpty()) {
            // El ControllerAdvice es una herramienta de Spring para poder manejar en general las excepciones que se lancen.
            throw new ToDoExceptions("Task not found.", HttpStatus.NOT_FOUND);

        }

        this.repository.updateFinishedStatus(id);
    }

    @Transactional
    // ? -- Transactional annotation provides the application the ability to declaratively control transaction boundaries on CDI managed beans
    public void deleteById(Long id){
        // Denegar un borrado a un ID que no existe.
        Optional<Task> optionalTask = this.repository.findById(id);
        if(optionalTask.isEmpty()) {
            // El ControllerAdvice es una herramienta de Spring para poder manejar en general las excepciones que se lancen.
            throw new ToDoExceptions("Task not found.", HttpStatus.NOT_FOUND);

        }

        this.repository.deleteById(id);
    }
}
