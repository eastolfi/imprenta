package com.imprenta.dominio;

public class Cliente {

    private final int id_cliente;
    private String nombre_completo;
    private String cif;
    private String direccion;
    private String telefono;
    private static int contador_clientes;

    public Cliente() {
        this.id_cliente = ++this.contador_clientes;
    }

    //constructor completo
    public Cliente(String nombre_completo, String cif, String direccion, String telefono) {
        this();
        this.nombre_completo = nombre_completo;
        this.cif = cif;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //constructor 3 string
    public Cliente(String nombre_completo, String cif, String telefono) {
        this();
        this.nombre_completo = nombre_completo;
        this.cif = cif;
        this.telefono = telefono;
    }

    //constructor 2 string
    public Cliente(String nombre_completo, String cif) {
        this();
        this.nombre_completo = nombre_completo;
        this.cif = cif;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id_cliente=" + id_cliente + ", nombre_completo=" + nombre_completo + ", cif=" + cif + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }

}
