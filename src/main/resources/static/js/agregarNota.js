// Call the dataTables jQuery plugin
$(document).ready(function() {
    mostrarCategorias();

});


//permite agregar una nueva nota a la base de datos
async function añadirNota(){
    //valida que los datos de las cajas de texto
    let nombreNota = document.getElementById('txtNombre').value;
        if(document.getElementById("txtNombre").value==""){
            alert("Especifica el nombre de la nota");
            return;
     }

    //valida los datos
    let descNota = document.getElementById('txtDescripcion').value;
    if(document.getElementById("txtDescripcion").value==""){
        alert("Especifica la descripcion de la nota");
        return;
    }

    let catId = document.getElementById('mySelect').value;
    var fechaActual = new Date();
    var dia = fechaActual.getDate();
    var mes = fechaActual.getMonth() + 1; // Los meses en JavaScript se indexan desde 0, por lo que sumamos 1
    var año = fechaActual.getFullYear();

// Añadir un cero inicial si el día o mes es menor a 10
    if (dia < 10) {
        dia = '0' + dia;
    }

    if (mes < 10) {
        mes = '0' + mes;
    }

    var fechaNota = año + "-" + mes + "-" + dia;

    const request = await fetch('guardar-nota/'+nombreNota+'/'+catId+'/'+descNota+'/'+fechaNota,{
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });
    const notas = await request.json();
    alert("La nota ha sido agregada");

}


//muestra las categorias en un select
async function mostrarCategorias(){
    const request = await fetch('categorias', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    const categorias = await request.json();

    let select = document.getElementById("mySelect");
    for(let categoria of categorias){
        let option = document.createElement("option");
        option.text = categoria.catId + ". "+categoria.catNombre;
        option.value = categoria.catId;
        select.add(option);
    }

    console.log(categorias);

}


async function obtenerCategoria(id) {
    const request = await fetch('categoria/', {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });

    const categoria = await request.json();
}



