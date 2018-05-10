package com.example.manrique_matus.salesapplication.Classes;

public class Vendedor {
    private int idVendedor;
    private String nombreVendedor;
    private String apeVendedor;
    private String usuario;
    private String contra;

    //Constructor vacio
    public Vendedor() {
    }

    public Vendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    //Constructore completo
    public Vendedor(int idVendedor, String nombreVendedor, String apeVendedor, String usuario, String contra) {
        this.idVendedor = idVendedor;
        this.nombreVendedor = nombreVendedor;
        this.apeVendedor = apeVendedor;
        this.usuario = usuario;
        this.contra = contra;
    }

    //Setters y Getters
    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getNombreVendedor() {
        return nombreVendedor;
    }

    public void setNombreVendedor(String nombreVendedor) {
        this.nombreVendedor = nombreVendedor;
    }

    public String getApeVendedor() {
        return apeVendedor;
    }

    public void setApeVendedor(String apeVendedor) {
        this.apeVendedor = apeVendedor;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }


}
