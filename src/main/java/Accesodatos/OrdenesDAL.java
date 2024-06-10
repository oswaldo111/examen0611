/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Accesodatos;

import entidades.Ordenes;
import entidades.Servicios;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author R5 8500G
 */
public class OrdenesDAL {

    public static int crear(Ordenes ordenes) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "INSERT INTO Ordenes (ServicioID, Fecha, Monto) VALUES (?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, ordenes.getServiciosID());
                statement.setDate(2, Date.valueOf(ordenes.getFecha()));
                statement.setDouble(3, ordenes.getMonto());

                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el ordenes", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }

    public static int modificar(Ordenes ordenes) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "UPDATE Ordenes SET ServicioID=?, Fecha=?, Monto=? WHERE OrderID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {

                statement.setInt(1, ordenes.getServiciosID());
                statement.setDate(2, Date.valueOf(ordenes.getFecha()));
                statement.setDouble(3, ordenes.getMonto());
                statement.setInt(4, ordenes.getOrderID());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el ordenes", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }

    public static int eliminar(Ordenes ordenes) {
        try (Connection conn = ComunDB.obtenerConexion()) {

            String sql = "DELETE FROM Ordenes WHERE OrderID=?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, ordenes.getOrderID());
                int rowsAffected = statement.executeUpdate();
                return rowsAffected;
            } catch (SQLException e) {
                throw new RuntimeException("Error al crear el ordenes", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
    }

    public static ArrayList<Ordenes> buscar(Ordenes ordenesSearch) {
        ArrayList<Ordenes> Ordenes = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT O.OrderID, O.ServicioID,  s.Nombre AS NombreSER,  O.Fecha, O.Monto  FROM Ordenes O";
            sql += " INNER JOIN Servicios s ON s.ServicioID= O.ServicioID  ";
            sql += " WHERE p.Nombre LIKE ? ";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, "%" + ordenesSearch.getFecha() + "%");
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        Ordenes orden = new Ordenes();
                        orden.setOrderID(resultSet.getInt("OrderID"));

                        orden.setServiciosID(resultSet.getInt("ServicioID"));
                        Servicios servicio = new Servicios();
                        servicio.setNombre(resultSet.getString("NombreSER"));
                        orden.setServicios(servicio);

                        Date fechaSqlDate = resultSet.getDate("Fecha");
                        LocalDate fechaLocalDate = fechaSqlDate.toLocalDate();
                        orden.setFecha(fechaLocalDate);

                        orden.setMonto(resultSet.getDouble("monto"));

                        Ordenes.add(orden);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al buscar las Ordenes", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return Ordenes;
    }
}
