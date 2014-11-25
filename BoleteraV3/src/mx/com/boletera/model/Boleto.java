/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.boletera.model;

import java.util.Date;

/**
 *
 * @author jkano
 */
public class Boleto {
    private Integer idBoleto;
    private Tiraje tiraje;
    private Date fecha;

    /**
     * @return the idBoleto
     */
    public Integer getIdBoleto() {
        return idBoleto;
    }

    /**
     * @param idBoleto the idBoleto to set
     */
    public void setIdBoleto(Integer idBoleto) {
        this.idBoleto = idBoleto;
    }

    /**
     * @return the tiraje
     */
    public Tiraje getTiraje() {
        return tiraje;
    }

    /**
     * @param tiraje the tiraje to set
     */
    public void setTiraje(Tiraje tiraje) {
        this.tiraje = tiraje;
    }

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
