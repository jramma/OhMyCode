function editTodo(button) {
    var id = button.dataset.id;
    // Haz algo con el ID del todo, por ejemplo, redirigir a la página de edición
    window.location.href = "/edit/" + id;
}

function deleteTodo(button) {
    if(confirm("Are you sure?")){
     var id = button.dataset.id;
     window.location.href = "/deleteTodo/"+id;

     };
}



