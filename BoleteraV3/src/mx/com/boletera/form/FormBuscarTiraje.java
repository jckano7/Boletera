/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.com.boletera.form;

import java.awt.Color;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import mx.com.boletera.bo.BuscarTirajeBO;
import mx.com.boletera.model.Tiraje;

/**
 *
 * @author jkano
 */
public class FormBuscarTiraje extends JFrame {

    /**
     * Creates new form FormPrincipal
     */
    public FormBuscarTiraje() {
        initComponents();
        buscarTirajeBO = new BuscarTirajeBO();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        wrnNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblNombre1 = new javax.swing.JLabel();
        txtNombre1 = new javax.swing.JTextField();
        wrnNombre1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTiraje = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        barMenu = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        itmSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Boletera V3");
        setName("frmPrincipal"); // NOI18N
        setState(2);
        getContentPane().setLayout(null);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblTitulo.setText("Configurar folios del tiraje");
        jPanel1.add(lblTitulo);
        lblTitulo.setBounds(8, 8, 178, 20);

        lblNombre.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblNombre.setText("Nombre tiraje");
        lblNombre.setFocusable(false);
        jPanel1.add(lblNombre);
        lblNombre.setBounds(8, 50, 120, 20);

        wrnNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/warning.png"))); // NOI18N
        wrnNombre.setToolTipText("Datos no válidos");
        wrnNombre.setFocusable(false);
        wrnNombre.setVisible(false);
        jPanel1.add(wrnNombre);
        wrnNombre.setBounds(330, 50, 16, 20);

        txtNombre.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        jPanel1.add(txtNombre);
        txtNombre.setBounds(150, 50, 173, 20);

        lblNombre1.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        lblNombre1.setText("Nombre tiraje");
        lblNombre1.setFocusable(false);
        jPanel1.add(lblNombre1);
        lblNombre1.setBounds(10, 90, 120, 20);

        txtNombre1.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtNombre1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombre1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombre1FocusLost(evt);
            }
        });
        jPanel1.add(txtNombre1);
        txtNombre1.setBounds(150, 90, 173, 20);

        wrnNombre1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/warning.png"))); // NOI18N
        wrnNombre1.setToolTipText("Datos no válidos");
        wrnNombre1.setFocusable(false);
        wrnNombre.setVisible(false);
        jPanel1.add(wrnNombre1);
        wrnNombre1.setBounds(330, 90, 16, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 20, 360, 160);

        tblTiraje.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id tiraje", "Folio inicial", "Folio final", "No digitos", "No folios"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTiraje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTirajeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTiraje);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 190, 520, 150);

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/search.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar);
        btnBuscar.setBounds(390, 30, 150, 41);

        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/add.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregar);
        btnAgregar.setBounds(390, 130, 150, 41);

        btnLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/repeat.png"))); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimpiar);
        btnLimpiar.setBounds(390, 80, 150, 41);

        mnuArchivo.setText("Archivo");

        itmSalir.setText("Salir");
        itmSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itmSalirActionPerformed(evt);
            }
        });
        mnuArchivo.add(itmSalir);

        barMenu.add(mnuArchivo);

        setJMenuBar(barMenu);

        setBounds(0, 0, 553, 397);
    }// </editor-fold>//GEN-END:initComponents

    private void itmSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itmSalirActionPerformed
        Integer res = JOptionPane.showConfirmDialog(this, "¿Desea salir del sistema?", "Salir", JOptionPane.YES_NO_OPTION);
        if (res.equals(0)) {
            System.exit(0);
        }
    }//GEN-LAST:event_itmSalirActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        wrnNombre.setVisible(false);
        txtNombre.setBackground(Color.white);
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        String valor = txtNombre.getText();
        boolean cumplePatron = Pattern.matches("^[0-9]{1,7}$", valor);
        if (!cumplePatron) {
            wrnNombre.setVisible(true);
            txtNombre.setBackground(Color.red);
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            Boolean valido = true;
            //folio inicial
            String valor = txtNombre.getText();
            boolean cumplePatron = Pattern.matches("^[0-9]{1,7}$", valor);
            if (cumplePatron) {
                wrnNombre.setVisible(false);
                txtNombre.setBackground(Color.white);
                valido = true;
            } else {
                wrnNombre.setVisible(true);
                txtNombre.setBackground(Color.red);
                valido = false;
            }
            if (valido) {
                Tiraje tiraje = new Tiraje();
                tiraje.setFolioInicial(Integer.parseInt(valor));
                List<Tiraje> lista = buscarTirajeBO.buscarTirajes(tiraje);
                DefaultTableModel model = (DefaultTableModel) tblTiraje.getModel();
                while(model.getRowCount()!=0){
                    model.removeRow(0);
                }
                for(Tiraje item : lista){
                    Object [] fila = new Object[5];
                    fila[0] = item.getIdTiraje();
                    fila[1] = item.getFolioInicial();
                    fila[2] = item.getFolioFinal();
                    fila[3] = item.getNumDigitos();
                    fila[4] = item.getNumFolios();
                    model.addRow(fila);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Revise los datos ingresados");
            }
        } catch (Exception ex) {
            Logger.getLogger(FormBuscarTiraje.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        frmFolios = new FormConfigurarTiraje(0);
        frmFolios.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtNombre.setText("");
        txtNombre.setBackground(Color.white);
        wrnNombre.setVisible(false);
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void tblTirajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTirajeMouseClicked
        int fila = tblTiraje.rowAtPoint(evt.getPoint());
        int columna = tblTiraje.columnAtPoint(evt.getPoint());
        if ((fila > -1) && (columna > -1)){
            System.out.println("IDTIRAJE: " + tblTiraje.getValueAt(fila,0));
            System.out.println("COL: " + columna);
            System.out.println("FIL: " + fila);
            Integer idTiraje = Integer.parseInt(tblTiraje.getValueAt(fila,0).toString());
            frmFolios = new FormConfigurarTiraje(idTiraje);
            frmFolios.setVisible(true);
        }
    }//GEN-LAST:event_tblTirajeMouseClicked

    private void txtNombre1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombre1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre1FocusGained

    private void txtNombre1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombre1FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombre1FocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormBuscarTiraje().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barMenu;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JMenuItem itmSalir;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombre1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JTable tblTiraje;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombre1;
    private javax.swing.JLabel wrnNombre;
    private javax.swing.JLabel wrnNombre1;
    // End of variables declaration//GEN-END:variables
    private FormConfigurarTiraje frmFolios;
    private BuscarTirajeBO buscarTirajeBO;
}
