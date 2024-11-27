@import java.util.List
@import edu.csula.cysun.jpa.model.Employee
@param List<Employee> employees

@template.layout(
title = "Employees",
content = @`
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item active" aria-current="page">Employees</li>
        </ol>
    </nav>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Supervisor</th>
        </tr>
        </thead>
        <tbody>
        @for(var employee : employees)
            <tr>
                <td>${employee.getId()}</td>
                <td>${employee.getName()}</td>
                <td>
                    @if(employee.getSupervisor() != null )
                        ${employee.getSupervisor().getName()}
                    @endif
                </td>
            </tr>
        @endfor
        </tbody>
    </table>
    <div class="row row-cols-1 row-cols-md-2 g-4">
        <div class="col">
            <div class="card h-100">
                <div class="card-header">Search by first name or last name</div>
                <div class="card-body">
                    <form action="/employees/search" method="get">
                        <div class="mb-3">
                            <label for="name" class="form-label">First or last name</label>
                            <input id="name" name="name" type="text" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-primary">Search</button>
                    </form>
                </div>
            </div>
        </div>
        <div class="col">
            <div class="card h-100">
                <div class="card-header">Find the subordinates of an employee</div>
                <div class="card-body">
                    <form action="/employees/subordinates" method="get">
                        <div class="mb-3">
                            <label for="firstName" class="form-label">First Name</label>
                            <input id="firstName" name="firstName" type="text" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label for="lastName" class="form-label">First Name</label>
                            <input id="lastName" name="lastName" type="text" class="form-control">
                        </div>
                        <button type="submit" class="btn btn-primary">Find</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
`)
