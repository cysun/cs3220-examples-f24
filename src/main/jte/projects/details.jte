@import edu.csula.cysun.jpa.model.Project
@import gg.jte.support.ForSupport
@param Project project

@template.layout(
title = "Project Details",
content = @`
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/projects">Projects</a></li>
            <li class="breadcrumb-item active" aria-current="page">${project.getName()}</li>
        </ol>
    </nav>
    <table class="table">
        <tr>
            <th>Id</th>
            <td>${project.getId()}</td>
        </tr>
        <tr>
            <th>Name</th>
            <td>${project.getName()}</td>
        </tr>
        <tr>
            <th>Leader</th>
            <td>${project.getLeader().getName()}</td>
        </tr>
        <tr>
            <th>Members</th>
            <td>
                @for(var member : ForSupport.of(project.getMembers()))
                    ${member.get().getName()}@if(!member.isLast()), @endif
                @endfor
            </td>
        </tr>
    </table>
    <p>Add a member to the project. A new employee record will be created (to demonstrate cascading save).</p>
    <form action="/projects/${project.getId()}/addMember" method="post">
        <div class="row g-3">
            <div class="col">
                <input name="firstName" type="text" class="form-control" placeholder="First name">
            </div>
            <div class="col">
                <input name="lastName" type="text" class="form-control" placeholder="Last name">
            </div>
            <div class="col">
                <button type="submit" class="btn btn-primary">Add Member</button>
            </div>
        </div>
    </form>
`)