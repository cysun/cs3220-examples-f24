package edu.csula.cysun.jpa.controller;

import edu.csula.cysun.jpa.model.Employee;
import edu.csula.cysun.jpa.model.EmployeeDto;
import edu.csula.cysun.jpa.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeApiController {
    private final EmployeeRepository employeeRepository;

    public EmployeeApiController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("")
    public List<EmployeeDto> index() {
        List<EmployeeDto> employees = new ArrayList<EmployeeDto>();
        for (Employee e : employeeRepository.findAll())
            employees.add(new EmployeeDto(e));
        return employees;
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployee(@PathVariable int id) {
        Employee e = employeeRepository.findById(id).orElse(null);
        if (e == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");

        return new EmployeeDto(e);
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer addEmployee(@RequestBody EmployeeDto input) {
        Employee e = employeeRepository.save(input.toEmployee());
        return e.getId();
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployee(@PathVariable int id, @RequestBody Map<String, Object> update) {
        Employee e = employeeRepository.findById(id).orElse(null);
        if (e == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");

        for (String key : update.keySet()) {
            switch (key) {
                case "firstName":
                    e.setFirstName((String) update.get(key));
                    break;
                case "lastName":
                    e.setLastName((String) update.get(key));
                    break;
                case "address":
                    e.setAddress((String) update.get(key));
                    break;
            }
        }
        employeeRepository.save(e);
    }
}
