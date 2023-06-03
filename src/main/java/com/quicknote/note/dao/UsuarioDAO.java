package com.quicknote.note.dao;

import com.quicknote.note.models.Usuario;

import java.util.List;

public interface UsuarioDAO {

    //metodo que retorna todas las asignaturas de la bd
    List<Usuario> getUsuarios();

    //metodo que permite guardar una nueva asignatura
    void registrarUsuario(Usuario usuario);


    //metodo que permite eliminar un usuario mediante su id
    void eliminarUsuario(int id);


    //Verifica que el usuario se este registrado en la base de datos
    boolean verificarCredenciales(Usuario usuario);
}
