package com.imprenta.dominio;

public class Producto {

    private final int id_producto;
    private static int contador_producto;
    private String nombre_producto;
    protected TamanioPapel medida;
    private boolean is_2_caras;
    private TipoPapel papel;
    private int gramaje;
    private boolean is_Color;
    private TipoPlastificado plastificado;
    private boolean puntasRedondeaDas;
    private TipoEncuadernado encuadernado;
    private boolean is_plegado;

    public Producto() {
        this.id_producto = ++contador_producto;
    }

    //constructor con todoooo
    public Producto(int id_producto, String nombre_producto, TamanioPapel medida, boolean is_2_caras, TipoPapel papel, int gramaje, boolean is_Color, TipoPlastificado plastificado, boolean puntasRedondeaDas, TipoEncuadernado encuadernado, boolean is_plegado) {
        this.id_producto = ++contador_producto;
        this.nombre_producto = nombre_producto;
        this.medida = medida;
        this.is_2_caras = is_2_caras;
        this.papel = papel;
        this.gramaje = gramaje;
        this.is_Color = is_Color;
        this.plastificado = plastificado;
        this.puntasRedondeaDas = puntasRedondeaDas;
        this.encuadernado = encuadernado;
        this.is_plegado = is_plegado;
    }

    //constructor si ID
    public Producto(String nombre_producto, TamanioPapel medida, boolean is_2_caras, TipoPapel papel, int gramaje, boolean is_Color, TipoPlastificado plastificado, boolean puntasRedondeaDas, TipoEncuadernado encuadernado, boolean is_plegado) {
        this();
        this.nombre_producto = nombre_producto;
        this.medida = medida;
        this.is_2_caras = is_2_caras;
        this.papel = papel;
        this.gramaje = gramaje;
        this.is_Color = is_Color;
        this.plastificado = plastificado;
        this.puntasRedondeaDas = puntasRedondeaDas;
        this.encuadernado = encuadernado;
        this.is_plegado = is_plegado;
    }

    public int getId_trabajo() {
        return id_producto;
    }

    /*  public static int getContador_trabajo() {
        return contador_producto;
    }

    public static void setContador_trabajo(int contador_producto) {
        Producto.contador_producto = contador_producto;
    }*/
    public String getNombre_trabajo() {
        return nombre_producto;
    }

    public void setNombre_trabajo(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public TamanioPapel getMedida() {
        return medida;
    }

    public void setMedida(TamanioPapel medida) {
        this.medida = medida;
    }

    public boolean isIs_2_caras() {
        return is_2_caras;
    }

    public void setIs_2_caras(boolean is_2_caras) {
        this.is_2_caras = is_2_caras;
    }

    public TipoPapel getPapel() {
        return papel;
    }

    public void setPapel(TipoPapel papel) {
        this.papel = papel;
    }

    public int getGramaje() {
        return gramaje;
    }

    public void setGramaje(int gramaje) {
        this.gramaje = gramaje;
    }

    public boolean isIs_Color() {
        return is_Color;
    }

    public void setIs_Color(boolean is_Color) {
        this.is_Color = is_Color;
    }

    public TipoPlastificado getPlastificado() {
        return plastificado;
    }

    public void setPlastificado(TipoPlastificado plastificado) {
        this.plastificado = plastificado;
    }

    public boolean isPuntasRedondeaDas() {
        return puntasRedondeaDas;
    }

    public void setPuntasRedondeaDas(boolean puntasRedondeaDas) {
        this.puntasRedondeaDas = puntasRedondeaDas;
    }

    public TipoEncuadernado getEncuadernado() {
        return encuadernado;
    }

    public void setEncuadernado(TipoEncuadernado encuadernado) {
        this.encuadernado = encuadernado;
    }

    public boolean isIs_plegado() {
        return is_plegado;
    }

    public void setIs_plegado(boolean is_plegado) {
        this.is_plegado = is_plegado;
    }

    @Override
    public String toString() {
        return "Producto{" + "id_producto=" + id_producto + ", nombre_producto=" + nombre_producto + ", medida=" + medida + ", is_2_caras=" + is_2_caras + ", papel=" + papel + ", gramaje=" + gramaje + ", is_Color=" + is_Color + ", plastificado=" + plastificado + ", puntasRedondeaDas=" + puntasRedondeaDas + ", encuadernado=" + encuadernado + ", is_plegado=" + is_plegado + '}';
    }
}
