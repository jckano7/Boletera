/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.boletera.model;

/**
 *
 * @author jkano
 */
public class Folio {
    private String folio;
    private Boleto boleto;

    /**
     * @return the folio
     */
    public String getFolio() {
        return folio;
    }

    /**
     * @param folio the folio to set
     */
    public void setFolio(String folio) {
        this.folio = folio;
    }

    /**
     * @return the boleto
     */
    public Boleto getBoleto() {
        return boleto;
    }

    /**
     * @param boleto the boleto to set
     */
    public void setBoleto(Boleto boleto) {
        this.boleto = boleto;
    }
    
}
