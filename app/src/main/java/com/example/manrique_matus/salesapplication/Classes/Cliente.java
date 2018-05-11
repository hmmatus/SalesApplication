package com.example.manrique_matus.salesapplication.Classes;

public class Cliente {
    private String nomCliente;
    private String apeCliente;

    //Constructor vacio
    public Cliente() {
    }

    //Constructor lleno


    public Cliente(String nomCliente, String apeCliente) {
        this.nomCliente = nomCliente;
        this.apeCliente = apeCliente;
    }

    public Cliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public String getApeCliente() {
        return apeCliente;
    }

    public void setApeCliente(String apeCliente) {
        this.apeCliente = apeCliente;
    }
}
