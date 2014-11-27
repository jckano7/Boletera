/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.boletera.util;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jckano7
 */
public class ArchivoPDF {
    
    //private Integer folioInicial;
    //private Integer folioFinal;
    private HashMap<Integer, List<String>> folios;
    
    //private int numDigitos;
    //private int numFolios;
    //private int numTotalFolios;
    private int numBoletos;
    private int dia;
    private ArchivoTXT pw;
    private float height = 190;
    
    public ArchivoPDF() {
        //this.folioInicial = 0;
        //this.folioFinal = 0;
        this.folios = new HashMap<>();
        //this.numDigitos = 0;
        //this.numFolios = 0;
        this.dia = 0;
        //this.numTotalFolios = 0;
        this.numBoletos = 0;
        this.pw = new ArchivoTXT();
        this.pw.leerTXT();
    }
    
    public ArchivoPDF(HashMap<Integer, List<String>> folios) {
        //this.folioInicial = folioInicial;
        //this.folioFinal = folioFinal;
        //this.numDigitos = numDigitos;
        //this.numFolios = numFolios;
        //this.dia = dia;
        this.folios = folios;
        //this.numTotalFolios = this.folioFinal - this.folioInicial;
        //this.numBoletos = this.numTotalFolios / this.numFolios;
        //if ((this.numTotalFolios % this.numFolios) != 0) {
        //    this.numBoletos++;
        //}
        this.pw = new ArchivoTXT();
        this.pw.leerTXT();
    }
    
    /*public ArchivoPDF(Integer folioInicial, Integer folioFinal, int numDigitos, int numFolios, int dia) {
        this.folioInicial = folioInicial;
        this.folioFinal = folioFinal;
        this.numDigitos = numDigitos;
        this.numFolios = numFolios;
        this.dia = dia;
        this.folios = new HashMap<Integer, List<String>>();
        this.numTotalFolios = this.folioFinal - this.folioInicial;
        this.numBoletos = this.numTotalFolios / this.numFolios;
        if ((this.numTotalFolios % this.numFolios) != 0) {
            this.numBoletos++;
        }
        this.pw = new ArchivoTXT();
        this.pw.leerTXT();
    }*/
    
