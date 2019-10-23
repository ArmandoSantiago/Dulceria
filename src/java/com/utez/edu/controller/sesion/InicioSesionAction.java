/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.controller.sesion;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.utez.edu.model.usuario.BeanUsuario;
import com.utez.edu.model.usuario.DaoUsuario;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author reynel
 */
public class InicioSesionAction extends ActionSupport implements SessionAware {

    private DaoUsuario dao = new DaoUsuario();
    private BeanUsuario bean = new BeanUsuario();
    private Map session;
    private String mensaje;

    public BeanUsuario getBean() {
        return bean;
    }

    public void setBean(BeanUsuario bean) {
        this.bean = bean;
    }

    public Map getSession() {
        return session;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String iniciarSesion() {
        session = ActionContext.getContext().getSession();
        String user = bean.getUser();
        String pass = bean.getPass();
        bean = dao.consultarUsuarioLogin(bean);
        if (bean != null) {

            if (user.equals(bean.getUser()) && pass.equals(bean.getPass())) {
                mensaje = "¡Bienvenido!";
                session.put("usuario", bean);
                return SUCCESS;
            } else {
                mensaje = "Usuario y/o contraseña incorrecta";
                return ERROR;
            }

        } else {
            mensaje = "Usuario y/o contraseña incorrecta";
            return ERROR;
        }

    }
    
    public String cerrarSesion(){
        session = ActionContext.getContext().getSession();
        session.clear();
        return SUCCESS;
    }

}
