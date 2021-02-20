package com.miempresa.test;
import com.miempresa.daos.DistritoDAO;

public class TestDistritos {

  public static void main(String[] args) {
    DistritoDAO distrito = new DistritoDAO();
    distrito.seleccionarTodo();
    for (int i = 0; i < distrito.seleccionarTodo().size(); i++) {
      System.out.println(distrito.seleccionarTodo().get(i));
    }
  }
}
