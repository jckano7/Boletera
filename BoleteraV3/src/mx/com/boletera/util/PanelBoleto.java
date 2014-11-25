/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.boletera.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import mx.com.boletera.model.Posicion;

/**
 *
 * @author jkano
 */
public class PanelBoleto extends JPanel{

    private String texto;
    private List<Posicion> posiciones;
    
    private PanelBoleto() {
    
    }
    
    public PanelBoleto(String texto) {
        this.texto = texto;
    }
    
    public Posicion addPosicion(Integer posicionX, Integer posicionY, 
            Integer colorR, Integer colorG, Integer colorB, Integer tamanio){
        Posicion posicion = new Posicion();
        posicion.setTamanio(tamanio);
        posicion.setColorR(colorR);
        posicion.setColorG(colorG);
        posicion.setColorB(colorB);
        posicion.setPosicionX(posicionX);
        posicion.setPosicionY(posicionY);
        if(posiciones == null){
            posiciones = new ArrayList<>();
        }
        posiciones.add(posicion);
        return posicion;
    }
    
    public void clearPosicion(){
        posiciones = new ArrayList<>();
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g); //To change body of generated methods, choose Tools | Templates.
        if(posiciones!=null){
            for(Posicion posicion : posiciones){
                g.setFont(g.getFont().deriveFont(Font.PLAIN, posicion.getTamanio()));
                g.setColor(new Color(posicion.getColorR(), posicion.getColorG(), posicion.getColorB()));
                g.drawString("TEXTO", posicion.getPosicionX(),posicion.getPosicionY());
            }
        }
    }
    
}
