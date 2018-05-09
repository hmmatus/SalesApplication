package com.example.manrique_matus.salesapplication.Classes;

public class Producto {
    private int id_producto;
    private String nombre_producto;
    private String desc_producto;
    double precio;

    //Constructor vacio
    public Producto() {
    }

    //Constructor lleno
    public Producto(int id_producto, String nombre_producto, String desc_producto, double precio) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.desc_producto = desc_producto;
        this.precio = precio;
    }

    //Setters y Getters
    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getDesc_producto() {
        return desc_producto;
    }

    public void setDesc_producto(String desc_producto) {
        this.desc_producto = desc_producto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
