// Call the dataTables jQuery plugin
$(document).ready(function() {
  window.prueba =5;
  window.idCategoria = 0;
  window.nombreCat = "";
  cargarNotas();

  $('#notas').DataTable();

});

async function cargarNotas(){

  const request = await fetch('notas',{
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const notas = await request.json();



  let listadoHtml = "";

  //obtiene los valores de las notas
  notas.forEach(item =>{
    var id = item[0];
    var nombre = item[1];
    var fecha = item[3];
    var cat = item[4];

    let botonEliminar = '<button href="#" onclick="eliminarNota('+id+')" class="btn btn-danger "><i class="fas fa-trash"></i> </button>';

    let botonModificar = '<button type="button" onclick="cargarNota('+id+')"  class="btn btn-primary " data-toggle="modal" data-target="#exampleModal">\n' +
        ' <i class="fas fa-info-circle"></i> ' +
        '</button>';

    let notaHtml =
        '<tr><td>'+ id +'</td><td>'+ nombre +'</td><td>'+ cat +'</td><td>'+ fecha +
        '</td><td>'+ botonEliminar +"  " +botonModificar +'</td></tr>';

    listadoHtml += notaHtml;

  });


  console.log(notas);

  document.querySelector('#notas tbody').outerHTML = listadoHtml;
}


//permite eliminar una nota de la base de datos
async function eliminarNota(id){

  if(!confirm('¿Desea eliminar esta nota?')){
    return;
  }

  const request = await fetch('api/eliminar-nota/' +id,{
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  location.reload();
}


/**
 * Muestra la informacion de una nota en el formulario
 * @param id
 * @returns {Promise<void>}
 */
async function cargarNota(id) {
  const request = await fetch('nota/'+id, {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  const notaLoad = await request.json();



//se obtienen los datos de la nota
  notaLoad.forEach(item =>{
    var id = item[0];
    var nombre = item[1];
    var descripcion = item[2];
    var fecha = item[3];
    var catId = item[4];
    var catN = item[5];

    window.idCategoria = catId;
    window.nombreCat = catN;


    document.getElementById('selectOpciones').value =catId;

    //se asignan los valores a las cajas de texto
    document.getElementById('idNota').value = id;
    document.getElementById('fechaNota').value = fecha;
    document.getElementById('nombreNota').value = nombre;
    document.getElementById('descNota').value = descripcion;
    //var idCategoria =catId;
    cargarCategorias();

  });

}


/**
 * Permite cargar las categorias en un select
 * @returns {Promise<void>}
 */
async function cargarCategorias(){
    document.getElementById('selectOpciones').options.length = 0;
  const request = await fetch('categorias',{
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });
  const categorias = await request.json();



  //agrega las categorias a el select
  let select = document.getElementById('selectOpciones');
  let option = document.createElement('option');
  option.text = idCategoria +". " +nombreCat ;
  option.value = idCategoria;
  select.add(option);


  console.log(idCategoria);
  for(let categoria of categorias) {
    if (categoria.catId != idCategoria) {

      let option = document.createElement('option');
      option.text = categoria.catId + ". " + categoria.catNombre;
      option.value = categoria.catId;
     select.add(option);
    }
  }

  console.log(categorias);
}


//limpia el select
async function limpiar(){
}


//permite guardar una nota con las modificaciones realizadas
async function guardarNota(){


  let idNota = document.getElementById('idNota').value;
  let nombreNota = document.getElementById('nombreNota').value;
  let fechaNota = document.getElementById('fechaNota').value;
  let catNota = document.getElementById('selectOpciones').value;
  let descNota = document.getElementById('descNota').value;



 const request = await fetch('modificar-nota/'+idNota+'/'+nombreNota+'/'+catNota+'/'+descNota+'/'+fechaNota,{
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
  });
  location.reload();

  alert("Se guardo la nota");


}








