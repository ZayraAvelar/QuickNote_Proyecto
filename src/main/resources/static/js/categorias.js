// Call the dataTables jQuery plugin
$(document).ready(function()  {
    cargarCategorias();

    $('#categorias').DataTable();

});

//muestra las categorias en una tabla
async function cargarCategorias() {
    const request = await fetch('categorias', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const categorias = await request.json();

    let listadoHtml = "";
    for(let categoria of categorias){
        let botonEliminar = '<a href="#" onclick="eliminarCategoria('+categoria.catId+')" class="btn btn-danger btclassNamecle btn-sm"><i class="fas fa-trash"></i> </a>';

        let categoriaHtml = '<tr><td>'+ categoria.catId +'</td><td>'+ categoria.catNombre + '</td><td>'+ botonEliminar +'</td></tr>';

        listadoHtml += categoriaHtml;
    }

    console.log(categorias);

    document.querySelector('#categorias tbody').outerHTML = listadoHtml;

}


//permite eliminar una categoria
async function eliminarCategoria(id){

    if(!confirm('¿Desea eliminar esta categoria?')){
        return;
    }

    const request = await fetch('api/eliminar-categoria/' +id,{
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    location.reload();
}

