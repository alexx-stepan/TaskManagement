package com.alexxstepan.taskmanagement.dao.repositories;


import com.alexxstepan.taskmanagement.entities.Task;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends ApplicationRepository<Task> {
}
