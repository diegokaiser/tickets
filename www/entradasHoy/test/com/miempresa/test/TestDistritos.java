package com.miempresa.test;
import com.miempresa.daos.DistritoDAO;

<<<<<<< HEAD
public class TestDistritos {

  public static void main(String[] args) {
    DistritoDAO distrito = new DistritoDAO();
    distrito.seleccionarTodo();
    for (int i = 0; i < distrito.seleccionarTodo().size(); i++) {
      System.out.println(distrito.seleccionarTodo().get(i));
=======
import com.miempresa.daos.CineDAO;
import com.miempresa.entidades.Distrito;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JosueFlores
 */
public class TestDistritos {
    public static void main(String[] args) {
        CineDAO cine = new CineDAO();
    java.util.List<Distrito> distritos = new ArrayList<>();
        distritos=cine.listarDistritos();
        for (int i = 0; i <cine.listarDistritos().size() ; i++) {
            System.out.println(distritos.get(i).getNombre());  
        }
   
>>>>>>> cb5b123... NO SALEEEEEEEEEE
    }
  }
}
