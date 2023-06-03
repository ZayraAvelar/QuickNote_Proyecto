// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});

async function añadirUsuario() {
    let datos = {};

    //obtiene el nombre de Usuario
    datos.nombreUsuario = document.getElementById("txtNombre").value;
    //verifica que el nombre de usuario no se encuentre vacio
    if(document.getElementById("txtNombre").value==""){
        alert("Especifica el nombre de usuario");
        return;
    }

    //obtiene la contraseña del usuario
    datos.contraseñaUsuario = document.getElementById("txtContraseña").value;

    //obtiene la contraseña repetida del usuario
    let repetirContraseña = document.getElementById("txtContraseñaRepetir").value;

    //verifica que ambas contraseñas sean iguales
    if(repetirContraseña != datos.contraseñaUsuario){
        alert("La contraseñas son diferentes.");
        return;
    }

    //realiza la ´peticion para guardar el nuevo usuario
    const request = await fetch('api/guardar-usuario',{
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)

    });

    alert("El usuario se ha registrado");


}