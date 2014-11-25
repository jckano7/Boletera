/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.boletera.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mx.com.boletera.dao.TirajeDAO;
import mx.com.boletera.dao.TirajeReglaDAO;
import mx.com.boletera.model.Tiraje;
import mx.com.boletera.model.TirajeRegla;
import mx.com.boletera.util.ArchivoPDF;

/**
 *
 * @author jcano
 */
public class ConfigurarTirajeBO {
    TirajeDAO tirajeDAO;
    TirajeReglaDAO tirajeReglaDAO;
    public ConfigurarTirajeBO() {
        tirajeDAO = new TirajeDAO();
        tirajeReglaDAO = new TirajeReglaDAO();
    }
    
    public Tiraje recuperarTiraje(Tiraje tiraje) throws Exception{
        tiraje = tirajeDAO.recuperarTiraje(tiraje);
        return tiraje;
    }
    
    public int guardarTiraje(Tiraje tiraje) throws Exception{
        int res = 0;
        if(tiraje.getIdTiraje() != null && tiraje.getIdTiraje()>0){
            tirajeDAO.insertarTiraje(tiraje);
        }else{
            tirajeDAO.actualizarTiraje(tiraje);
        }
        return res;
    }
    
    public int generarTiraje(Tiraje tiraje, String path) throws Exception{
        int res = 0;
        tiraje = tirajeDAO.recuperarTiraje(tiraje);
        //aplicando reglas de excepcion
        List<String> folios = generarListaFolios(tiraje);
        //aplicar metodo random
        HashMap<Integer, List<String>> foliaje = aplicarTombola(folios, tiraje.getNumFolios());
        //generar archivo
        ArchivoPDF archivo = new ArchivoPDF(foliaje);
        res = archivo.generarPDF(path);
        return res;
    }
    
    public List<String> generarListaFolios(Tiraje tiraje) throws Exception{
        List<String> listaFoliosTotales = new ArrayList<String>();
        List<TirajeRegla> listaReglas = tirajeReglaDAO.buscarReglaPorTiraje(tiraje);
        
        for (Integer x = tiraje.getFolioInicial(); x <= tiraje.getFolioFinal(); x++) {
            String folio = x.toString();
            int num = folio.length();
            for (int i = num; i < tiraje.getNumDigitos(); i++) {
                folio = "0" + folio;
            }
            listaFoliosTotales.add(folio);
        }
        return listaFoliosTotales;
    }
    
    public HashMap<Integer, List<String>> aplicarTombola(List<String> listaFoliosTotales, Integer numFolios) throws Exception{
        HashMap<Integer, List<String>> folios = new HashMap<Integer, List<String>>();
        Integer numBoletos = listaFoliosTotales.size() / numFolios;
        if ((listaFoliosTotales.size() % numFolios) != 0) {
            numBoletos++;
        }
        for (int x = 0; x < numBoletos; x++) {
            List<String> listaFolios = new ArrayList<String>();
            for (int y = 0; y < numFolios; y++) {
                String folio = recuperarFolio(listaFoliosTotales);
                listaFolios.add(folio);
            }
            folios.put(x, listaFolios);
        }
        return folios;
    }
    
    private String recuperarFolio(List<String> listaFoliosTotales) {
        String folio = "";
        if (listaFoliosTotales.size() > 0) {
            Double val = Math.random() * listaFoliosTotales.size();
            int index = val.intValue();
            folio = listaFoliosTotales.remove(index);
        }
        return folio;
    }
}
