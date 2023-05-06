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


    // Obtener el formulario y el campo _method
    const todoForm = document.getElementById('todoId');
    const methodField = todoForm.querySelector('input[name="_method"]');

    // Agregar un evento al formulario que actualiza el valor del campo _method
    todoForm.addEventListener('submit', function(event) {
        if (todoForm.elements.id.value != 0) {
            methodField.value = 'PUT';
            todoForm.action = '/updateTodo/' + todoForm.elements.id.value;
        } else {
            methodField.value = 'POST';
            todoForm.action = '/saveTodo';
        }
    });


