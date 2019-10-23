/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.dulce;

import com.utez.edu.model.marca.BeanMarca;
import com.utez.edu.model.tipodulce.BeanTipoDulce;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import servicios.basedatos.ConexionMySQL;

/**
 *
 * @author reynel
 */
public class DaoDulce {
    
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;
    
    final private String SQL_CONSULTAR_DULCES = "SELECT d.*, m.idMarca, m.nombreMarca, t.idTipoDulce, t.nombreTipo "
            + "                                     FROM dulce d INNER JOIN marca m ON d.idMarca = m.idMarca "
            + "                                     INNER JOIN tipoDulce t ON d.idTipoDulce = t.idTipoDulce;";
    final private String SQL_CONSULTAR_DULCE_POR_ID = "SELECT d.*, m.idMarca, m.nombreMarca, t.idTipoDulce, t.nombreTipo "
            + "                                     FROM dulce d INNER JOIN marca m ON d.idMarca = m.idMarca "
            + "                                     INNER JOIN tipoDulce t ON d.idTipoDulce = t.idTipoDulce WHERE d.idDulce = ?;";
    final private String SQL_REGISTRAR_DULCE = "INSERT INTO dulce (nombreDulce, precio, sabor, contenidoNeto, existencia, idMarca, idTipoDulce) VALUES (?,?,?,?,?,?,?)";
    final private String SQL_MODIFICAR_MARCA = "UPDATE marca SET nombreMarca = ?, telefono = ?, direccion = ?, correo = ? WHERE idMarca = ?";
    final private String SQL_ELIMINAR_DULCE = "DELETE FROM dulce WHERE idDulce = ?";
    
    public List<BeanDulce> consultarDulces() {
        List<BeanDulce> dulces = new ArrayList();
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_CONSULTAR_DULCES);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanDulce beanDulce = new BeanDulce();
                BeanMarca beanMarca = new BeanMarca();
                BeanTipoDulce beanTipo = new BeanTipoDulce();
                
                beanDulce.setIdDulce(rs.getInt("idDulce"));
                beanDulce.setNombreDulce(rs.getString("nombreDulce"));
                beanDulce.setPrecio(rs.getString("precio"));
                beanDulce.setSabor(rs.getString("sabor"));
                beanDulce.setContenidoNeto(rs.getInt("contenidoNeto"));
                beanDulce.setExistencia(rs.getInt("existencia"));
                
                beanMarca.setIdMarca(rs.getInt("idMarca"));
                beanMarca.setNombreMarca(rs.getString("nombreMarca"));
                beanDulce.setMarca(beanMarca);
                
                beanTipo.setIdTipoDulce(rs.getInt("idTipoDulce"));
                beanTipo.setNombreTipo(rs.getString("nombreTipo"));
                beanDulce.setTipo(beanTipo);
                
                dulces.add(beanDulce);
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método consultarDulces() del DaoDulce -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return dulces;
    }
    
    public BeanDulce consultarDulcePorId(int idDulce) {
        BeanDulce dulceBean = null;
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_CONSULTAR_DULCE_POR_ID);
            pstm.setInt(1, idDulce);
            rs = pstm.executeQuery();
            if (rs.next()) {
                dulceBean = new BeanDulce();
                BeanMarca beanMarca = new BeanMarca();
                BeanTipoDulce beanTipo = new BeanTipoDulce();
                
                dulceBean.setIdDulce(rs.getInt("idDulce"));
                dulceBean.setNombreDulce(rs.getString("nombreDulce"));
                dulceBean.setPrecio(rs.getString("precio"));
                dulceBean.setSabor(rs.getString("sabor"));
                dulceBean.setContenidoNeto(rs.getInt("contenidoNeto"));
                dulceBean.setExistencia(rs.getInt("existencia"));
                
                beanMarca.setIdMarca(rs.getInt("idMarca"));
                beanMarca.setNombreMarca(rs.getString("nombreMarca"));
                dulceBean.setMarca(beanMarca);
                
                beanTipo.setIdTipoDulce(rs.getInt("idTipoDulce"));
                beanTipo.setNombreTipo(rs.getString("nombreTipo"));
                dulceBean.setTipo(beanTipo);
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método consultarDulcePorId() del DaoDulce -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return dulceBean;
    }
    
    public boolean registrarDulce(BeanDulce bean) {
        boolean resultado = false;
        try {           
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_REGISTRAR_DULCE);
            pstm.setString(1, bean.getNombreDulce());
            pstm.setString(2, bean.getPrecio());
            pstm.setString(3, bean.getSabor());
            pstm.setInt(4, bean.getContenidoNeto());
            pstm.setInt(5, bean.getExistencia());
            pstm.setInt(6, bean.getMarca().getIdMarca());
            pstm.setInt(7, bean.getTipo().getIdTipoDulce());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en método registrarDulce() del DaoDulce -> " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }
    
    public boolean eliminarDulce(int idDulce) {
        boolean resultado = false;
        
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_ELIMINAR_DULCE);
            pstm.setInt(1, idDulce);
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método eliminarDulce() del DaoDulce -> " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("No se cerraron conexiones en eliminarDulce() del DaoDulce -> " + e.getMessage());
            }
        }
        return resultado;
    }
    
}
