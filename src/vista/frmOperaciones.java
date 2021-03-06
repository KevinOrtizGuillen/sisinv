/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import control.cOperacion;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.mOperacion;

/**
 *
 * @author Ortiz
 */
public class frmOperaciones extends javax.swing.JInternalFrame {
    mOperacion mope=new mOperacion();
    cOperacion cope=new cOperacion();
    DefaultTableModel modelo;
    int opcion=0;
    /**
     * Creates new form frmOperaciones
     */
    public frmOperaciones() {
        initComponents();
        mostrarOperaciones("");
        inhabilitar();
    }
    void inhabilitar(){
    txtIdO.setEnabled(false);
    txtNombreO.setEnabled(false);
    txaDescripciono.setEnabled(false);    
    //
    txtIdO.setText("");
    txtNombreO.setText("");
    txaDescripciono.setText("");
    //
    btnGuardarO.setEnabled(false);
    btnCancelar.setEnabled(false);
    btnEliminarOb.setEnabled(false);
    }
    void habilitar(){
    txtNombreO.setEnabled(true);
    txaDescripciono.setEnabled(true);    
    //
    txtIdO.setText("");
    txtNombreO.setText("");
    txaDescripciono.setText("");
    //
    btnGuardarO.setEnabled(true);
    btnCancelar.setEnabled(true);
    btnEliminarOb.setEnabled(true);
    }
    void mostrarOperaciones(String nombre){
        mope.setNombre(nombre);
        modelo=cope.buscarOperacion(mope);
        tblOperaciones.setModel(modelo);
    }
    void inicializarObj(){
    Integer id=0;
    if(txtIdO.getText().length()==0){
        id=0;
    }else{
        id=Integer.parseInt(txtIdO.getText());
    }
    mope.setId(id);
    mope.setNombre(txtNombreO.getText());
    mope.setDescripcion(txaDescripciono.getText());
    }
    void guardar(){
       String res= cope.CrearOperacion(mope);
       JOptionPane.showMessageDialog(null,res);
    }
    void editar(){
    String res=cope.EditarOperacion(mope);
    JOptionPane.showMessageDialog(null, res);
            }
    void eliminar(){    
    int input = JOptionPane.showConfirmDialog(null, "Esta Seguro que desea Eliminar este Cliente?");
        // 0=yes, 1=no, 2=cancel
        inicializarObj();
        if (input==0) {
            String res=cope.EliminarOperacion(mope);
            JOptionPane.showMessageDialog(null, res);
            inhabilitar();
        }else{
            inhabilitar();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txtNombreO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaDescripciono = new javax.swing.JTextArea();
        btnNuevoO = new javax.swing.JButton();
        btnGuardarO = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtIdO = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        txtNombreoB = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnEliminarOb = new javax.swing.JButton();
        btnCancelarob = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblOperaciones = new javax.swing.JTable();
        btnSalir = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("OPERACIONES DE SISTEMA");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Crear Nueva Operación"));

        txtNombreO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreOActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre:");

        jLabel3.setText("Descripción:");

        txaDescripciono.setColumns(20);
        txaDescripciono.setRows(5);
        jScrollPane1.setViewportView(txaDescripciono);

        btnNuevoO.setText("Nuevo");
        btnNuevoO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoOActionPerformed(evt);
            }
        });

        btnGuardarO.setText("Guardar");
        btnGuardarO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarOActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel5.setText("Id:");

        txtIdO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdOActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreO)
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNuevoO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardarO)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(48, 48, 48)
                        .addComponent(txtIdO)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIdO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevoO)
                    .addComponent(btnGuardarO)
                    .addComponent(btnCancelar))
                .addGap(116, 116, 116))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones Existentes"));

        txtNombreoB.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreoBKeyTyped(evt);
            }
        });

        jLabel4.setText("Nombre:");

        btnEliminarOb.setText("Eliminar");
        btnEliminarOb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarObActionPerformed(evt);
            }
        });

        btnCancelarob.setText("Cancelar");
        btnCancelarob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarobActionPerformed(evt);
            }
        });

        tblOperaciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Descripción"
            }
        ));
        tblOperaciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOperacionesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblOperaciones);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombreoB, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarOb)
                .addGap(18, 18, 18)
                .addComponent(btnCancelarob)
                .addGap(22, 22, 22))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalir)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombreoB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminarOb)
                    .addComponent(btnCancelarob))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalir)
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdOActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_txtIdOActionPerformed

    private void txtNombreOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreOActionPerformed
        // TODO add your handling code here:
        txtIdO.transferFocus();
        return;
    }//GEN-LAST:event_txtNombreOActionPerformed

    private void btnNuevoOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoOActionPerformed
        // TODO add your handling code here:
        habilitar();
        opcion=0;
    }//GEN-LAST:event_btnNuevoOActionPerformed

    private void btnGuardarOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarOActionPerformed
        // TODO add your handling code here:
        if (txtNombreO.getText().length()==0) {
            JOptionPane.showMessageDialog(this,"Debes ingresar el Nombre de la operacion");
            txtNombreO.requestFocus();
            return;            
        }else if(txaDescripciono.getText().length()==0){
            JOptionPane.showMessageDialog(this,"Debes ingresar la Descripcion de la operacion");
            txaDescripciono.requestFocus();
            return;
        }
       inicializarObj();
       if(opcion==0){
         guardar();
       }else{
        editar();
       }
       inhabilitar();
       mostrarOperaciones("");
                
    }//GEN-LAST:event_btnGuardarOActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        inhabilitar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarObActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarObActionPerformed
        // TODO add your handling code here:
        eliminar();
        mostrarOperaciones("");
    }//GEN-LAST:event_btnEliminarObActionPerformed

    private void btnCancelarobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarobActionPerformed
        // TODO add your handling code here:
        inhabilitar();
    }//GEN-LAST:event_btnCancelarobActionPerformed

    private void tblOperacionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOperacionesMouseClicked
        // TODO add your handling code here:
         habilitar();
        int row=tblOperaciones.getSelectedRow();
        opcion=1;
        txtIdO.setText(tblOperaciones.getValueAt(row,0).toString());
        txtNombreO.setText(tblOperaciones.getValueAt(row,1).toString());
        txaDescripciono.setText(tblOperaciones.getValueAt(row,2).toString());       
    }//GEN-LAST:event_tblOperacionesMouseClicked

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtNombreoBKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreoBKeyTyped
        // TODO add your handling code here:
        inicializarObj();
        cope.buscarOperacion(mope);
    }//GEN-LAST:event_txtNombreoBKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarob;
    private javax.swing.JButton btnEliminarOb;
    private javax.swing.JButton btnGuardarO;
    private javax.swing.JButton btnNuevoO;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblOperaciones;
    private javax.swing.JTextArea txaDescripciono;
    private javax.swing.JTextField txtIdO;
    private javax.swing.JTextField txtNombreO;
    private javax.swing.JTextField txtNombreoB;
    // End of variables declaration//GEN-END:variables
}
