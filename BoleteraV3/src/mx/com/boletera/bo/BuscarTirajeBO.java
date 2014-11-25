/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.boletera.bo;

import java.util.List;
import mx.com.boletera.dao.TirajeDAO;
import mx.com.boletera.model.Tiraje;

/**
 *
 * @author jcano
 */
public class BuscarTirajeBO {
    private TirajeDAO tirajeDAO;

    public BuscarTirajeBO() {
        tirajeDAO = new TirajeDAO();
    }
    
    public List<Tiraje> buscarTirajes(Tiraje tiraje) throws  Exception {
        List<Tiraje> lista = tirajeDAO.buscarTirajes(tiraje);
        return lista;
    }
    
    public Tiraje recuperarTiraje(Tiraje tiraje) throws Exception {
        return tiraje;
    }
}
