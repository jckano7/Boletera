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
import mx.com.boletera.util.Conexion;

/**
 *
 * @author jcano
 */
public class ReglaDAO {
    
    public Regla insertarRegla(Regla regla) throws Exception{
        Conexion conexion = Conexion.getConexion();
        Connection con;
        con = conexion.getConnection();
        PreparedStatement pst = null;        
        ResultSet rs = null;
        try {
            String query = "INSERT INTO boletera.regla " +
                "(digito, " +
                "posicion) " +
                "VALUES " +
                "(?, ?)";
            pst = con.prepareStatement(query);
            pst.setInt(1,regla.getDigito());
            pst.setInt(2,regla.getPosicion());
            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Reglas insertadas: " + rowsUpdated);
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
        return regla;
    }
    
}
