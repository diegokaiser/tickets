package com.isil.interfaces;

import com.isil.daos.crud;
import com.isil.entities.Usuario;

public interface ServiceUsuario extends crud<Usuario> {
    Boolean login(Usuario usuario);
}
