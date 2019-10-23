/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.controller.dulce;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.utez.edu.model.dulce.BeanDulce;
import com.utez.edu.model.dulce.DaoDulce;
import com.utez.edu.model.marca.BeanMarca;
import com.utez.edu.model.marca.DaoMarca;
import com.utez.edu.model.tipodulce.BeanTipoDulce;
import com.utez.edu.model.tipodulce.DaoTipoDulce;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author reynel
 */
public class DulceAction {

    private BeanDulce beanDulce = new BeanDulce();
    private DaoDulce daoDulce = new DaoDulce();
    private List<BeanDulce> listaDulces = new ArrayList();
    private List<BeanTipoDulce> listaTipos = new ArrayList();
    private List<BeanMarca> listaMarcas = new ArrayList();
    private String mensaje;

    public List<BeanTipoDulce> getListaTipos() {
        return listaTipos;
    }

    public void setListaTipos(List<BeanTipoDulce> listaTipos) {
        this.listaTipos = listaTipos;
    }

    public List<BeanMarca> getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(List<BeanMarca> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    public BeanDulce getBeanDulce() {
        return beanDulce;
    }

    public void setBeanDulce(BeanDulce beanDulce) {
        this.beanDulce = beanDulce;
    }

    public List<BeanDulce> getListaDulces() {
        return listaDulces;
    }

    public void setListaDulces(List<BeanDulce> listaDulces) {
        this.listaDulces = listaDulces;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String consultarDulces() {
        listaDulces = daoDulce.consultarDulces();
        return SUCCESS;
    }

    public String nuevoDulce() {
        DaoTipoDulce daoTipo = new DaoTipoDulce();
        DaoMarca daoMarca = new DaoMarca();
        listaTipos = daoTipo.consultarTiposDulce();
        listaMarcas = daoMarca.consultarMarcas();
        return SUCCESS;
    }
    
    public String registrarDulce() {
        boolean resultado = daoDulce.registrarDulce(beanDulce);
        if (resultado) {
            return SUCCESS;
        } else {
            mensaje = "No se registró correctamente el dulce...";
            return ERROR;
        }
    }

    public String consultarDulceId() {
        DaoTipoDulce daoTipo = new DaoTipoDulce();
        DaoMarca daoMarca = new DaoMarca();
        beanDulce = daoDulce.consultarDulcePorId(beanDulce.getIdDulce());
        listaTipos = daoTipo.consultarTiposDulce();
        listaMarcas = daoMarca.consultarMarcas();
        if (beanDulce != null) {
            return SUCCESS;
        } else {
            mensaje = "No se encontró el dulce específico...";
            return ERROR;
        }
    }

    public String eliminarDulce() {
        if (daoDulce.eliminarDulce(beanDulce.getIdDulce())) {
            return SUCCESS;
        } else {
            mensaje = "No se eliminó correctamente el dulce...";
            return ERROR;
        }
    }

}
