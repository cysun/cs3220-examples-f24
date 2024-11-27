package edu.csula.cysun.jpa.controller;

import edu.csula.cysun.jpa.model.Employee;
import edu.csula.cysun.jpa.model.Project;
import edu.csula.cysun.jpa.repository.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("projects", projectRepository.findAll());
        return "projects/index";
    }

    @RequestMapping("/{id}")
    public String details(@PathVariable int id, Model model) {
        model.addAttribute("project", projectRepository.findById(id).orElse(null));
        return "projects/details";
    }

    // Note that we use projectId as the name of the path variable instead of id. If we use id,
    // Spring will bind it to the id of the Employee object, and then JPA will think we are
    // updating an existing employee with the id instead of adding a new employee.
    @PostMapping("/{projectId}/addMember")
    public String addMember(@PathVariable int projectId, Employee employee) {
        Project project = projectRepository.findById(projectId).orElse(null);

        if (project != null) {
            project.getMembers().add(employee);
            projectRepository.save(project);
        }

        return "redirect:/projects/" + projectId;
    }

}
