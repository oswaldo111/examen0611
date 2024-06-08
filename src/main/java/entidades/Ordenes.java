/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.time.LocalDate;

/**
 *
 * @author R5 8500G
 */
public class Ordenes {

    public int OrderID;
    public int ServiciosID;
    public LocalDate Fecha;
    public double Monto;

    public Ordenes() {
    }

    public Ordenes(int OrderID, int ServiciosID, LocalDate Fecha, double Monto) {
        this.OrderID = OrderID;
        this.ServiciosID = ServiciosID;
        this.Fecha = Fecha;
        this.Monto = Monto;
    }

    
    
    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getServiciosID() {
        return ServiciosID;
    }

    public void setServiciosID(int ServiciosID) {
        this.ServiciosID = ServiciosID;
    }

    public LocalDate getFecha() {
        return Fecha;
    }

    public void setFecha(LocalDate Fecha) {
        this.Fecha = Fecha;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

}
