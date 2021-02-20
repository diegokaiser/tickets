/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.daos;

import com.miempresa.entidades.Entrada;

/**
 *
 * @author JosueFlores
 */
public interface IserviceEntrada extends ICRUD<Entrada> {
      Entrada seleccionPorId(int idEntrada);
}

