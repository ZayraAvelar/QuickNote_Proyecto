package com.quicknote.note.dao;

import com.quicknote.note.models.Nota;

import java.util.List;
public interface NotaDAO{

    /**
     * Metodo que retorna todas las notas
     * @return
     */
    List<Nota> getNotas();


    /**
     * Metodo que elimina una nota
     * @param id
     */
    void eliminarNota(int id);


    /**
     * Permite modificar una categoria y recibe los nuevos datos de la categoria
     * @param idNota
     * @param nombreNota
     * @param catNota
     * @param descNota
     * @param fechaNota
     */
    void modificarNota(int idNota, String nombreNota, int catNota,String descNota, String fechaNota);


    /**
     * Retorna una nota en forma de lista mediante su id
     * @param id
     * @return
     */
    List<Nota> getNota(int id);


    /**
     * Permite guardar una nota y recibe como parametro los datos a guardar
     * @param nombreNota
     * @param catId
     * @param descNota
     * @param fecha
     */
    void guardarNota(String nombreNota, int catId, String descNota, String fecha);

}
