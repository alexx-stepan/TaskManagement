package com.alexxstepan.taskmanagement.dao.services;

import com.alexxstepan.taskmanagement.dao.repositories.ProjectRepository;
import com.alexxstepan.taskmanagement.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectService {

	@Autowired private ProjectRepository projectRepository;

	public Optional<Project> getProjectById(long projectId) {
		return projectRepository.findById(projectId);
	}
}
