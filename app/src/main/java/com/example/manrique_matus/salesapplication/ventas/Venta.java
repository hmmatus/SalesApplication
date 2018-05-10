package com.example.manrique_matus.salesapplication.ventas;

import java.util.Date;

public class Venta {
    private int id_venta;
    private String fecha;
    private int cantidad_producto;
    private double total_venta;
    private String cliente;

    //Constructor vacio
    public Venta() {
    }

    //Constructor lleno

    public Venta(int id_venta,String fecha, int cantidad_producto, double total_venta,String cliente) {
        this.id_venta = id_venta;
        this.fecha = fecha;
        this.cantidad_producto = cantidad_producto;
        this.total_venta = total_venta;
        this.cliente=cliente;
    }

    public Venta(int id_venta, String fecha, double total_venta, String cliente) {
        this.id_venta = id_venta;
        this.fecha = fecha;
        this.total_venta = total_venta;
        this.cliente = cliente;
    }

    //Setters y Getters

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

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(double total_venta) {
        this.total_venta = total_venta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}
