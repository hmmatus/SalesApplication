package com.example.manrique_matus.salesapplication.ventas;

import java.util.Date;

public class Venta {
    private int id_venta;
    private String fecha;
    private String nombre_vendedor;
    private String nombre_cliente;
    private double total_venta;

    //Constructor vacio
    public Venta() {
    }

    public Venta(int id_venta, String fecha, String nombre_vendedor, String nombre_cliente, double total_venta) {
        this.id_venta = id_venta;
        this.fecha = fecha;
        this.nombre_vendedor = nombre_vendedor;
        this.nombre_cliente = nombre_cliente;
        this.total_venta = total_venta;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre_vendedor() {
        return nombre_vendedor;
    }

    public void setNombre_vendedor(String nombre_vendedor) {
        this.nombre_vendedor = nombre_vendedor;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(double total_venta) {
        this.total_venta = total_venta;
    }
}
    //Constructor lleno

