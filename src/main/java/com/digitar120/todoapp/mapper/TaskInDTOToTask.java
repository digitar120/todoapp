package com.digitar120.todoapp.mapper;

import com.digitar120.todoapp.persistence.entity.Task;
import com.digitar120.todoapp.persistence.entity.TaskStatus;
import com.digitar120.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
    // Facilita la inyección en una clase.
public class TaskInDTOToTask implements IMapper<TaskInDTO, Task>{

    @Override
    public Task map(TaskInDTO in){
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());

        // Deben también inicializarse los otros componentes que no aparecen en el DTO:
        task.setCreateDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
