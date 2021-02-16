package com.miempresa.daos;

import com.miempresa.entidades.Pelicula;
import java.util.List;

public interface IServicePelicula extends ICRUD<Pelicula> {
  List<Pelicula> seleccionarUltimos();
  List<Pelicula> seleccionarEstrenos();
  List<Pelicula> seleccionarRecomendados();
  List<Pelicula> seleccionarDestacado();
  Pelicula seleccionPorId(int idPelicula);
}
