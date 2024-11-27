package edu.csula.cysun.jpa.repository;

import edu.csula.cysun.jpa.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    List<Employee> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(String firstName, String lastName);

    @Query("select e from Employee e where e.supervisor.firstName = ?1 and e.supervisor.lastName = ?2")
    List<Employee> findSubordiantes(String firstName, String lastName);
}
