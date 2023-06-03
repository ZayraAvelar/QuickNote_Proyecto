package com.quicknote.note.models;
import com.quicknote.note.models.Categoria;

import javax.persistence.*;

@Entity
@Table(name = "nota")
public class Nota {


    //guarda el id de la nota
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idnota")// es el nombre de la columna en la bd
    private int idNota;


    //guardar el nombre de la nota
    @Column(name="nombrenota", nullable = false)
    private String nombreNota;


    //guarda la fecha de la nota
    @Column(name="fechanota", nullable = false)
    private String fechaNota;


    //guarda la categoria de la nota
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcategoria")
    private Categoria catNota;


    //guarda la descripcion de la nota
    @Column(name="decripcionnota", nullable = false)
    private String descNota;



    //Constructores
    public Nota(int idNota, String nombreNota, String fechaNota,String descNota){
        this.idNota = idNota;
        this.nombreNota = nombreNota;
        this.fechaNota = fechaNota;
        //this.catNota = catNota;
        this.descNota = descNota;
        //this.idUsuario = idUsuario;

    }

    //constructor con cuatro parametros
    public Nota(String nombreNota, Categoria catNota, String descNota, String fechaNota){
        this.nombreNota = nombreNota;
        this.catNota = catNota;
        this.descNota = descNota;
        this.fechaNota = fechaNota;
    }


    //contructor con 5 parametros
    public Nota(int idNota,String nombreNota,Categoria catNota, String descNota, String fechaNota){
        this.idNota = idNota;
        this.nombreNota = nombreNota;
        this.catNota = catNota;
        this.descNota = descNota;
        this.fechaNota = fechaNota;
    }
    //Constructor vacio
    public Nota(){

    }

    /**
     * Metodo para obtener el idNota
     * @return
     */
    public int getIdNota(){

        return idNota;
    }


    /**
     * Metodo para cambiar el idNota
     * @param idNota
     */
    public void setIdNota(int idNota){
        this.idNota = idNota;
    }


    /**
     * Metodo para obtener el nombre de la nota
     * @return
     */
    public String getNombreNota(){
        return nombreNota;
    }


    /**
     * Metodo para cambiar el nombre de la nota
     * @param nombreNota
     */
    public void setNombreNota(String nombreNota){
        this.nombreNota = nombreNota;
    }


    /**
     * Metodo para obtener la fecha de la nota
     * @return
     */
    public String getFechaNota(){

        return fechaNota;
    }


    /**
     * Metodo para cambiar la fecha
     * @param fechaNota
     */
    public void setFechaNota(String fechaNota){

        this.fechaNota = fechaNota;
    }


    /**
     * Metodo para obtener la categoria
     * @return
     */
    public Categoria getCatNotaa(){
        return catNota;
    }


    /**
     * Metodo para cambiar la categoria de la nota
     * @param catNota
     */
    public void setCatNota(Categoria catNota){
        this.catNota = catNota;
    }


    /**
     * Metodo para obtener la descripcion de la nota
     * @return
     */
    public String getDescNota(){
        return descNota;
    }


    /**
     * Metodo para cambiar la descripcion de la nota
     * @param descNota
     */
    public void setDescNota(String descNota){
        this.descNota = descNota;
    }



}