    public int generarPDF(String path) {
        int res = 0;
        try {
            //this.generarLista();
            Document documento = new Document(PageSize.LETTER, 10, 10, 10, 10);
            if (!path.endsWith(".pdf")) {
                path += ".pdf";
            }
            File file = new File(path);
            FileOutputStream ficheroPdf = new FileOutputStream(file);
            PdfWriter writer = PdfWriter.getInstance(documento, ficheroPdf);
            writer.setInitialLeading(10);
            documento.open();
            documento.add(getTablaFrontal());
            documento.newPage();
            documento.add(getTablaRevez());
            documento.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;
    }
    
    private PdfPTable getTablaFrontal() throws DocumentException{
        PdfPTable tblGralFrontal = new PdfPTable(3);
        tblGralFrontal.setWidthPercentage(100);
        tblGralFrontal.setWidths(new int[]{3, 1, 8});
        for (int i = 0; i < this.numBoletos; i++) {
            //PdfPCell celdaGeneral = getCelda(1, 0, 1, Chunk.ALIGN_MIDDLE);
            
            //PdfPTable tblFrontal = new PdfPTable(3);
            //float[] array = {144, 72, 72};
            
            //tblGralFrontal.setWidthPercentage(100);
            //tblGralFrontal.setWidths(new int[]{3, 1, 8});

            PdfPCell celdaContrareciboFrente = getCeldaContrareciboFrente(i);
            celdaContrareciboFrente.setMinimumHeight(height);
            tblGralFrontal.addCell(celdaContrareciboFrente);

            PdfPCell celdaHuellaFrente = getCeldaHuellaFrente();
            celdaHuellaFrente.setMinimumHeight(height);
            tblGralFrontal.addCell(celdaHuellaFrente);
            
            PdfPCell celdaReciboFrente = getCeldaReciboFrente(i);
            celdaReciboFrente.setMinimumHeight(height);
            tblGralFrontal.addCell(celdaReciboFrente);
            
            //celdaGeneral.addElement(tblFrontal);
            //tblGralFrontal.addCell(celdaGeneral);
        }
        return tblGralFrontal;
    }
    
    private PdfPTable getTablaRevez(){
        //REVEZ
        PdfPTable tblGralTrasera = new PdfPTable(3);
        tblGralTrasera.setWidthPercentage(100);
        for (int i = 0; i < this.numBoletos; i++) {
            //Leyendas
            PdfPCell cDerecha = getCelda(2, 10, 0, Chunk.ALIGN_MIDDLE);

            Paragraph pTexto1 = new Paragraph(this.pw.getTxtTextoRevez1(),
                    FontFactory.getFont("Arial", 10, Font.NORMAL, BaseColor.BLACK));
            pTexto1.setAlignment(Chunk.ALIGN_CENTER);
            Paragraph pTexto2 = new Paragraph(this.pw.getTxtTextoRevez2(),
                    FontFactory.getFont("Arial", 10, Font.NORMAL, BaseColor.BLACK));
            pTexto2.setAlignment(Chunk.ALIGN_CENTER);
            Paragraph pTexto3 = new Paragraph(this.pw.getTxtTextoRevez3(),
                    FontFactory.getFont("Arial", 8, Font.NORMAL, BaseColor.BLACK));
            pTexto3.setAlignment(Chunk.ALIGN_CENTER);
            Paragraph pTexto4 = new Paragraph(this.pw.getTxtTextoRevez4(),
                    FontFactory.getFont("Arial", 9, Font.NORMAL, BaseColor.BLACK));
            pTexto4.setAlignment(Chunk.ALIGN_CENTER);
            cDerecha.addElement(pTexto1);
            cDerecha.addElement(pTexto2);
            cDerecha.addElement(pTexto3);
            cDerecha.addElement(pTexto4);

            tblGralTrasera.addCell(cDerecha);

            PdfPCell cIzquierda = getCelda(1, 10, 0, Chunk.ALIGN_MIDDLE);
            cIzquierda.setMinimumHeight(height);
            tblGralTrasera.addCell(cIzquierda);
        }
        return tblGralTrasera;
    }
    
    private PdfPCell getCeldaContrareciboFrente(int i) {
        Paragraph blanco = new Paragraph(" ",
                FontFactory.getFont("Arial", 8, Font.NORMAL, BaseColor.BLACK));
        blanco.setAlignment(Chunk.ALIGN_LEFT);
        PdfPCell cDerecha = getCelda(1, 10, 0, Chunk.ALIGN_MIDDLE);

        PdfPTable tblDerecha = new PdfPTable(4);
        tblDerecha.setWidthPercentage(100);

        PdfPCell cTexto1 = getCelda(2, 0, 0, Chunk.ALIGN_LEFT);

        Paragraph pTexto1 = new Paragraph(this.pw.getTxtTextoRecibo1(),
                FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK));
        pTexto1.setAlignment(Chunk.ALIGN_LEFT);
        cTexto1.addElement(pTexto1);
        tblDerecha.addCell(cTexto1);
        PdfPCell cTexto11 = getCelda(2, 0, 0, Chunk.ALIGN_MIDDLE);

        cTexto11.setBorderWidthBottom(1);
        cTexto11.addElement(blanco);
        tblDerecha.addCell(cTexto11);
        PdfPCell cTexto12 = getCelda(4, 0, 0, Chunk.ALIGN_LEFT);

        cTexto12.setBorderWidthBottom(1);
        cTexto12.addElement(blanco);
        tblDerecha.addCell(cTexto12);

        PdfPCell cTexto2 = getCelda(2, 0, 0, Chunk.ALIGN_LEFT);

        Paragraph pTexto2 = new Paragraph(this.pw.getTxtTextoRecibo2(),
                FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK));
        pTexto2.setAlignment(Chunk.ALIGN_LEFT);
        cTexto2.addElement(pTexto2);
        tblDerecha.addCell(cTexto2);

        PdfPCell cTexto21 = getCelda(2, 0, 0, Chunk.ALIGN_LEFT);

        cTexto21.setBorderWidthBottom(1);
        cTexto21.addElement(blanco);
        tblDerecha.addCell(cTexto21);

        PdfPCell cTexto22 = getCelda(4, 0, 0, Chunk.ALIGN_LEFT);

        cTexto22.setBorderWidthBottom(1);
        cTexto22.addElement(blanco);
        tblDerecha.addCell(cTexto22);

        PdfPCell cTexto3 = getCelda(2, 0, 0, Chunk.ALIGN_LEFT);

