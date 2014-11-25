/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.boletera.util;

import java.io.*;

/**
 *
 * @author jckano7
 */
public class ArchivoTXT {
    private char sp = File.separatorChar;
    private String rutaCarpeta = System.getProperty("user.home") + sp + "System" + sp + "Config";
    private String nombreArchivo = sp + "BoletosV2.dll";
    private String txtTextoContrarecibo1;
    private String txtTextoContrarecibo2;
    private String txtTextoContrarecibo3;
    private String txtTextoContrarecibo4;
    private String txtTextoRecibo1;
    private String txtTextoRecibo2;
    private String txtTextoRecibo3;
    private String txtTextoRecibo4;
    private String txtTextoRevez1;
    private String txtTextoRevez2;
    private String txtTextoRevez3;
    private String txtTextoRevez4;
    private String rutaImagenCosto;
    private String rutaImagenLogo;
    private int RLunes;
    private int GLunes;
    private int BLunes;
    private int RMartes;
    private int GMartes;
    private int BMartes;
    private int RMiercoles;
    private int GMiercoles;
    private int BMiercoles;
    private int RJueves;
    private int GJueves;
    private int BJueves;
    private int RViernes;
    private int GViernes;
    private int BViernes;
    private int RSabado;
    private int GSabado;
    private int BSabado;
    private int RDomingo;
    private int GDomingo;
    private int BDomingo;
    
    public ArchivoTXT() {
        this.rutaImagenLogo = "";
        this.rutaImagenCosto = "";
        this.txtTextoContrarecibo1 = "";
        this.txtTextoContrarecibo2 = "";
        this.txtTextoContrarecibo3 = "";
        this.txtTextoContrarecibo4 = "";
        this.txtTextoRecibo1 = "";
        this.txtTextoRecibo2 = "";
        this.txtTextoRecibo3 = "";
        this.txtTextoRecibo4 = "";
        this.txtTextoRevez1 = "";
        this.txtTextoRevez2 = "";
        this.txtTextoRevez3 = "";
        this.txtTextoRevez4 = "";
        this.RLunes = 0;
        this.GLunes = 0;
        this.BLunes = 0;
        this.RMartes = 0;
        this.GMartes = 0;
        this.BMartes = 0;
        this.RMiercoles = 0;
        this.GMiercoles = 0;
        this.BMiercoles = 0;
        this.RJueves = 0;
        this.GJueves = 0;
        this.BJueves = 0;
        this.RViernes = 0;
        this.GViernes = 0;
        this.BViernes = 0;
        this.RSabado = 0;
        this.GSabado = 0;
        this.BSabado = 0;
        this.RDomingo = 0;
        this.GDomingo = 0;
        this.BDomingo = 0;
    }

    public ArchivoTXT(String rutaImagenLogo, String rutaImagenCosto, String txtTextoContrarecibo1, String txtTextoContrarecibo2, String txtTextoContrarecibo3, String txtTextoContrarecibo4, 
            String txtTextoRecibo1, String txtTextoRecibo2, String txtTextoRecibo3, String txtTextoRecibo4, String txtTextoRevez1, String txtTextoRevez2, String txtTextoRevez3, String txtTextoRevez4,
            int RLunes, int GLunes, int BLunes, int RMartes, int GMartes, int BMartes, int RMiercoles, int GMiercoles, int BMiercoles, int RJueves, int GJueves, int BJueves, int RViernes, int GViernes, int BViernes, int RSabado, int GSabado, int BSabado, int RDomingo, int GDomingo, int BDomingo) {
        this.rutaImagenLogo = rutaImagenLogo;
        this.rutaImagenCosto = rutaImagenCosto;
        this.txtTextoContrarecibo1 = txtTextoContrarecibo1;
        this.txtTextoContrarecibo2 = txtTextoContrarecibo2;
        this.txtTextoContrarecibo3 = txtTextoContrarecibo3;
        this.txtTextoContrarecibo4 = txtTextoContrarecibo4;
        this.txtTextoRecibo1 = txtTextoRecibo1;
        this.txtTextoRecibo2 = txtTextoRecibo2;
        this.txtTextoRecibo3 = txtTextoRecibo3;
        this.txtTextoRecibo4 = txtTextoRecibo4;
        this.txtTextoRevez1 = txtTextoRevez1;
        this.txtTextoRevez2 = txtTextoRevez2;
        this.txtTextoRevez3 = txtTextoRevez3;
        this.txtTextoRevez4 = txtTextoRevez4;
        this.RLunes = RLunes;
        this.GLunes = GLunes;
        this.BLunes = BLunes;
        this.RMartes = RMartes;
        this.GMartes = GMartes;
        this.BMartes = BMartes;
        this.RMiercoles = RMiercoles;
        this.GMiercoles = GMiercoles;
        this.BMiercoles = BMiercoles;
        this.RJueves = RJueves;
        this.GJueves = GJueves;
        this.BJueves = BJueves;
        this.RViernes = RViernes;
        this.GViernes = GViernes;
        this.BViernes = BViernes;
        this.RSabado = RSabado;
        this.GSabado = GSabado;
        this.BSabado = BSabado;
        this.RDomingo = RDomingo;
        this.GDomingo = GDomingo;
        this.BDomingo = BDomingo;
    }

