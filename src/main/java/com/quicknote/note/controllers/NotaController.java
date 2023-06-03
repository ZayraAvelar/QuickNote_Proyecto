package com.quicknote.note.controllers;

import com.quicknote.note.dao.NotaDAO;
import com.quicknote.note.models.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

public class NotaController implements NotaDAO{

    @Autowired
    private NotaDAO notaDao;

    /**
     * Retorna la lista de notas
     * @return
     */
    @Override
    @RequestMapping(value ="notas")
    public List<Nota> getNotas(){
        return notaDao.getNotas();
    }


    /**
     * Permite eliminar una nota mediante su id
     * @param id
     */
    @RequestMapping(value = "api/eliminar-nota/{id}", method=RequestMethod.DELETE)
        public void eliminarNota(@PathVariable int id){
            notaDao.eliminarNota(id);
        }


    /**
     * Permite guardar una nota y recibe como parametros todos los datos de la nota
      * @param nombre
     * @param categoria
     * @param descripcion
     * @param fecha
     */
    @RequestMapping(value = "guardar-nota/{nombre}/{categoria}/{descripcion}/{fecha}", method = RequestMethod.POST)
    public void guardarNota(@PathVariable String nombre, @PathVariable int categoria, @PathVariable String descripcion, @PathVariable String fecha) {
        notaDao.guardarNota(nombre, categoria, descripcion, fecha);
    }


    /**
     * Permite obtener una nota mediante su id
     * @param id
     * @return
     */
    @RequestMapping(value = "nota/{id}", method = RequestMethod.GET)
    public List<Nota> getNota(@PathVariable int id){
        return notaDao.getNota(id);
    }


    /**
     * Permite modificar una nota  y recibe como parametros los nuevos datos
     * @param idNota
     * @param nombreNota
     * @param catNota
     * @param descNota
     * @param fechaNota
     */
    @RequestMapping(value = "modificar-nota/{idNota}/{nombreNota}/{catNota}/{descNota}/{fechaNota}", method = RequestMethod.POST)
    public void modificarNota(@PathVariable int idNota, @PathVariable String nombreNota, @PathVariable int catNota, @PathVariable String descNota, @PathVariable String fechaNota){
        notaDao.modificarNota(idNota, nombreNota,catNota,descNota,fechaNota);
    }






}
