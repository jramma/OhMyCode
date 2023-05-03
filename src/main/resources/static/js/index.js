$(document).ready(function() {
  // obtener los datos de la API Java
  $.ajax({
    url: 'http://localhost:8080/toDos',
    dataType: 'json',
    success: function(data) {
      // agregar los datos a la tabla
      var table = $('#myTable').DataTable({
        data: data,
        columns: [
          { data: 'columna1' },
          { data: 'columna2' },
          { data: 'columna3' },
          { data: 'columna4' }
        ],
        // agregar paginación a la tabla
        paging: true,
        pageLength: 10
      });
    }
  });
});
