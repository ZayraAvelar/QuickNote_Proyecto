package com.quicknote.note.models;

import com.quicknote.note.dao.UsuarioDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional

public class UsuarioDaoImp implements UsuarioDAO{

    @PersistenceContext
    EntityManager entityManager;


    /**
     * Retorna toda la lista de elementos de la entidad usuario
     * @return
     */
    @Override
    public List<Usuario> getUsuarios(){
        //creamos la consulta a la base de datos de tipo HQL
        String query = "FROM Usuario";
        return entityManager.createQuery(query).getResultList();
    }


    /**
     * Guardar un nuevo usuario
     * @param usuario
     */
    @Override
    public void registrarUsuario(Usuario usuario){
        entityManager.merge(usuario);
    }


    /**
     * Permite eliminar un usuario mediante su id
     * @param id
     */
    @Override
    public void eliminarUsuario(int id){
        Usuario usuario = entityManager.find(Usuario.class,id);
        entityManager.remove(usuario);
    }


    /**
     * Permite verificar que un usuario este registrado en la base de datos
     * @param usuario
     * @return
     */
    @Override
    public boolean verificarCredenciales(Usuario usuario){
        String query = "FROM Usuario WHERE nombreUsuario = :nombreUsuario AND contraseñaUsuario = :contraseñaUsuario";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("nombreUsuario", usuario.getNombreUsuario())
                .setParameter("contraseñaUsuario", usuario.getContraseñaUsuario())
                .getResultList();

        return !lista.isEmpty();
    }

}
