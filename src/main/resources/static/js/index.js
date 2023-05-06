function editTodo(button) {
    var id = button.dataset.id;
    // Haz algo con el ID del todo, por ejemplo, redirigir a la página de edición
    window.location.href = "/edit/" + id;
}

function deleteTodo(button) {
    if(confirm("Are you sure?")){
        var id = button.dataset.id;
        var token = $("meta[name='_csrf']").attr("content");
        var header = $("meta[name='_csrf_header']").attr("content");
        var xhr = new XMLHttpRequest();
        xhr.open("DELETE", "/delete/" + id);
        xhr.setRequestHeader(header, token);
        xhr.onreadystatechange = function() {
            if (xhr.readyState === 4 && xhr.status === 200) {
                window.location.href = "/?deleted";
            }
        };
        xhr.send();
    }
}


 var todoForm = document.getElementById('todoForm');
    var todoId = document.getElementById('todoId').value;
    var todoMethod = document.getElementById('todoMethod').value;
    var submitButton = document.getElementById('submitButton');

    if (todoId !== '0') {
        todoForm.action = '/updateTodo/' + todoId;
        todoForm.method = 'PUT';
    }

    submitButton.addEventListener('click', function() {
        if (todoId === '0') {
            todoForm.action = '/saveTodo';
            todoForm.method = 'POST';
        }
    });

