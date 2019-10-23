/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.tipodulce;

import com.utez.edu.model.marca.BeanMarca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import servicios.basedatos.ConexionMySQL;

/**
 *
 * @author reynel
 */
public class DaoTipoDulce {
    
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    final private String SQL_CONSULTAR_TIPOS = "SELECT * FROM tipoDulce;";
    
    public List<BeanTipoDulce> consultarTiposDulce() {
        List<BeanTipoDulce> tipos = new ArrayList();
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_CONSULTAR_TIPOS);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanTipoDulce bean = new BeanTipoDulce();
                bean.setIdTipoDulce(rs.getInt("idTipoDulce"));
                bean.setNombreTipo(rs.getString("nombreTipo"));
                bean.setDescripcion(rs.getString("descripcion"));
                tipos.add(bean);
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método consultarTiposDulce() del DaoTipoDulce -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return tipos;
    }
    
}
