package com.alexxstepan.taskmanagement.dao.repositories;

import com.alexxstepan.taskmanagement.entities.TaskUpdate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskUpdateRepository extends ApplicationRepository<TaskUpdate> {

	List<TaskUpdate> findByRelatedTaskId(long relatedTaskId);
}
