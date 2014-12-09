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
import mx.com.boletera.model.Boleto;
import mx.com.boletera.model.Tiraje;
import mx.com.boletera.util.Conexion;

/**
 *
 * @author jcano
 */
public class BoletoDAO {
    
    public Tiraje insertarBoleto(Tiraje tiraje) throws Exception{
        Conexion conexion = Conexion.getConexion();
        Connection con;
        con = conexion.getConnection();
        PreparedStatement pst = null;        
        ResultSet rs = null;
        try {
            String query = "INSERT INTO `boletera`.`boleto`\n" +
"(`id_boleto`,\n" +
"`id_tiraje`,\n" +
"`fecha`)\n" +
"VALUES\n" +
"(<{id_boleto: }>,\n" +
"<{id_tiraje: }>,\n" +
"<{fecha: CURRENT_TIMESTAMP}>);" +
                     "(?, ?, ?, ?)";
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
}
