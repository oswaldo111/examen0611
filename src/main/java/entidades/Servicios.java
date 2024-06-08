/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author R5 8500G
 */
public class Servicios {

    public int ServiciosID;
    public String Nombre;
    public String Descripcion;
    public double Precio;

    public Servicios() {
    }

    public Servicios(int ServiciosID, String Nombre, String Descripcion, double Precio) {
        this.ServiciosID = ServiciosID;
        this.Nombre = Nombre;
        this.Descripcion = Descripcion;
        this.Precio = Precio;
    }

    public int getServiciosID() {
        return ServiciosID;
    }

    public void setServiciosID(int ServiciosID) {
        this.ServiciosID = ServiciosID;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

}
