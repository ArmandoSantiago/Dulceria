/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.dulce;

import com.utez.edu.model.marca.BeanMarca;
import com.utez.edu.model.tipodulce.BeanTipoDulce;

/**
 *
 * @author reynel
 */
public class BeanDulce {

    private int idDulce;
    private String nombreDulce;
    private String precio;
    private String sabor;
    private int contenidoNeto;
    private int existencia;
    private BeanMarca marca;
    private BeanTipoDulce tipo;

    public int getIdDulce() {
        return idDulce;
    }

    public void setIdDulce(int idDulce) {
        this.idDulce = idDulce;
    }

    public String getNombreDulce() {
        return nombreDulce;
    }

    public void setNombreDulce(String nombreDulce) {
        this.nombreDulce = nombreDulce;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public int getContenidoNeto() {
        return contenidoNeto;
    }

    public void setContenidoNeto(int contenidoNeto) {
        this.contenidoNeto = contenidoNeto;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public BeanMarca getMarca() {
        return marca;
    }

    public void setMarca(BeanMarca marca) {
        this.marca = marca;
    }

    public BeanTipoDulce getTipo() {
        return tipo;
    }

    public void setTipo(BeanTipoDulce tipo) {
        this.tipo = tipo;
    }
   
}
