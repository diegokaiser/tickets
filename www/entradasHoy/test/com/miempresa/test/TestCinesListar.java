package com.miempresa.test;

import com.miempresa.connectiondb.ConnectionDB;
import com.miempresa.daos.CineDAO;
import com.miempresa.entidades.Cine;

public class TestCinesListar {
  public static void main(String[] args) {
    ConnectionDB.getInstance();
    Cine cine = new Cine();
    
    CineDAO cineDAO = new CineDAO();
  }
}