        Paragraph pTexto3 = new Paragraph(this.pw.getTxtTextoRecibo3(),
                FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK));
        pTexto3.setAlignment(Chunk.ALIGN_LEFT);
        cTexto3.addElement(pTexto3);
        tblDerecha.addCell(cTexto3);

        PdfPCell cTexto31 = getCelda(2, 0, 0, Chunk.ALIGN_LEFT);

        cTexto31.setBorderWidthBottom(1);
        cTexto31.addElement(blanco);
        tblDerecha.addCell(cTexto31);

        PdfPCell cTexto32 = getCelda(4, 0, 0, Chunk.ALIGN_LEFT);

        cTexto32.setBorderWidthBottom(1);
        cTexto32.addElement(blanco);
        tblDerecha.addCell(cTexto32);

        PdfPCell cTexto4 = getCelda(2, 0, 0, Chunk.ALIGN_LEFT);

        Paragraph pTexto4 = new Paragraph(this.pw.getTxtTextoRecibo4(),
                FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK));
        pTexto4.setAlignment(Chunk.ALIGN_LEFT);
        cTexto4.addElement(pTexto4);
        tblDerecha.addCell(cTexto4);

        PdfPCell cTexto41 = getCelda(2, 0, 0, Chunk.ALIGN_LEFT);

        cTexto41.setBorderWidthBottom(1);
        cTexto41.addElement(blanco);
        tblDerecha.addCell(cTexto41);

        PdfPCell cTexto42 = getCelda(4, 0, 0, Chunk.ALIGN_LEFT);

        cTexto42.setBorderWidthBottom(1);
        cTexto42.addElement(blanco);
        tblDerecha.addCell(cTexto42);

        List<String> folioses = this.folios.get(i);
        if(folioses.size()%2!=0){
            folioses.add("");
        }
        for (String folio : folioses) {
            PdfPCell cFolio = getCelda(2, 0, 0, Chunk.ALIGN_LEFT);
            Paragraph pFolio = new Paragraph(folio,
                    FontFactory.getFont("Arial", 9, Font.BOLD, recuperarColor()));
            pFolio.setAlignment(Chunk.ALIGN_CENTER);
            cFolio.addElement(pFolio);
            tblDerecha.addCell(cFolio);
        }
        cDerecha.addElement(tblDerecha);
        return cDerecha;
    }
    
        
    private PdfPCell getCeldaHuellaFrente() {
        Paragraph blanco = new Paragraph(" ",
                FontFactory.getFont("Arial", 8, Font.NORMAL, BaseColor.BLACK));
        blanco.setAlignment(Chunk.ALIGN_MIDDLE);
        PdfPCell cCentro = getCelda(1, 10, 0, Chunk.ALIGN_MIDDLE);
        PdfPTable tblCentro = new PdfPTable(1);
        PdfPCell cHuella = getCelda(0, 2, 2, Chunk.ALIGN_CENTER);
        //cHuella.setMinimumHeight();
        cHuella.addElement(blanco);
        tblCentro.addCell(cHuella);
        cCentro.addElement(tblCentro);
        return cCentro;
    }
    
        
    private PdfPCell getCeldaReciboFrente(int i) {
        PdfPCell cIzquierda = getCelda(2, 20, 0, Chunk.ALIGN_MIDDLE);
        PdfPTable tblIzquierda = new PdfPTable(4);
        tblIzquierda.setWidthPercentage(100);

        PdfPCell cImagen = getCelda(4, 0, 0, Chunk.ALIGN_MIDDLE);

        if (this.pw.getRutaImagenLogo() != null && !this.pw.getRutaImagenLogo().equals("")) {
            try {
                Image img = Image.getInstance(this.pw.getRutaImagenLogo());
                img.scaleToFit(150f, 21f);
                img.setAlignment(Chunk.ALIGN_MIDDLE);
                cImagen.setRowspan(2);
                cImagen.setMinimumHeight(23);
                cImagen.addElement(img);
            } catch (BadElementException ex) {
                Logger.getLogger(ArchivoPDF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ArchivoPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        Paragraph pTitulo1 = new Paragraph(this.pw.getTxtTextoContrarecibo1(),
                FontFactory.getFont("Arial", 12, Font.BOLD, BaseColor.BLACK));
        pTitulo1.setAlignment(Chunk.ALIGN_CENTER);

        cImagen.addElement(pTitulo1);

        Paragraph pTitulo2 = new Paragraph(this.pw.getTxtTextoContrarecibo2(),
                FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK));
        pTitulo2.setAlignment(Chunk.ALIGN_CENTER);

        cImagen.addElement(pTitulo2);

        Paragraph pTextoC1 = new Paragraph(this.pw.getTxtTextoContrarecibo3(),
                FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK));
        pTextoC1.setAlignment(Chunk.ALIGN_CENTER);

        cImagen.addElement(pTextoC1);

        Paragraph pTextoC2 = new Paragraph(this.pw.getTxtTextoContrarecibo4(),
                FontFactory.getFont("Arial", 8, Font.BOLD, BaseColor.BLACK));
        pTextoC2.setAlignment(Chunk.ALIGN_CENTER);

        cImagen.addElement(pTextoC2);
        tblIzquierda.addCell(cImagen);

        PdfPCell cCosto = getCelda(4, 0, 0, Chunk.ALIGN_MIDDLE);

        if (this.pw.getRutaImagenCosto() != null && !this.pw.getRutaImagenCosto().equals("")) {
            try {
                Image img = Image.getInstance(this.pw.getRutaImagenCosto());
                img.scaleToFit(150f, 21f);
                img.setAlignment(Chunk.ALIGN_MIDDLE);
                cCosto.setRowspan(2);
                cCosto.setMinimumHeight(23);
                cCosto.addElement(img);
            } //tblIzquierda.addCell(cImagen);
            catch (BadElementException ex) {
                Logger.getLogger(ArchivoPDF.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ArchivoPDF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        tblIzquierda.addCell(cCosto);

        List<String> folioses = this.folios.get(i);
        if(folioses.size()%2!=0){
            folioses.add("");
        }
        for (String folio : folioses) {
            PdfPCell cFolio = getCelda(2, 0, 0, Chunk.ALIGN_LEFT);
            Paragraph pFolio = new Paragraph(folio,
                    FontFactory.getFont("Arial", 9, Font.BOLD, recuperarColor()));
            pFolio.setAlignment(Chunk.ALIGN_CENTER);
            cFolio.addElement(pFolio);
            tblIzquierda.addCell(cFolio);
        }
        cIzquierda.addElement(tblIzquierda);
        return cIzquierda;
    }
    
    /*private void generarLista() {
        List<String> listaFoliosTotales = new ArrayList<String>();
        for (Integer x = this.folioInicial; x <= this.folioFinal; x++) {
            String folio = x.toString();
            int num = folio.length();
            for (int i = num; i < this.numDigitos; i++) {
                folio = "0" + folio;
            }
            listaFoliosTotales.add(folio);
        }

        for (int x = 0; x < this.numBoletos; x++) {
            List<String> listaFolios = new ArrayList<String>();
            for (int y = 0; y < this.numFolios; y++) {
                String folio = recuperarFolio(listaFoliosTotales);
                listaFolios.add(folio);
            }
            this.folios.put(x, listaFolios);
        }
    }*/
    
    /*private String recuperarFolio(List<String> listaFoliosTotales) {
        String folio = "";
        if (listaFoliosTotales.size() > 0) {
            Double val = Math.random() * listaFoliosTotales.size();
            int index = val.intValue();
            folio = listaFoliosTotales.remove(index);
        }
        return folio;
    }*/

    private BaseColor recuperarColor() {
        BaseColor color = new BaseColor(1, 1, 1);
        switch (this.dia) {
            case 0:
                color = new BaseColor(this.pw.getRLunes(), this.pw.getGLunes(), this.pw.getBLunes());
                break;
            case 1:
                color = new BaseColor(this.pw.getRMartes(), this.pw.getGMartes(), this.pw.getBMartes());
                break;
            case 2:
                color = new BaseColor(this.pw.getRMiercoles(), this.pw.getGMiercoles(), this.pw.getBMiercoles());
                break;
            case 3:
                color = new BaseColor(this.pw.getRJueves(), this.pw.getGJueves(), this.pw.getBViernes());
                break;
            case 4:
                color = new BaseColor(this.pw.getRViernes(), this.pw.getGViernes(), this.pw.getBViernes());
                break;
            case 5:
                color = new BaseColor(this.pw.getRSabado(), this.pw.getGSabado(), this.pw.getBSabado());
                break;
            case 6:
                color = new BaseColor(this.pw.getRDomingo(), this.pw.getGDomingo(), this.pw.getBDomingo());
                break;
            default:
                color = new BaseColor(1, 1, 1);
                break;
        }
        return color;
    }
    
    private PdfPCell getCelda(int colspan, float padding, int border, int align) {
        PdfPCell celda = new PdfPCell();
        celda.setColspan(colspan);
        celda.setPadding(padding);
        celda.setBorder(border);
        celda.setVerticalAlignment(align);
        return celda;
    }
}
