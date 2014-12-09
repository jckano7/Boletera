/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.boletera.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.com.boletera.model.Regla;
import mx.com.boletera.model.Tiraje;
import mx.com.boletera.model.TirajeRegla;
import mx.com.boletera.util.Conexion;

/**
 *
 * @author jcano
 */
public class TirajeReglaDAO {
    
    public Tiraje insertarTirajeRegla(Tiraje tiraje) throws Exception{
        Conexion conexion = Conexion.getConexion();
        Connection con;
        con = conexion.getConnection();
        PreparedStatement pst = null;        
        ResultSet rs = null;
        try {
            String query = "INSERT INTO `boletera`.`tiraje` (`folio_inicial`, `folio_final`, `numero_digitos`, `numero_folios`) VALUES ('1000', '2000', '4', '4')";
            pst = con.prepareStatement(query);
            pst.setInt(1,tiraje.getFolioInicial());
            pst.setInt(1,tiraje.getFolioFinal());
            pst.setInt(1,tiraje.getNumDigitos());
            pst.setInt(1,tiraje.getNumFolios());
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null){
                    rs.close();
                }
                if(pst != null){
                    pst.close();
                }
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tiraje;
    }
    
    public List<Regla> recuperarReglasNoTiraje(Tiraje tiraje){
        Conexion conexion = Conexion.getConexion();
        List<Regla> reglas = null;
        Connection con = null;
        PreparedStatement pst = null;        
        ResultSet rs = null;
        try {
            String query = "SELECT regla.id_regla, " +
                "regla.digito, " +
                "regla.posicion " +
                "FROM boletera.regla ";
            con = conexion.getConnection();
            pst = con.prepareStatement(query);
            //pst.setInt(1, 1001);
            rs = pst.executeQuery();
            reglas = new ArrayList<>();
            while (rs.next()) {
                Regla regla = new Regla();
                regla.setIdRegla(rs.getInt(1));
                regla.setDigito(rs.getInt(2));
                regla.setPosicion(rs.getInt(3));
                reglas.add(regla);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null){
                    rs.close();
                }
                if(pst != null){
                    pst.close();
                }
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return reglas;
    }    
    
    
    public List<Regla> recuperarReglasPorTiraje(Tiraje tiraje){
        Conexion conexion = Conexion.getConexion();
        List<Regla> reglas = null;
        Connection con = null;
        PreparedStatement pst = null;        
        ResultSet rs = null;
        try {
            String query = "SELECT regla.id_regla,\n" +
"    regla.digito,\n" +
"    regla.posicion\n" +
"FROM boletera.regla;";
            con = conexion.getConnection();
            pst = con.prepareStatement(query);
            //pst.setInt(1, 1001);
            rs = pst.executeQuery();
            reglas = new ArrayList<>();
            while (rs.next()) {
                Regla regla = new Regla();
                regla.setIdRegla(rs.getInt(1));
                regla.setDigito(rs.getInt(2));
                regla.setPosicion(rs.getInt(3));
                reglas.add(regla);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(rs != null){
                    rs.close();
                }
                if(pst != null){
                    pst.close();
                }
                if(con != null){
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return reglas;
    }
}
