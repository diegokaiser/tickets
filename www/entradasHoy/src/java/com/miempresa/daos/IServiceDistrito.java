package com.miempresa.daos;

import com.miempresa.entidades.Distrito;

public interface IServiceDistrito extends ICRUD<Distrito> {
  Distrito seleccionPorId(int idDistrito);
}
