package com.quicknote.note.controllers;

import com.quicknote.note.dao.UsuarioDAO;
import com.quicknote.note.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDAO usuarioDao;


    /**
     * Retorna la lista de usuarios
     * @return
     */

    @RequestMapping(value = "usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }


    /**
     * Permite eliminar un usuario mediante su id
     * @param id
     */
    @RequestMapping(value = "api/eliminar-usuario/{id}", method = RequestMethod.DELETE)
    public void eliminarUsuario(@PathVariable int id){
        usuarioDao.eliminarUsuario(id);
    }



    /**
     * Permite guardar un nuevo usuario
     * @param usuario
     */
    @RequestMapping(value = "api/guardar-usuario", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        usuarioDao.registrarUsuario(usuario);
    }



}
