// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();

    $('#usuarios').DataTable();

});

async function cargarUsuarios(){

    const request = await fetch('usuarios',{
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const usuarios = await request.json();

    let listadoHtml = "";

    for(let usuario of usuarios){
        let botonEliminar = '<a href="#" onclick="eliminarUsuario('+usuario.idUsuario+')" class="btn btn-danger btclassNamecle btn-sm"><i class="fas fa-trash"></i> </a>';

        let usuarioHtml =
            '<tr><td>'+ usuario.idUsuario +'</td><td>'+ usuario.nombreUsuario +'</td><td>'+ botonEliminar +'</td></tr>';;

        listadoHtml += usuarioHtml;
    }

    console.log(usuarios);

    document.querySelector('#usuarios tbody').outerHTML = listadoHtml;
}

async function eliminarUsuario(id){

    if(!confirm('¿Desea eliminar este usuario?')){
        return;
    }

    const request = await fetch('api/eliminar-usuario/' +id,{
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    location.reload();
}