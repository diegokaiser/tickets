/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.test;

import com.miempresa.daos.PeliculaDAO;
import com.miempresa.entidades.Pelicula;

/**
 *
 * @author JosueFlores
 */
public class TestIngresarPelicula {
    public static void main(String[] args) {
        Pelicula pelicula= new Pelicula();
        String nombre="Faraon love shady the movie";
        String duracion="2:01:00";
        String fechaEstreno="2002-05-16 00:00:00.0";
        String idioma="Español";
        String pais="Peru";
        int subtitulos=1;
        int doblada=1;
        String portada="Nohay";
        String descripcion="Luego de varios exitos el Faraon esta en busca de un nuevo hit mundial";
        String genero="mas 18";
        int estado=1;
        
        pelicula.setNombre(nombre);
        pelicula.setDuracion(duracion);
        pelicula.setFechaEstreno(fechaEstreno);
        pelicula.setIdioma(idioma);
        pelicula.setPais(pais);
        pelicula.setSubtitulos(subtitulos);
        pelicula.setDoblada(doblada);
        pelicula.setPortada(portada);
        pelicula.setDescripcion(descripcion);
        pelicula.setGenero(genero);
        pelicula.setEstado(estado);

        PeliculaDAO peliculaDAO= new PeliculaDAO();
        if(peliculaDAO.insertar(pelicula)){
            System.out.println("Se ingreso la pelicula");
        }else{
            System.out.println("No se ingreso la pelicula");
        }
        
       
    }
}
