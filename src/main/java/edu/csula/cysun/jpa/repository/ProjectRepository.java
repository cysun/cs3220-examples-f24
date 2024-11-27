package edu.csula.cysun.jpa.repository;

import edu.csula.cysun.jpa.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
}