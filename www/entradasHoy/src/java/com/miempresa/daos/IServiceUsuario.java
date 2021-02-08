package com.miempresa.daos;

import com.miempresa.entidades.Usuario;

public interface IServiceUsuario extends ICRUD<Usuario>{
  Boolean login(Usuario usuario);
}
