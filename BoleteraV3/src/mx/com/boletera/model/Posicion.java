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
public class Posicion {
    private Integer idPosicion;
    private Boleto boleto;
    private Integer posicionX;
    private Integer posicionY;
    private Integer colorR;
    private Integer colorG;
    private Integer colorB;
    private Integer tamanio;

    /**
     * @return the idPosicion
     */
    public Integer getIdPosicion() {
        return idPosicion;
    }

    /**
     * @param idPosicion the idPosicion to set
     */
    public void setIdPosicion(Integer idPosicion) {
        this.idPosicion = idPosicion;
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

    /**
     * @return the posicionX
     */
    public Integer getPosicionX() {
        return posicionX;
    }

    /**
     * @param posicionX the posicionX to set
     */
    public void setPosicionX(Integer posicionX) {
        this.posicionX = posicionX;
    }

    /**
     * @return the posicionY
     */
    public Integer getPosicionY() {
        return posicionY;
    }

    /**
     * @param posicionY the posicionY to set
     */
    public void setPosicionY(Integer posicionY) {
        this.posicionY = posicionY;
    }

    /**
     * @return the colorR
     */
    public Integer getColorR() {
        return colorR;
    }

    /**
     * @param colorR the colorR to set
     */
    public void setColorR(Integer colorR) {
        this.colorR = colorR;
    }

    /**
     * @return the colorG
     */
    public Integer getColorG() {
        return colorG;
    }

    /**
     * @param colorG the colorG to set
     */
    public void setColorG(Integer colorG) {
        this.colorG = colorG;
    }

    /**
     * @return the colorB
     */
    public Integer getColorB() {
        return colorB;
    }

    /**
     * @param colorB the colorB to set
     */
    public void setColorB(Integer colorB) {
        this.colorB = colorB;
    }

    /**
     * @return the tamanio
     */
    public Integer getTamanio() {
        return tamanio;
    }

    /**
     * @param tamanio the tamanio to set
     */
    public void setTamanio(Integer tamanio) {
        this.tamanio = tamanio;
    }
    
}
