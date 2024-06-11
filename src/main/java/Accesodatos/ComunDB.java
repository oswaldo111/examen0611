/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author R5 8500G
 */



public class ComunDB {
     static String connectionUrl ="jdbc:sqlserver://servicios_ordenes.mssql.somee.com:1433;databaseName=servicios_ordenes;user=oswaldo56_SQLLogin_1;password=k8663n9m1v;packetSize=4096;encrypt=true;trustServerCertificate=true;loginTimeout=30;";
     
     public static Connection obtenerConexion() throws SQLException {
        // Registrar el Driver de la conexion a la base de datos SQL server
        // para que lo reconozca el servidor web
        DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
        Connection connection = DriverManager.getConnection(connectionUrl); // abrir la conexion a la base de datos
        return connection; // retornar la conexion a la base de datos
    }
     
}
