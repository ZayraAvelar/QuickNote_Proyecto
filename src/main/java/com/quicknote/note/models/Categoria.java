package com.quicknote.note.models;


import javax.persistence.*;

@Entity
@Table(name ="categoria")
public class Categoria {

    //variable que guarda en id de la categoria
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategoria")
    private int catId;

    //variable que guarda el nombre de la categoria
    @Column(name = "nombrecategoria", nullable = false)
    private String catNombre;


    //constructor con parametros
    public Categoria(int catId, String catNombre) {
        this.catId = catId;
        this.catNombre = catNombre;
    }


    //constructor con un solo parametro
    public Categoria(int catId){}


    //constructor con un solo parametro
    public Categoria(String catNombre){
        this.catNombre= catNombre;
    }

    //constructor vacio
    public Categoria(){}


    //getter y setters

    /**
     * Metodo que retorna el id de la categoria
     * @return
     */
    public int getCatId() {
        return catId;
    }


    /**
     * Metodo que cambia el id de una categoria
     * @param catId
     */
    public void setCatId(int catId) {
        this.catId = catId;
    }


    /**
     * Metodo que retorna el nombre de la categoria
     * @return
     */
    public String getCatNombre() {
        return catNombre;
    }


    /**
     * Metodo aue cambia el nombre de la categoria
     * @param catNombre
     */
    public void setCatNombre(String catNombre) {
        this.catNombre = catNombre;
    }
}
