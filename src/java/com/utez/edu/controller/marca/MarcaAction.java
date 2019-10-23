/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.controller.marca;

import static com.opensymphony.xwork2.Action.SUCCESS;
import static com.opensymphony.xwork2.Action.ERROR;
import com.utez.edu.model.marca.BeanMarca;
import com.utez.edu.model.marca.DaoMarca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author reynel
 */
public class MarcaAction {

    private BeanMarca bean = new BeanMarca();
    private DaoMarca dao = new DaoMarca();
    private List<BeanMarca> listaMarcas = new ArrayList();
    private String mensaje;

    public List<BeanMarca> getListaMarcas() {
        return listaMarcas;
    }

    public void setListaMarcas(List<BeanMarca> listaMarcas) {
        this.listaMarcas = listaMarcas;
    }

    public BeanMarca getBean() {
        return bean;
    }

    public void setBean(BeanMarca bean) {
        this.bean = bean;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String registrarMarca() {
        boolean resultado = dao.registrarMarca(bean);
        if (resultado) {
            return SUCCESS;
        } else {
            mensaje = "No se registró correctamente la marca...";
            return ERROR;
        }
    }

    public String consultarMarcas() {
        listaMarcas = dao.consultarMarcas();
        return SUCCESS;
    }

    public String eliminarMarca() {
        if (dao.eliminarMarca(bean.getIdMarca())) {
            return SUCCESS;
        } else {
            mensaje = "No se eliminó correctamente la marca...";
            return ERROR;
        }
    }

    public String consultaMarcaId() {
        bean = dao.consultarMarcaPorId(bean.getIdMarca());
        if (bean != null) {
            return SUCCESS;
        } else {
            mensaje = "No se encntró la marca...";
            return ERROR;
        }
    }

    public String modificarMarca() {
        if (dao.modificarMarca(bean)) {
            return SUCCESS;
        } else {
            mensaje = "No se actualizó correctamente la marca...";
            return ERROR;
        }
    }

}
