/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import servicios.basedatos.ConexionMySQL;

/**
 *
 * @author reynel
 */
public class DaoUsuario {

    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;

    final private String MYSQL_CONSULTAR_USUARIO_LOGIN = "SELECT * FROM usuario WHERE user = ? AND pass = ?;";

    public BeanUsuario consultarUsuarioLogin(BeanUsuario usuario) {
        BeanUsuario bean = null;
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(MYSQL_CONSULTAR_USUARIO_LOGIN);
            pstm.setString(1, usuario.getUser());
            pstm.setString(2, usuario.getPass());
            rs = pstm.executeQuery();
            if (rs.next()) {
                bean = new BeanUsuario();
                bean.setIdUsuario(rs.getInt("idUsuario"));
                bean.setNombreCompleto(rs.getString("nombreCompleto"));
                bean.setUser(rs.getString("user"));
                bean.setPass(rs.getString("pass"));
                bean.setRol(rs.getString("rol"));
                bean.setCorreoElectronico(rs.getString("correoElectronico"));
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en método consultarUsuarioLogin() del DaoUsuario -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return bean;
    }
 
}
