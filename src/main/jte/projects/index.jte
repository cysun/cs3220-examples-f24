@import java.util.List
@import edu.csula.cysun.jpa.model.Project
@param List<Project> projects

@template.layout(
title = "Projects",
content = @`
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item active" aria-current="page">Projects</li>
        </ol>
    </nav>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Leader</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        @for(var project : projects)
            <tr>
                <td>${project.getId()}</td>
                <td>${project.getName()}</td>
                <td>${project.getLeader().getName()}</td>
                <td><a href="/projects/${project.getId()}">Details</a></td>
            </tr>
        @endfor
        </tbody>
    </table>
`)