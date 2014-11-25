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
    
    public List<TirajeRegla> buscarReglaPorTiraje(Tiraje tiraje){
        Conexion conexion = Conexion.getConexion();
        List<TirajeRegla> tirajes = null;
        Connection con = null;
        PreparedStatement pst = null;        
        ResultSet rs = null;
        try {
            String query = "SELECT tiraje.id_tiraje, "
                    + "tiraje.folio_inicial, "
                    + "tiraje.folio_final, "
                    + "tiraje.numero_digitos, "
                    + "tiraje.numero_folios "
                    + "FROM boletera.tiraje;";
            con = conexion.getConnection();
            pst = con.prepareStatement(query);
            //pst.setInt(1, 1001);
            rs = pst.executeQuery();
            tirajes = new ArrayList<>();
            while (rs.next()) {
                TirajeRegla item = new TirajeRegla();
                //Tiraje tiraje = new Tiraje();
                Regla regla = new Regla();
                item.setRegla(regla);
                //item.setTiraje(tiraje);
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
    
    public Tiraje actualizarTiraje(Tiraje tiraje) throws Exception{
        Conexion conexion = Conexion.getConexion();
        Connection con;
        con = conexion.getConnection();
        PreparedStatement pst = null;        
        ResultSet rs = null;
        try {
            String query = "UPDATE `boletera`.`tiraje`\n" +
"SET\n" +
"`id_tiraje` = <{id_tiraje: }>,\n" +
"`folio_inicial` = <{folio_inicial: }>,\n" +
"`folio_final` = <{folio_final: }>,\n" +
"`numero_digitos` = <{numero_digitos: }>,\n" +
"`numero_folios` = <{numero_folios: }>\n" +
"WHERE `id_tiraje` = <{expr}>;";
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
        
    public Tiraje recuperarTiraje(Tiraje tiraje) throws Exception{
        Conexion conexion = Conexion.getConexion();
        Connection con;
        con = conexion.getConnection();
        PreparedStatement pst = null;        
        ResultSet rs = null;
        try {
            String query = "SELECT tiraje.id_tiraje, "
                    + "tiraje.folio_inicial, "
                    + "tiraje.folio_final, "
                    + "tiraje.numero_digitos, "
                    + "tiraje.numero_folios "
                    + "FROM boletera.tiraje;";
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
}
