/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.boletera.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author jkano
 */
public class Conexion {
    private static Conexion conexion;
    private String servidor;
    private String usuario;
    private String password;
    private String driver;
    private Connection con;
    
    private Conexion() {
        try {
            Properties prop = new Properties();
            InputStream input = null;
            String filename = "resources/jdbc.properties";
            input = getClass().getClassLoader().getResourceAsStream(filename);
            if (input != null) {
                prop.load(input);
                servidor = prop.getProperty("servidor");
                usuario = prop.getProperty("usuario");
                password = prop.getProperty("password");
                driver = prop.getProperty("driver");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error, "+e.getMessage());
        } catch (IOException e) {
            System.out.println("Error, "+e.getMessage());
        }
    }
    
    public static Conexion getConexion(){
        if(conexion == null){
            conexion = new Conexion();
        }
        return conexion;
    }
    
    public Connection getConnection(){
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(servidor, usuario, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Error, "+e.getMessage());
            con = null;
        } catch (SQLException e) {
            System.out.println("Error, "+e.getMessage());
            con = null;
        } catch (Exception e) {
            System.out.println("Error, "+e.getMessage());
            con = null;
        }
        return con;
    }
    
}
