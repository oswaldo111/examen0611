/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Accesodatos;

import entidades.Ordenes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author R5 8500G
 */
public class OrdenesDAL {
    
     public static ArrayList<Ordenes> obtenerTodos() {
        ArrayList<Ordenes> categorias = new ArrayList<>();
        try (Connection conn = ComunDB.obtenerConexion()) {
            String sql = "SELECT CategoriaID, Nombre, Descripcion FROM Categorias";           
            try (PreparedStatement statement = conn.prepareStatement(sql)) {                              
                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int categoriaId = resultSet.getInt("CategoriaID");
                        String nombre = resultSet.getString("Nombre");
                        String descripcion = resultSet.getString("Descripcion");                       
                        Ordenes categoria = new Ordenes();
                        categorias.add(categoria);
                    }
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error al obtener las categorias", e);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener la conexión a la base de datos", e);
        }
        return categorias;
    }
}
