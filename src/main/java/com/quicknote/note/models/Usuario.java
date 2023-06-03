package com.quicknote.note.models;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    //asigna el valor de idusuario
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idusuario")
    private int idUsuario;


    //asigna el valor de nombre usuario
    @Column(name = "nombreusuario", nullable = false)
    private String nombreUsuario;


    //asigna la contraseña del usuario
    @Column(name = "contrasenausurario", nullable = false)
    private String contraseñaUsuario;

    //constructor con 3 parametros
    public Usuario(int idUsuario, String nombreUsuario, String contraseñaUsuario){
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
    }


    //constructor con dos parametros
    public Usuario(String nombreUsuario, String contraseñaUsuario){
        this.nombreUsuario = nombreUsuario;
        this.contraseñaUsuario = contraseñaUsuario;
    }

    //constructor vacio
    public Usuario(){}


    /**
     * Retorna el id de usuario
     * @return
     */
    public int getIdUsuario() {
        return idUsuario;
    }


    /**
     * Cambia el id de usuario
     * @param idUsuario
     */
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }


    /**
     * Retorna el nombre de usuario
     * @return
     */
    public String getNombreUsuario(){
        return nombreUsuario;
    }


    /**
     * Cambia el nombre de usuario
     * @param nombreUsuario
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }


    /**
     * Retorna la contraseña del usuario
     * @return
     */
    public String getContraseñaUsuario(){
        return contraseñaUsuario;
    }


    /**
     * Cambia la contraseña del usuario
     * @param contraseñaUsuario
     */
    public void setContraseñaUsuario(String contraseñaUsuario) {
        this.contraseñaUsuario = contraseñaUsuario;
    }
}