    public void generarTXT() {
        FileWriter fichero = null;
        PrintWriter pw = null;
        //validar datos
        try {
            File carpetaFile = new File(getRutaCarpeta());
            if (!carpetaFile.exists()) {
                carpetaFile.mkdirs();
            }
            fichero = new FileWriter(getRutaCarpeta() + getNombreArchivo());
            pw = new PrintWriter(fichero);
            pw.println(getRutaImagenLogo());
            pw.println(getRutaImagenCosto());
            pw.println(getTxtTextoContrarecibo1());
            pw.println(getTxtTextoContrarecibo2());
            pw.println(getTxtTextoContrarecibo3());
            pw.println(getTxtTextoContrarecibo4());
            pw.println(getTxtTextoRecibo1());
            pw.println(getTxtTextoRecibo2());
            pw.println(getTxtTextoRecibo3());
            pw.println(getTxtTextoRecibo4());
            pw.println(getTxtTextoRevez1());
            pw.println(getTxtTextoRevez2());
            pw.println(getTxtTextoRevez3());
            pw.println(getTxtTextoRevez4());
            pw.println(getRLunes());
            pw.println(getGLunes());
            pw.println(getBLunes());
            pw.println(getRMartes());
            pw.println(getGMartes());
            pw.println(getBMartes());
            pw.println(getRMiercoles());
            pw.println(getGMiercoles());
            pw.println(getBMiercoles());
            pw.println(getRJueves());
            pw.println(getGJueves());
            pw.println(getBJueves());
            pw.println(getRViernes());
            pw.println(getGViernes());
            pw.println(getBViernes());
            pw.println(getRSabado());
            pw.println(getGSabado());
            pw.println(getBSabado());
            pw.println(getRDomingo());
            pw.println(getGDomingo());
            pw.println(getBDomingo());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero) {
                    fichero.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void leerTXT() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        try {
            archivo = new File(getRutaCarpeta() + getNombreArchivo());
            if (archivo.exists()) {
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                setRutaImagenLogo(br.readLine());
                setRutaImagenCosto(br.readLine());
                setTxtTextoContrarecibo1(br.readLine());
                setTxtTextoContrarecibo2(br.readLine());
                setTxtTextoContrarecibo3(br.readLine());
                setTxtTextoContrarecibo4(br.readLine());
                setTxtTextoRecibo1(br.readLine());
                setTxtTextoRecibo2(br.readLine());
                setTxtTextoRecibo3(br.readLine());
                setTxtTextoRecibo4(br.readLine());
                setTxtTextoRevez1(br.readLine());
                setTxtTextoRevez2(br.readLine());
                setTxtTextoRevez3(br.readLine());
                setTxtTextoRevez4(br.readLine());
                setRLunes(Integer.parseInt(br.readLine()));
                setGLunes(Integer.parseInt(br.readLine()));
                setBLunes(Integer.parseInt(br.readLine()));
                setRMartes(Integer.parseInt(br.readLine()));
                setGMartes(Integer.parseInt(br.readLine()));
                setBMartes(Integer.parseInt(br.readLine()));
                setRMiercoles(Integer.parseInt(br.readLine()));
                setGMiercoles(Integer.parseInt(br.readLine()));
                setBMiercoles(Integer.parseInt(br.readLine()));
                setRJueves(Integer.parseInt(br.readLine()));
                setGJueves(Integer.parseInt(br.readLine()));
                setBJueves(Integer.parseInt(br.readLine()));
                setRViernes(Integer.parseInt(br.readLine()));
                setGViernes(Integer.parseInt(br.readLine()));
                setBViernes(Integer.parseInt(br.readLine()));
                setRSabado(Integer.parseInt(br.readLine()));
                setGSabado(Integer.parseInt(br.readLine()));
                setBSabado(Integer.parseInt(br.readLine()));
                setRDomingo(Integer.parseInt(br.readLine()));
                setGDomingo(Integer.parseInt(br.readLine()));
                setBDomingo(Integer.parseInt(br.readLine()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /**
     * @return the sp
     */
    public char getSp() {
        return sp;
    }

    /**
     * @param sp the sp to set
     */
    public void setSp(char sp) {
        this.sp = sp;
    }

    /**
     * @return the rutaCarpeta
     */
    public String getRutaCarpeta() {
        return rutaCarpeta;
    }

    /**
     * @param rutaCarpeta the rutaCarpeta to set
     */
    public void setRutaCarpeta(String rutaCarpeta) {
        this.rutaCarpeta = rutaCarpeta;
    }

    /**
     * @return the nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * @param nombreArchivo the nombreArchivo to set
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    /**
     * @return the txtTextoContrarecibo1
     */
    public String getTxtTextoContrarecibo1() {
        return txtTextoContrarecibo1;
    }

    /**
     * @param txtTextoContrarecibo1 the txtTextoContrarecibo1 to set
     */
    public void setTxtTextoContrarecibo1(String txtTextoContrarecibo1) {
        this.txtTextoContrarecibo1 = txtTextoContrarecibo1;
    }

    /**
     * @return the txtTextoContrarecibo2
     */
    public String getTxtTextoContrarecibo2() {
        return txtTextoContrarecibo2;
    }

    /**
     * @param txtTextoContrarecibo2 the txtTextoContrarecibo2 to set
     */
    public void setTxtTextoContrarecibo2(String txtTextoContrarecibo2) {
        this.txtTextoContrarecibo2 = txtTextoContrarecibo2;
    }

    /**
     * @return the txtTextoRecibo1
     */
    public String getTxtTextoRecibo1() {
        return txtTextoRecibo1;
    }

    /**
     * @param txtTextoRecibo1 the txtTextoRecibo1 to set
     */
    public void setTxtTextoRecibo1(String txtTextoRecibo1) {
        this.txtTextoRecibo1 = txtTextoRecibo1;
    }

    /**
     * @return the txtTextoRecibo2
     */
    public String getTxtTextoRecibo2() {
        return txtTextoRecibo2;
    }

    /**
     * @param txtTextoRecibo2 the txtTextoRecibo2 to set
     */
    public void setTxtTextoRecibo2(String txtTextoRecibo2) {
        this.txtTextoRecibo2 = txtTextoRecibo2;
    }

    /**
     * @return the txtTextoRecibo3
     */
    public String getTxtTextoRecibo3() {
        return txtTextoRecibo3;
    }

    /**
     * @param txtTextoRecibo3 the txtTextoRecibo3 to set
     */
    public void setTxtTextoRecibo3(String txtTextoRecibo3) {
        this.txtTextoRecibo3 = txtTextoRecibo3;
    }

    /**
     * @return the txtTextoRecibo4
     */
    public String getTxtTextoRecibo4() {
        return txtTextoRecibo4;
    }

    /**
     * @param txtTextoRecibo4 the txtTextoRecibo4 to set
     */
    public void setTxtTextoRecibo4(String txtTextoRecibo4) {
        this.txtTextoRecibo4 = txtTextoRecibo4;
    }

    /**
     * @return the txtTextoRevez1
     */
    public String getTxtTextoRevez1() {
        return txtTextoRevez1;
    }

    /**
     * @param txtTextoRevez1 the txtTextoRevez1 to set
     */
    public void setTxtTextoRevez1(String txtTextoRevez1) {
        this.txtTextoRevez1 = txtTextoRevez1;
    }

    /**
     * @return the txtTextoRevez2
     */
    public String getTxtTextoRevez2() {
        return txtTextoRevez2;
    }

    /**
     * @param txtTextoRevez2 the txtTextoRevez2 to set
     */
    public void setTxtTextoRevez2(String txtTextoRevez2) {
        this.txtTextoRevez2 = txtTextoRevez2;
    }

    /**
     * @return the txtTextoRevez3
     */
    public String getTxtTextoRevez3() {
        return txtTextoRevez3;
    }

    /**
     * @param txtTextoRevez3 the txtTextoRevez3 to set
     */
    public void setTxtTextoRevez3(String txtTextoRevez3) {
        this.txtTextoRevez3 = txtTextoRevez3;
    }

    /**
     * @return the txtTextoRevez4
     */
    public String getTxtTextoRevez4() {
        return txtTextoRevez4;
    }

    /**
     * @param txtTextoRevez4 the txtTextoRevez4 to set
     */
    public void setTxtTextoRevez4(String txtTextoRevez4) {
        this.txtTextoRevez4 = txtTextoRevez4;
    }
    
    /**
     * @return the RLunes
     */
    public int getRLunes() {
        return RLunes;
    }

    /**
     * @param RLunes the RLunes to set
     */
    public void setRLunes(int RLunes) {
        this.RLunes = RLunes;
    }

    /**
     * @return the GLunes
     */
    public int getGLunes() {
        return GLunes;
    }

    /**
     * @param GLunes the GLunes to set
     */
    public void setGLunes(int GLunes) {
        this.GLunes = GLunes;
    }

    /**
     * @return the BLunes
     */
    public int getBLunes() {
        return BLunes;
    }

    /**
     * @param BLunes the BLunes to set
     */
    public void setBLunes(int BLunes) {
        this.BLunes = BLunes;
    }

    /**
     * @return the RMartes
     */
    public int getRMartes() {
        return RMartes;
    }

    /**
     * @param RMartes the RMartes to set
     */
    public void setRMartes(int RMartes) {
        this.RMartes = RMartes;
    }

    /**
     * @return the GMartes
     */
    public int getGMartes() {
        return GMartes;
    }

    /**
     * @param GMartes the GMartes to set
     */
    public void setGMartes(int GMartes) {
        this.GMartes = GMartes;
    }

    /**
     * @return the BMartes
     */
    public int getBMartes() {
        return BMartes;
    }

    /**
     * @param BMartes the BMartes to set
     */
    public void setBMartes(int BMartes) {
        this.BMartes = BMartes;
    }

    /**
     * @return the RMiercoles
     */
    public int getRMiercoles() {
        return RMiercoles;
    }

    /**
     * @param RMiercoles the RMiercoles to set
     */
    public void setRMiercoles(int RMiercoles) {
        this.RMiercoles = RMiercoles;
    }

    /**
     * @return the GMiercoles
     */
    public int getGMiercoles() {
        return GMiercoles;
    }

    /**
     * @param GMiercoles the GMiercoles to set
     */
    public void setGMiercoles(int GMiercoles) {
        this.GMiercoles = GMiercoles;
    }

    /**
     * @return the BMiercoles
     */
    public int getBMiercoles() {
        return BMiercoles;
    }

    /**
     * @param BMiercoles the BMiercoles to set
     */
    public void setBMiercoles(int BMiercoles) {
        this.BMiercoles = BMiercoles;
    }

    /**
     * @return the RJueves
     */
    public int getRJueves() {
        return RJueves;
    }

    /**
     * @param RJueves the RJueves to set
     */
    public void setRJueves(int RJueves) {
        this.RJueves = RJueves;
    }

    /**
     * @return the GJueves
     */
    public int getGJueves() {
        return GJueves;
    }

    /**
     * @param GJueves the GJueves to set
     */
    public void setGJueves(int GJueves) {
        this.GJueves = GJueves;
    }

    /**
     * @return the BJueves
     */
    public int getBJueves() {
        return BJueves;
    }

    /**
     * @param BJueves the BJueves to set
     */
    public void setBJueves(int BJueves) {
        this.BJueves = BJueves;
    }

    /**
     * @return the RViernes
     */
    public int getRViernes() {
        return RViernes;
    }

    /**
     * @param RViernes the RViernes to set
     */
    public void setRViernes(int RViernes) {
        this.RViernes = RViernes;
    }

    /**
     * @return the GViernes
     */
    public int getGViernes() {
        return GViernes;
    }

    /**
     * @param GViernes the GViernes to set
     */
    public void setGViernes(int GViernes) {
        this.GViernes = GViernes;
    }

    /**
     * @return the BViernes
     */
    public int getBViernes() {
        return BViernes;
    }

    /**
     * @param BViernes the BViernes to set
     */
    public void setBViernes(int BViernes) {
        this.BViernes = BViernes;
    }

    /**
     * @return the RSabado
     */
    public int getRSabado() {
        return RSabado;
    }

    /**
     * @param RSabado the RSabado to set
     */
    public void setRSabado(int RSabado) {
        this.RSabado = RSabado;
    }

    /**
     * @return the GSabado
     */
    public int getGSabado() {
        return GSabado;
    }

    /**
     * @param GSabado the GSabado to set
     */
    public void setGSabado(int GSabado) {
        this.GSabado = GSabado;
    }

    /**
     * @return the BSabado
     */
    public int getBSabado() {
        return BSabado;
    }

    /**
     * @param BSabado the BSabado to set
     */
    public void setBSabado(int BSabado) {
        this.BSabado = BSabado;
    }

    /**
     * @return the RDomingo
     */
    public int getRDomingo() {
        return RDomingo;
    }

    /**
     * @param RDomingo the RDomingo to set
     */
    public void setRDomingo(int RDomingo) {
        this.RDomingo = RDomingo;
    }

    /**
     * @return the GDomingo
     */
    public int getGDomingo() {
        return GDomingo;
    }

    /**
     * @param GDomingo the GDomingo to set
     */
    public void setGDomingo(int GDomingo) {
        this.GDomingo = GDomingo;
    }

    /**
     * @return the BDomingo
     */
    public int getBDomingo() {
        return BDomingo;
    }

    /**
     * @param BDomingo the BDomingo to set
     */
    public void setBDomingo(int BDomingo) {
        this.BDomingo = BDomingo;
    }

    /**
     * @return the txtTextoContrarecibo3
     */
    public String getTxtTextoContrarecibo3() {
        return txtTextoContrarecibo3;
    }

    /**
     * @param txtTextoContrarecibo3 the txtTextoContrarecibo3 to set
     */
    public void setTxtTextoContrarecibo3(String txtTextoContrarecibo3) {
        this.txtTextoContrarecibo3 = txtTextoContrarecibo3;
    }

    /**
     * @return the txtTextoContrarecibo4
     */
    public String getTxtTextoContrarecibo4() {
        return txtTextoContrarecibo4;
    }

    /**
     * @param txtTextoContrarecibo4 the txtTextoContrarecibo4 to set
     */
    public void setTxtTextoContrarecibo4(String txtTextoContrarecibo4) {
        this.txtTextoContrarecibo4 = txtTextoContrarecibo4;
    }

    /**
     * @return the rutaImagenCosto
     */
    public String getRutaImagenCosto() {
        return rutaImagenCosto;
    }

    /**
     * @param rutaImagenCosto the rutaImagenCosto to set
     */
    public void setRutaImagenCosto(String rutaImagenCosto) {
        this.rutaImagenCosto = rutaImagenCosto;
    }

    /**
     * @return the rutaImagenLogo
     */
    public String getRutaImagenLogo() {
        return rutaImagenLogo;
    }

    /**
     * @param rutaImagenLogo the rutaImagenLogo to set
     */
    public void setRutaImagenLogo(String rutaImagenLogo) {
        this.rutaImagenLogo = rutaImagenLogo;
    }

}
