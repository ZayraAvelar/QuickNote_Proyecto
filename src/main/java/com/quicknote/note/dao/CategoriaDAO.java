package com.quicknote.note.dao;

import com.quicknote.note.models.Categoria;
import com.quicknote.note.models.Nota;

import java.util.List;

public interface CategoriaDAO {

    /**
     * Metodo que retorna todas las categorias de la bd
     * @return
     */
    List<Categoria> getCategorias();


    /**
     * Metodo que registra una categoria
     * @param categoria
     */
    void registrarCategoria(Categoria categoria);


    /**
     * Metodo que elimina una categoria de la bd
     * @param id
     */
    void eliminarCategoria(int id);


    /**
     * Permite obtener una categoria mediante su id
     * @param id
     * @return
     */
    Categoria obtenerCategoria(int id);


}
