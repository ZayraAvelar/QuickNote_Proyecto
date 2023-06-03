// Call the dataTables jQuery plugin
$(document).ready(function() {
    //on ready
});


//verifica que el usuario proporcionado sea correcto
async function iniciarSesion() {

    if((document.getElementById('nombre').value =="admin") && (document.getElementById('contrasena').value=="admin")){
        window.location.href = "notas.html";
    }else{
        alert("El usuario o contraseña son incorrectos");
    }



}