package com.quicknote.note.models;

import com.quicknote.note.dao.CategoriaDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class CategoriaDaoImp implements CategoriaDAO{

    @PersistenceContext
    EntityManager entityManager;


    /**
     * Retorna la lista de elementos de la entidad categoria
     * @return
     */
    @Override
    public List<Categoria> getCategorias(){
        //creamos la consulta a la base de datos de tipo HQL
        String query = "FROM Categoria";
        return entityManager.createQuery(query).getResultList();
    }


    /**
     * Registra una nueva categoria
     * @param categoria
     */
    @Override
    public void registrarCategoria(Categoria categoria){
        entityManager.merge(categoria);
    }


    /**
     * metodo para eliminar una categoria
     * @param id
     */
    @Override
    public void eliminarCategoria(int id) {
        Categoria categoria = entityManager.find(Categoria.class,id);
        entityManager.remove(categoria);
    }


    /**
     * Permite obtener una categora mediante su id y retorna un objeto de tipo Categoria
     * @param id
     * @return
     */
    public Categoria obtenerCategoria(int id){
        Categoria categoria = entityManager.find(Categoria.class, id);
        return categoria;
    }



}
