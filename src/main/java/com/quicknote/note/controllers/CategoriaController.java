package com.quicknote.note.controllers;

import com.quicknote.note.dao.CategoriaDAO;
import com.quicknote.note.models.Categoria;
import com.quicknote.note.models.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

public class CategoriaController implements CategoriaDAO {


    @Autowired
    private CategoriaDAO categoriaDao;

    /**
     * Obtiene las categorias
     * @return
     */
    @Override
    @RequestMapping(value = "categorias")
    public List<Categoria> getCategorias(){
        return categoriaDao.getCategorias();
    }


    /**
     * Permite resgitrar una categoria y sirve como parametro un objeto de tipo categoria
     * @param categoria
     */
    @RequestMapping(value = "api/registrar-categoria", method = RequestMethod.POST)
    public void registrarCategoria(@RequestBody Categoria categoria){
        categoriaDao.registrarCategoria(categoria);
    }


    /**
     * Permite eliminar una categoria y recibe como parametro el id de la categoria que se desea
     * eliminar
     * @param id
     */
    @RequestMapping(value ="api/eliminar-categoria/{id}", method = RequestMethod.DELETE)
    public void eliminarCategoria(@PathVariable int id) {
        categoriaDao.eliminarCategoria(id);
    }


    /**
     * Permite obtener una categoria mediante su id y retorna un objeto de tipo categoria
     * @param id
     * @return
     */
    @RequestMapping(value = "categoria/{id}", method = RequestMethod.GET)
    public Categoria obtenerCategoria(@PathVariable int id){
        return categoriaDao.obtenerCategoria(id);
    }
}
