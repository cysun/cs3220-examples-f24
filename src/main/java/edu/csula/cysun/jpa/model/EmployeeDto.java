package edu.csula.cysun.jpa.model;

public class EmployeeDto {
    private Integer id;

    private String firstName;
    private String lastName;
    private String address;

    private Integer supervisorId;

    public EmployeeDto() {
    }

    public EmployeeDto(Employee e) {
        id = e.getId();
        firstName = e.getFirstName();
        lastName = e.getLastName();
        address = e.getAddress();
        supervisorId = e.getSupervisor() == null ? null : e.getSupervisor().getId();
    }

    public Employee toEmployee() {
        Employee e = new Employee();
        e.setId(id);
        e.setFirstName(firstName);
        e.setLastName(lastName);
        e.setAddress(address);
        if (supervisorId != null) {
            e.setSupervisor(new Employee());
            e.getSupervisor().setId(supervisorId);
        }
        return e;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Integer supervisorId) {
        this.supervisorId = supervisorId;
    }
}
