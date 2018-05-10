package com.example.manrique_matus.salesapplication.productos;

public class Producto {
    private int id_producto;
    private String nombre_producto;
    private String desc_producto;
    double precioUnit, largo, ancho, area;


    //Constructor vacio
    public Producto() {
    }

    //Constructor lleno


    public Producto(int id_producto, String nombre_producto, String desc_producto, double precioUnit, double largo, double ancho, double area) {
        this.id_producto = id_producto;
        this.nombre_producto = nombre_producto;
        this.desc_producto = desc_producto;
        this.precioUnit = precioUnit;
        this.largo = largo;
        this.ancho = ancho;
        this.area = area;
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

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }
}
