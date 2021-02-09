/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.miempresa.connectiondb;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author User
 */
// IMPLEMENTANDO EL PATRON SINGLETON
public class ConnectionDB {

    private static ConnectionDB instance = null;
    //Haciendo uso de la API JBDC
    private static Connection con = null;
    //Definiendo los parámetro de conexion a la Base de Datos
    //Cadena de Conexion
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=SistemaCine";
    //Información del Driver segun el motor de base de datos
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //Las credenciales de la base de datos
    private static final String USER = "Josue";
    private static final String PASS = "123456";
    //Constructor Privado
    private ConnectionDB() {
        try {
            //Creamos una instancia del DRIVER
            Class.forName(DRIVER).newInstance();
            con = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Conectado correctamente");
            System.out.println("" + con.toString());
        } catch (Exception e) {
            System.out.println("Error al intentar conectarse");
            //Para que me muestre el detalle del error
            e.printStackTrace();
        }
    }

    public synchronized static ConnectionDB getInstance() {
        if (instance == null) {
            instance = new ConnectionDB();
        }
        return instance;
    }

    public Connection getConnection() {
        return con;
    }

    public void close() {
        instance = null;
    }

}
