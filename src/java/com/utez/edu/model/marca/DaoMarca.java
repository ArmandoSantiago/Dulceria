/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.utez.edu.model.marca;

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
public class DaoMarca {
    
    private Connection conexion;
    private PreparedStatement pstm;
    private ResultSet rs;

    final private String SQL_CONSULTAR_MARCAS = "SELECT * FROM marca;";
    final private String SQL_CONSULTAR_MARCA_POR_ID = "SELECT * FROM marca WHERE idMarca = ?;";
    final private String SQL_REGISTRAR_MARCA = "INSERT INTO marca (nombreMarca, telefono, direccion, correo) VALUES (?,?,?,?)";
    final private String SQL_MODIFICAR_MARCA = "UPDATE marca SET nombreMarca = ?, telefono = ?, direccion = ?, correo = ? WHERE idMarca = ?";
    final private String SQL_ELIMINAR_MARCA = "DELETE FROM marca WHERE idMarca = ?";
    
    //---------------------------------------------------
    public List<BeanMarca> consultarMarcas() {
        List<BeanMarca> marcas = new ArrayList();
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_CONSULTAR_MARCAS);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanMarca bean = new BeanMarca();
                bean.setIdMarca(rs.getInt("idMarca"));
                bean.setNombreMarca(rs.getString("nombreMarca"));
                bean.setTelefono(rs.getString("telefono"));
                bean.setDireccion(rs.getString("direccion"));
                bean.setCorreo(rs.getString("correo"));
                marcas.add(bean);
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método consultarMarcas() del DaoMarca -> " + e.getMessage());
        } finally {
            try {
                rs.close();
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return marcas;
    }
    
    public BeanMarca consultarMarcaPorId(int idMarca) {
        BeanMarca bean = null;
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_CONSULTAR_MARCA_POR_ID);
            pstm.setInt(1, idMarca);
            rs = pstm.executeQuery();
            if (rs.next()) {
                bean = new BeanMarca();
                bean.setIdMarca(rs.getInt("idMarca"));
                bean.setNombreMarca(rs.getString("nombreMarca"));
                bean.setTelefono(rs.getString("telefono"));
                bean.setDireccion(rs.getString("direccion"));
                bean.setCorreo(rs.getString("correo"));
            }
            rs.close();
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método consultarMarcaPorId() del DaoMarca -> " + e.getMessage());
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

    public boolean registrarMarca(BeanMarca bean) {
        boolean resultado = false;
        try {           
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_REGISTRAR_MARCA);
            pstm.setString(1, bean.getNombreMarca());
            pstm.setString(2, bean.getTelefono());
            pstm.setString(3, bean.getDireccion());
            pstm.setString(4, bean.getCorreo());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error en método registrarMarca() del DaoMarca -> " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }

    public boolean modificarMarca(BeanMarca bean) {
        boolean resultado = false;
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_MODIFICAR_MARCA);
            pstm.setString(1, bean.getNombreMarca());
            pstm.setString(2, bean.getTelefono());
            pstm.setString(3, bean.getDireccion());
            pstm.setString(4, bean.getCorreo());
            pstm.setInt(5, bean.getIdMarca());
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método modificarMarca() del DaoMarca -> " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {

            }
        }
        return resultado;
    }

    public boolean eliminarMarca(int idMarca) {
        boolean resultado = false;
        
        try {
            conexion = ConexionMySQL.getConexion();
            pstm = conexion.prepareStatement(SQL_ELIMINAR_MARCA);
            pstm.setInt(1, idMarca);
            resultado = pstm.executeUpdate() == 1;
            pstm.close();
            conexion.close();
        } catch (Exception e) {
            System.out.println("Error en método eliminarMarca() del DaoMarca -> " + e.getMessage());
        } finally {
            try {
                pstm.close();
                conexion.close();
            } catch (Exception e) {
                System.out.println("No se cerraron conexiones en eliminarMarca() del DaoMarca -> " + e.getMessage());
            }
        }
        return resultado;
    }
    //---------------------------------------------------
}
