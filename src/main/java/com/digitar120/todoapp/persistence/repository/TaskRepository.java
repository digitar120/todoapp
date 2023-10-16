package com.digitar120.todoapp.persistence.repository;

import com.digitar120.todoapp.persistence.entity.Task;
import com.digitar120.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAllByTaskStatus(TaskStatus status);

    // Ejecutar una consulta nativa, en este caso un UPDATE, a través de JPA.
    @Modifying
        // "Esto es una query de actualización"
    @Query(value="UPDATE TASK SET FINISHED=true WHERE ID=:id", nativeQuery = true)
    public void updateFinishedStatus(@Param("id") Long id);
}
