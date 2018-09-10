package com.example.ps.listadodedatos;

import java.io.Serializable;

public class Empleado implements Serializable
{
    String  codigo;
    String  nombre;
    double sueldo;

    public Empleado(String codigo, String nombre, double sueldo)
    {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }


}