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
import mx.com.boletera.model.Regla;
import mx.com.boletera.model.Tiraje;
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
        //obtener excepciones
        List<Regla> reglas = tirajeReglaDAO.recuperarReglasPorTiraje(tiraje);
        List<Long> minimos = new ArrayList<Long>();
        List<Long> maximos = new ArrayList<Long>();
        for(Regla regla : reglas){
            Long multiplicador = 1L;
            for(int x=0; x<regla.getPosicion();x++){
                multiplicador *= 10;
            }
            Long minimo = regla.getDigito() * multiplicador;
            minimos.add(minimo);
            Long maximo = regla.getDigito()+1 * multiplicador;
            maximos.add(maximo);
        }

        for (Integer folio = tiraje.getFolioInicial(); folio <= tiraje.getFolioFinal(); folio++) {
            //validar excepciones
            boolean valido = true;
            for(int y=0; y < reglas.size(); y++){
                if(folio>=minimos.get(y) && folio<=maximos.get(y)){
                    valido = false;
                    break;
                }
            }
            if(valido){
                String folioStr = folio.toString();
                int num = folioStr.length();
                for (int i = num; i < tiraje.getNumDigitos(); i++) {
                    folioStr = "0" + folioStr;
                }
                listaFoliosTotales.add(folioStr);
            }
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
