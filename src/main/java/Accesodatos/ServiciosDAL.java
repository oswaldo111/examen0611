/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Accesodatos;

import entidades.Servicios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author R5 8500G
 */
public class ServiciosDAL {
 
   
    
     public static int crear(Servicios servicio) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "INSERT INTO Servicios (Nombre, Descripcion, Precio) VALUES (?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, servicio.getNombre());
                statement.setString(2, servicio.getDescripcion());
                statement.setDouble(3, servicio.getPrecio());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el servicio", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
     public static int modificar(Servicios servicio) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "UPDATE Servicios SET Nombre=?, Descripcion=?, Precio=? WHERE ServicioID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, servicio.getNombre());
                statement.setString(2, servicio.getDescripcion());
                statement.setDouble(3, servicio.getPrecio());
                statement.setInt(4, servicio.getServiciosID());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al modificar el servicio", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
     public static int eliminar(Servicios servicio) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "DELETE FROM Servicios WHERE ServicioID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, servicio.getServiciosID());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al eliminar el servicio", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }
    
       public static ArrayList<Servicios> buscar(Servicios ServiciosSearch) {
        ArrayList<Servicios> servicios = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT s.ServicioID, s.Nombre, s.Descripcion, s.Precio FROM Servicios s";
            sql+=" WHERE s.Nombre LIKE ? ";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, "%" + ServiciosSearch.getNombre() + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Servicios servicio = new Servicios();
                        servicio.setServiciosID(resultSet.getInt("ServicioID"));
                        servicio.setNombre(resultSet.getString("Nombre"));
                        servicio.setDescripcion(resultSet.getString("Descripcion"));
                        servicio.setPrecio(resultSet.getDouble("Precio"));
                        servicios.add(servicio);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al buscar servicios", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return servicios;
    }
    
         public static ArrayList<Servicios> obtenerTodos() {
        ArrayList<Servicios> servicios = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "select ServicioID, Nombre, Descripcion, Precio from Servicios";           
            try (PreparedStatement statement = conn.prepareStatement(sql)) {                              
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int servicioid = resultSet.getInt("ServicioID");
                        String nombre = resultSet.getString("Nombre");
                        String descripcion = resultSet.getString("Descripcion");   
                        double Precio = resultSet.getDouble("Precio");
                        Servicios servicio = new Servicios(servicioid,nombre,descripcion,Precio );
                        servicios.add(servicio);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al obtener los servicios", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return servicios;
    }
}
