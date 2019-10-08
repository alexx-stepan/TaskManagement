package com.alexxstepan.taskmanagement.dao.repositories;

import com.alexxstepan.taskmanagement.entities.BaseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository<T extends BaseEntity> extends CrudRepository<T, Long> {
}
