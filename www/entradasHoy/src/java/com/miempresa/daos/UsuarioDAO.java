package com.miempresa.daos;

import com.miempresa.connectiondb.ConnectionDB;
import com.miempresa.entidades.Usuario;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO implements IServiceUsuario {

  private static ConnectionDB con;
  private static PreparedStatement pstm;
  private static CallableStatement cstm;
  private static ResultSet res;

  public UsuarioDAO() {
    con = ConnectionDB.getInstance();
  }

  @Override
  public Boolean login(Usuario usuario) {
    Boolean resultFlag = false;
    final String SQL_LOGIN = "{call usp_login(?,?)}";
    try {
      cstm = con.getConnection().prepareCall(SQL_LOGIN);
      cstm.setString(1, usuario.getCorreo());
      cstm.setString(2, usuario.getContrasena());
      res = cstm.executeQuery();
      while (res.next()) {
        resultFlag = true;
        usuario.setIdUsuario(res.getInt(1));
        usuario.setNombre(res.getString(2));
        usuario.setApellido(res.getString(3));
        usuario.setCorreo(res.getString(4));
        usuario.setTipoDocumento(res.getString(6));
        usuario.setNumeroDocumento(res.getString(7));
        System.out.println("ID: "+res.getInt(1));
        System.out.println("Nombre: "+res.getString(2));
        System.out.println("Apellido: "+res.getString(3));
        System.out.println("Correo: "+res.getString(4));
        System.out.println("Tipo documento: "+res.getString(6));
        System.out.println("Numero documento: "+res.getString(7));
      }
    } catch (Exception e) {
      System.out.println("Error al iniciar sesion");
      e.printStackTrace();
    } finally {
      close();
    }
    return resultFlag;
  }

  @Override
  public Boolean loginAdmin(Usuario usuario) {
    Boolean resultFlag = false;
    final String SQL_LOGIN = "{call usp_loginAdmin(?,?)}";
    try {
      cstm = con.getConnection().prepareCall(SQL_LOGIN);
      cstm.setString(1, usuario.getCorreo());
      cstm.setString(2, usuario.getContrasena());
      res = cstm.executeQuery();
      while (res.next()) {
        int result = res.getInt(1);
        if (result == 1) {
          resultFlag = true;
        }
      }
    } catch (Exception e) {
      System.out.println("Error al iniciar sesion");
      e.printStackTrace();
    } finally {
      close();
    }
    return resultFlag;
  }

  @Override
  public List<Usuario> seleccionarTodo() {
    List<Usuario> usuarios = new ArrayList<>();
    final String SQL_SELECTALL = "{call usp_listarUsuarios()}";

    try {
      cstm = con.getConnection().prepareCall(SQL_SELECTALL);
      res = cstm.executeQuery();
      while (res.next()) {
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(res.getInt(1));
        usuario.setNombre(res.getString("nombre"));
        usuario.setApellido(res.getString("apellido"));
        usuario.setCorreo(res.getString("correo"));
        usuario.setTipoDocumento(res.getString("tipoDocumento"));
        usuario.setNumeroDocumento(res.getString("numeroDocumento"));
        usuario.setEstado(res.getInt("estado"));
        usuarios.add(usuario);
      }
    } catch (Exception e) {
      System.out.println("Error al recuperar el listado de usuarios");
      e.printStackTrace();
    } finally {
      close();
    }
    return usuarios;
  }
  
  public Usuario selecionarPorCorreo(Usuario usuario) {
    final String SQL_SELECTALL = "{call usp_listarPorCorreo(?)}";
    try {
      cstm = con.getConnection().prepareCall(SQL_SELECTALL);
      cstm.setString(1, usuario.getCorreo());
      res = cstm.executeQuery();
      while (res.next()) {
        usuario.setIdUsuario(res.getInt(1));
        usuario.setNombre(res.getString("nombre"));
        usuario.setApellido(res.getString("apellido"));
        usuario.setContrasena(res.getString("contrasena"));
        usuario.setCorreo(res.getString("correo"));
        usuario.setTipoDocumento(res.getString("tipoDocumento"));
        usuario.setNumeroDocumento(res.getString("numeroDocumento"));
        usuario.setEstado(res.getInt("estado"));
      }
    } catch (Exception e) {
      System.out.println("Error al recuperar el listado de usuarios");
      e.printStackTrace();
    } finally {
      close();
    }
    return usuario;
  }  

  @Override
  public Boolean insertar(Usuario usuario) {
    Boolean resultFlag = false;
    final String SQL_INSERT = "insert into usuario (nombre, apellido, correo, contrasena, tipoDocumento, numeroDocumento, idTipoUsuario, estado) values (?,?,?,?,?,?,?,?)";
    try {
      pstm = con.getConnection().prepareStatement(SQL_INSERT);

      pstm.setString(1, usuario.getNombre());
      pstm.setString(2, usuario.getApellido());
      pstm.setString(3, usuario.getCorreo());
      pstm.setString(4, usuario.getContrasena());

      pstm.setString(5, usuario.getTipoDocumento());
      pstm.setString(6, usuario.getNumeroDocumento());
      pstm.setInt(7, usuario.getIdTipoUsuario());
      pstm.setInt(8, usuario.getEstado());

      int result = pstm.executeUpdate();
      if (result > 0) {
        resultFlag = true;
      }
    } catch (Exception e) {
      System.out.println("Error al insertar el registro");
      e.printStackTrace();
    } finally {
      close();
    }
    return resultFlag;
  }

  @Override
  public Boolean actualizar(Usuario usuario) {
    Boolean resultFlag = false;
    final String SQL_UPDATE = "update usuario set nombre=?, apellido=?, correo=?, contrasena=?, numeroDocumento=? where idUsuario=?";
    try {
      pstm = con.getConnection().prepareStatement(SQL_UPDATE);
      pstm.setString(1, usuario.getNombre());
      pstm.setString(2, usuario.getApellido());
      pstm.setString(3, usuario.getCorreo());
      pstm.setString(4, usuario.getContrasena());
      pstm.setString(5, usuario.getNumeroDocumento());
      pstm.setInt(6, usuario.getIdUsuario());
      System.out.println(usuario.getNombre() + "update");
      int result = pstm.executeUpdate();
      if (result > 0) {
        resultFlag = true;
      }
    } catch (Exception e) {
      System.out.println("Error al actualizar el registro");
      e.printStackTrace();
    } finally {
      close();
    }
    return resultFlag;
  }

  @Override
  public Boolean eliminar(Usuario usuario) {
    Boolean resultFlag = false;
    final String SQL_DELETE = "update usuario set estado=0 where idUsuario=?";

    try {
      pstm = con.getConnection().prepareStatement(SQL_DELETE);
      pstm.setInt(1, usuario.getIdUsuario());
      int result = pstm.executeUpdate();
      if (result > 0) {
        resultFlag = true;
      }
    } catch (Exception e) {
      System.out.println("Error al eliminar al usuario");
      e.printStackTrace();
    } finally {
      close();
    }
    return resultFlag;
  }

  public Boolean habilitar(Usuario usuario) {
    Boolean resultFlag = false;
    final String SQL_DELETE = "update usuario set estado=1 where idUsuario=?";

    try {
      pstm = con.getConnection().prepareStatement(SQL_DELETE);
      pstm.setInt(1, usuario.getIdUsuario());
      int result = pstm.executeUpdate();
      if (result > 0) {
        resultFlag = true;
      }
    } catch (Exception e) {
      System.out.println("Error al eliminar al usuario");
      e.printStackTrace();
    } finally {
      close();
    }
    return resultFlag;
  }

  @Override
  public Usuario seleccionPorId(int idUsuario) {
    Usuario usuario = new Usuario();
    final String SQL_SELECT_BY_ID = "SELECT * FROM usuario WHERE idUsuario=?";
    try {
      pstm = con.getConnection().prepareStatement(SQL_SELECT_BY_ID);
      pstm.setInt(1, idUsuario);
      res = pstm.executeQuery();
      while (res.next()) {
        usuario.setIdUsuario(res.getInt(1));
        usuario.setNombre(res.getString(2));
        usuario.setApellido(res.getString(3));
        usuario.setCorreo(res.getString(4));
        usuario.setTipoDocumento(res.getString(6));
        usuario.setNumeroDocumento(res.getString(7));
        usuario.setContrasena(res.getString(5));
        System.out.println(res.getInt(1) + " ");
        System.out.println(res.getString(2));
        System.out.println(res.getString(3));
        System.out.println(res.getString(4));
      }
    } catch (Exception e) {
      System.out.println("Error al eliminar al usuario");
      e.printStackTrace();
    } finally {
      close();
    }
    return usuario;
  }

  @Override
  public void close() {
    try {
      if (res != null) {
        res.close();
      }
      if (cstm != null) {
        cstm.close();
      }
      if (con != null) {
        con.close();
      }

    } catch (Exception e) {
      System.out.println("Error al cerrar conexion :" + e.getMessage());
    }
  }
}
