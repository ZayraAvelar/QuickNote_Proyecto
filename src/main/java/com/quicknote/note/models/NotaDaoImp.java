package com.quicknote.note.models;


import com.quicknote.note.dao.NotaDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional

public class NotaDaoImp implements NotaDAO{

    @PersistenceContext
    EntityManager entityManager;


    /**
     * Retorna la lista de elementos de la entidad nota
     * @return
     */
    @Override
    public List<Nota> getNotas(){
        //creamos la consulta para obtener las notas
        String query =" SELECT n.idNota, n.nombreNota, n.descNota, n.fechaNota, n.catNota.catId, n.catNota.catNombre  FROM Nota n INNER JOIN n.catNota c";
         return entityManager.createQuery(query).getResultList();
    }


    /**
     * Permite eliminar una nota
     * @param id
     */
    @Override
    public void eliminarNota(int id) {
        Nota nota = entityManager.find(Nota.class,id);
        entityManager.remove(nota);
    }


    /**
     * Permite modificar una nota
     * @param nota
     */
    public void modificarNota(Nota nota){
        entityManager.merge(nota);
    }


    /**
     * Retorna una nota en forma de lista mediante su id
     * @param id
     * @return
     */
    public List<Nota> getNota(int id){
        //consulta para obtener la nota
        String query = "SELECT n.idNota, n.nombreNota, n.descNota, n.fechaNota, n.catNota.catId, n.catNota.catNombre FROM Nota n INNER JOIN n.catNota c WHERE n.idNota = :id";
        return entityManager.createQuery(query).setParameter("id", id).getResultList();

    }


    /**
     * Permite guardar una nota y para ello requiere todos los datos de la nota
     * @param nombreNota
     * @param catId
     * @param descNota
     * @param fecha
     */
    public void guardarNota(String nombreNota, int catId, String descNota, String fecha){

        //creamos el objeto
        Nota miNota = new Nota();

        //obtenemos el objeto categoria por su id
        miNota.setCatNota(obtenerCategoriaPorId(catId));

        miNota.setNombreNota(nombreNota);
        miNota.setDescNota(descNota);
        miNota.setFechaNota(fecha);

        //guardamos el nuevo registro
        entityManager.merge(miNota);
    }


    /**
     * Permite obtener una categoria mediante su id
     * @param catId
     * @return
     */
    private Categoria obtenerCategoriaPorId(int catId) {
        return entityManager.find(Categoria.class, catId);
    }


    /**
     * Permite modificar una categoria y recibe como parametros los nuevos datos
     * @param idNota
     * @param nombreNota
     * @param catId
     * @param descNota
     * @param fecha
     */
    public void modificarNota(int idNota,String nombreNota, int catId, String descNota, String fecha){


        //creamos un objeto de tipo categoria para poder pasar los valores de la modificacion
        Categoria miCategoria = obtenerCategoriaPorId(catId);

        //creamos un objeto de tipo nota para obtener los datos de la nota a modificar
        Nota miNota = entityManager.find(Nota.class, idNota);

        //modificamos los datos de la nota
        miNota.setNombreNota(nombreNota);
        miNota.setCatNota(miCategoria);
        miNota.setDescNota(descNota);
        miNota.setFechaNota(fecha);
        miNota.setIdNota(idNota);


        //guardamos los cambios realizados
        entityManager.merge(miNota);

    }
}
