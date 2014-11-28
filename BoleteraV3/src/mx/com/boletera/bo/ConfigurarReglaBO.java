/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.boletera.bo;

import mx.com.boletera.dao.*;
import mx.com.boletera.model.Regla;

/**
 *
 * @author jcano
 */
public class ConfigurarReglaBO {
    ReglaDAO reglaDAO;
    
    public ConfigurarReglaBO() {
        reglaDAO = new ReglaDAO();
    }
    
    public Regla insertarRegla(Regla regla) throws Exception {
        regla = reglaDAO.insertarRegla(regla);
        return regla;
    }
}
