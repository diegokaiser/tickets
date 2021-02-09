package com.miempresa.test;

import com.miempresa.connectiondb.ConnectionDB;
import com.miempresa.daos.CineDAO;
import com.miempresa.entidades.Cine;
import java.util.ArrayList;
import java.util.List;

public class TestCinesListar {
  public static void main(String[] args) {
    ConnectionDB.getInstance();
    Cine cine = new Cine();    
    List<Cine> cines = new ArrayList<>();
    CineDAO cineDAO = new CineDAO();
  }
}
