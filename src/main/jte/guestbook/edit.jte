@import edu.csula.cysun.jpa.model.GuestBookEntry
@param GuestBookEntry entry

@template.layout(
title = "GuestBook - Edit Entry",
content = @`
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/guestbook">GuestBook</a></li>
            <li class="breadcrumb-item active" aria-current="page">Edit Entry</li>
        </ol>
    </nav>
    <form method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input id="name" name="name" type="text" class="form-control" value="${entry.getName()}">
        </div>
        <div class="mb-3">
            <label for="message" class="form-label">Message</label>
            <textarea id="message" name="message" class="form-control" rows="3">${entry.getMessage()}</textarea>
        </div>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
`)