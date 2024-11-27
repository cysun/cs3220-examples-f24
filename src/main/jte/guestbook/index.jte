@import java.util.List
@import edu.csula.cysun.jpa.model.GuestBookEntry
@param List<GuestBookEntry> entries

@template.layout(
title = "GuestBook",
content = @`
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb">
            <li class="breadcrumb-item active" aria-current="page">GuestBook</li>
        </ol>
    </nav>
    <table class="table align-middle">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Message</th>
            <th></th>
        </tr>
        @for(var entry : entries)
            <tr data-id="${entry.getId()}">
                <td>${entry.getId()}</td>
                <td>${entry.getName()}</td>
                <td>${entry.getMessage()}</td>
                <td><a href="guestbook/edit/${entry.getId()}" class="btn btn-sm btn-primary">Edit</a>
                    <a data-id="${entry.getId()}" href="javascript:void(0)"
                       class="delete btn btn-sm btn-danger ms-2">Delete</a>
                </td>
            </tr>
        @endfor
    </table>
    <a href="guestbook/add" class="btn btn-primary">Add Comment</a>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
            crossorigin="anonymous"></script>
    <script>
        $(function () {
            $(".delete").click(function () {
                var id = $(this).attr("data-id");
                $.ajax({
                    url: "guestbook/delete/" + id,
                    method: "DELETE",
                    success: function (result) {
                        if (result)
                            $("tr[data-id='" + id + "']").remove();
                    }
                });
            });
        });
    </script>
`)
