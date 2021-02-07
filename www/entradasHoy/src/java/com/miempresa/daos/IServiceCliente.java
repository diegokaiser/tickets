/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.daos;

import com.miempresa.entidades.Cliente;
import java.util.List;

/**
 *
 * @author User
 */
public interface IServiceCliente extends ICRUD<Cliente>{
    List<Cliente> seleccionarPorNombre(String nombre);
}
