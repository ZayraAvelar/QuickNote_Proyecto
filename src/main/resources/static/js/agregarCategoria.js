// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});

async function añadirCategoria() {
    let datos = {};
    datos.catNombre = document.getElementById("txtNombreCat").value;
    //verifica que el nombre de la categoria no se encuentre vacio
    if(document.getElementById("txtNombreCat").value==""){
        alert("Especifica el nombre de usuario.");
        return;
    }

    //realiza la ´peticion para guardar la nueva categoria
    const request = await fetch('api/registrar-categoria',{
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)

    });
    alert("La categoria ha sido agregada");
    const categorias = await request.json();

}