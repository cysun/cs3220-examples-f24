package edu.csula.cysun.jpa.controller;

import edu.csula.cysun.jpa.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("employees", employeeRepository.findAll());
        return "employees/index";
    }

    @RequestMapping("/search")
    public String search(String name, Model model) {
        model.addAttribute("employees",
                employeeRepository.findByFirstNameIgnoreCaseOrLastNameIgnoreCase(name, name));
        return "employees/index";
    }

    @RequestMapping("/subordinates")
    public String subordinates(String firstName, String lastName, Model model) {
        model.addAttribute("employees",
                employeeRepository.findSubordiantes(firstName, lastName));
        return "employees/index";
    }
}
