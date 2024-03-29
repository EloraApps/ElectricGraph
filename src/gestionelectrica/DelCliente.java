/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionelectrica;

import Bases.Consulta;
import Objetos.Cliente;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 *
 * @author Fran
 */
public class DelCliente extends javax.swing.JFrame {

    /**
     * Creates new form DelCliente
     */
    
    List<Cliente> lista;
    
    public DelCliente() {
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        rellenarLista(spinner);
    }
    
    public void rellenarLista(javax.swing.JComboBox cb) {
        try {
            Consulta C = new Consulta(this);
            lista = C.verClientes();
            cb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecciona el ID a eliminar"}));
            for(int i = 0; i < lista.size(); i++) {
                cb.addItem(lista.get(i).getId());
            }
        }catch(Exception e) {
            System.err.println("NOOOOO\n" + e.getMessage());
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
        spinner = new javax.swing.JComboBox();
        bDel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario:");

        spinner.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        bDel.setText("ELIMINAR");
        bDel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bDel, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(spinner, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bDel, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bDelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDelActionPerformed
        // TODO add your handling code here:
        Consulta C = new Consulta(this);
        int idc = spinner.getSelectedIndex();
        System.out.println("IDC = " + idc);
        
        if(idc < 1)
            return;
        
        if(C.eliminarCliente(lista.get(idc-1))) {
            System.out.println("OK");
            JOptionPane.showMessageDialog(null, "Cliente borrado", null, JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }else {
            System.out.println("NO OK");
            JOptionPane.showMessageDialog(null, "No se pudo borrar el cliente", "SQLException", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_bDelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JComboBox spinner;
    // End of variables declaration//GEN-END:variables
}
