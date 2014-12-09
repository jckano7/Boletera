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
import mx.com.boletera.model.Tiraje;
import mx.com.boletera.util.Conexion;

/**
 *
 * @author jcano
 */
public class TirajeDAO {
    
    public List<Tiraje> buscarTirajes(Tiraje tiraje){
        Conexion conexion = Conexion.getConexion();
        List<Tiraje> tirajes = null;
        Connection con = null;
        PreparedStatement pst = null;        
        ResultSet rs = null;
        try {
            String query = "SELECT id_tiraje, "
                    + "folio_inicial, "
                    + "folio_final, "
                    + "numero_digitos, "
                    + "numero_folios "
                    + "FROM boletera.tiraje";
            con = conexion.getConnection();
            pst = con.prepareStatement(query);
            //pst.setInt(1, 1001);
            rs = pst.executeQuery();
            tirajes = new ArrayList<>();
            while (rs.next()) {
                Tiraje item = new Tiraje();
                item.setIdTiraje(rs.getInt(1));
                item.setFolioInicial(rs.getInt(2));
                item.setFolioFinal(rs.getInt(3));
                item.setNumDigitos(rs.getInt(4));
                item.setNumFolios(rs.getInt(5));
                tirajes.add(item);
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
        return tirajes;
    }
    
    public Tiraje insertarTiraje(Tiraje tiraje) throws Exception{
        Conexion conexion = Conexion.getConexion();
        Connection con;
        con = conexion.getConnection();
        PreparedStatement pst = null;        
        ResultSet rs = null;
        try {
            String query = "INSERT INTO boletera.tiraje "
                    + "(folio_inicial, "
                    + "folio_final, "
                    + "numero_digitos, "
                    + "numero_folios) "
                    + "VALUES "
                    + "(?, ?, ?, ?)";
            pst = con.prepareStatement(query);
            pst.setInt(1,tiraje.getFolioInicial());
            pst.setInt(2,tiraje.getFolioFinal());
            pst.setInt(3,tiraje.getNumDigitos());
            pst.setInt(4,tiraje.getNumFolios());
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Tirajes insertados: " + rowsUpdated);
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
    
    public Tiraje actualizarTiraje(Tiraje tiraje) throws Exception{
        Conexion conexion = Conexion.getConexion();
        Connection con;
        con = conexion.getConnection();
        PreparedStatement pst = null;        
        ResultSet rs = null;
        try {
            String query = "UPDATE boletera.tiraje SET " + 
                "id_tiraje = ?, " +
                "folio_inicial = ?, " +
                "folio_final = ?, " +
                "numero_digitos = ?, " +
                "numero_folios = ? " +
                "WHERE id_tiraje = ?";
            pst = con.prepareStatement(query);
            pst.setInt(1,tiraje.getFolioInicial());
            pst.setInt(1,tiraje.getFolioFinal());
            pst.setInt(1,tiraje.getNumDigitos());
            pst.setInt(1,tiraje.getNumFolios());
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Tirajes actualizados: " + rowsUpdated);
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
        
    public Tiraje recuperarTiraje(Tiraje tiraje) throws Exception{
        Conexion conexion = Conexion.getConexion();
        Connection con;
        con = conexion.getConnection();
        PreparedStatement pst = null;        
        ResultSet rs = null;
        try {
            String query = "SELECT id_tiraje, "
                    + "folio_inicial, "
                    + "folio_final, "
                    + "numero_digitos, "
                    + "numero_folios "
                    + "FROM boletera.tiraje;";
            pst = con.prepareStatement(query);
            pst.setInt(1,tiraje.getIdTiraje());
            rs = pst.executeQuery();
            while (rs.next()) {
                tiraje.setIdTiraje(rs.getInt(1));
                tiraje.setFolioInicial(rs.getInt(2));
                tiraje.setFolioFinal(rs.getInt(3));
                tiraje.setNumDigitos(rs.getInt(4));
                tiraje.setNumFolios(rs.getInt(5));
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
    
}
