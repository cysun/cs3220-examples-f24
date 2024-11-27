@template.layout(
title = "GuestBook - Add Comment",
content = @`
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/guestbook">GuestBook</a></li>
            <li class="breadcrumb-item active" aria-current="page">Add Comment</li>
        </ol>
    </nav>
    <form method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input id="name" name="name" type="text" class="form-control">
        </div>
        <div class="mb-3">
            <label for="message" class="form-label">Message</label>
            <textarea id="message" name="message" class="form-control" rows="3"></textarea>
        </div>
        <button type="submit" class="btn btn-primary">Add Comment</button>
    </form>
`)
