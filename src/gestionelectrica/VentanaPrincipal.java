/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionelectrica;

import Bases.Consulta;
import Objetos.Cliente;
import Objetos.Lector;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Fran
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VentanaPrincipal
     */
    private final String [] COLUMNAS = {"Activo","ID","Nombre","e-mail"};
    private Object [][] objetos;
    private final boolean [] editables = {true, false, false, false};
    
    public VentanaPrincipal() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        
        rellenarTabla();
        jTabla.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                int row = jTabla.getSelectedRow() + 1;
                System.out.println("Seleccionada la fila: " + row);
            }
        });
        //rellenando();
        
        Cliente cli = new Cliente();
        System.out.println(cli.getFecha());
    }
    
    private void rellenando() {
        //se crea un TableModel con algunos datos y se asigna al JTable
        DefaultTableModel TableModel = new DefaultTableModel();
        TableModel.setDataVector(new Object[][] {
        { false, "Juan Perez", "12", "Hombre" },
        { false, "Homero J. Simpsons", "40", "Hombre" },
        { true, "Ned Flanders", "35", "Hombre" },
        { true, "Asuka Langley", "15", "Si gracias" },
        { false, "Rei Ayanami", "16", "Mujer" },
        { true, "shinji ikari", "15", "No se sabe" } }, COLUMNAS);
        jTabla.setModel(TableModel);
        //Se crea el JCheckBox en la columna indicada en getColumn, en este caso, la primera columna
        jTabla.getColumnModel().getColumn(0).setCellEditor(new Celda_CheckBox());
        //para pintar la columna con el CheckBox en la tabla, en este caso, la primera columna
        jTabla.getColumnModel().getColumn(0).setCellRenderer(new Render_CheckBox());      
    }
    
    private void rellenarTabla() {
        /*
        objetos = new Object[1][4];
        objetos[0][0] = true;
        objetos[0][1] = "Sin datos";
        objetos[0][2] = "Sin datos";
        objetos[0][3] = "Sin datos";
        */
        objetos = new Object[77][4];
        for(int i = 0; i < objetos.length; i++) {
            if( i % 4 == 0)
                objetos[i][0] = true;
            else
                objetos[i][0] = false;
            
            objetos[i][1] = "ID " + (i+1);
            objetos[i][2] = "Nombre " + (i+1);
            objetos[i][3] = "e-mail " + (i+1);
        }
        DefaultTableModel modelo = new DefaultTableModel(objetos, COLUMNAS);
        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            objetos,
            COLUMNAS
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        modelo = new DefaultTableModel(
            objetos,
            COLUMNAS)
        {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        
            Class[] types = new Class [] {
            java.lang.Boolean.class, //este es para el check
            java.lang.String.class,
            java.lang.String.class,
            java.lang.String.class};
            boolean[] canEdit = new boolean
            [] {
            true,
            false,
            false,
            false
            };
            
        
        jTabla.setModel(modelo);
        
        jTabla.getColumnModel().getColumn(0).setCellEditor( new Celda_CheckBox() );
        jTabla.getColumnModel().getColumn(0).setCellRenderer(new Render_CheckBox());
        
        jTabla.getColumnModel().getColumn(0).setPreferredWidth(40);
        jTabla.getColumnModel().getColumn(0).setMaxWidth(40);
        
        jTabla.getColumnModel().getColumn(0).setResizable(false);
        jTabla.getColumnModel().getColumn(1).setResizable(true);
        jTabla.getColumnModel().getColumn(2).setResizable(true);
        jTabla.getColumnModel().getColumn(3).setResizable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bEliminar = new javax.swing.JButton();
        bCrear = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabla = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        bGraficas = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mPreferencias = new javax.swing.JMenuItem();
        mSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bEliminar.setText("Eliminar Cliente");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        bCrear.setText("Crear Cliente");
        bCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCrearActionPerformed(evt);
            }
        });

        jTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"Sí", "1", "Perraca", "perraca@poipoi.es"}
            },
            new String [] {
                "Activo", "ID", "Nombre", "e-mail"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTabla.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(jTabla);
        jTabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (jTabla.getColumnModel().getColumnCount() > 0) {
            jTabla.getColumnModel().getColumn(0).setResizable(false);
        }

        jButton1.setText("Ver Clientes");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        bGraficas.setText("Ejemplo Graficas");
        bGraficas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGraficasActionPerformed(evt);
            }
        });

        jMenu1.setText("Archivo");

        mPreferencias.setText("Preferencias");
        mPreferencias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mPreferenciasActionPerformed(evt);
            }
        });
        jMenu1.add(mPreferencias);

        mSalir.setText("Salir");
        mSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mSalirActionPerformed(evt);
            }
        });
        jMenu1.add(mSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Menú");

        jMenuItem4.setText("Usuarios");
        jMenu2.add(jMenuItem4);

        jMenuItem3.setText("Lectura diaria");
        jMenu2.add(jMenuItem3);

        jMenuItem6.setText("Lectura semanal");
        jMenu2.add(jMenuItem6);

        jMenuItem5.setText("Lectura mensual");
        jMenu2.add(jMenuItem5);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Ayuda");

        jMenuItem7.setText("Instrucciones");
        jMenu3.add(jMenuItem7);

        jMenuItem8.setText("Acerca de");
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(bGraficas)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1)
                        .addComponent(bGraficas))
                    .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_mSalirActionPerformed

    private void bCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCrearActionPerformed
        // TODO add your handling code here:
        //new AddCliente(this);
        new AltaCliente(this);
    }//GEN-LAST:event_bCrearActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        // TODO add your handling code here:
        new DelCliente();
    }//GEN-LAST:event_bEliminarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Consulta Cons = new Consulta(this);
        List<Cliente> lista = Cons.verClientes();
        
        System.out.println("Tamaño lista: " + lista.size());
        
        for(int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bGraficasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGraficasActionPerformed
        // TODO add your handling code here:
        new VentanaEjemploGraf();
    }//GEN-LAST:event_bGraficasActionPerformed

    private void mPreferenciasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mPreferenciasActionPerformed
        // TODO add your handling code here:
        Lector Le = new Lector();
    }//GEN-LAST:event_mPreferenciasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCrear;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bGraficas;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabla;
    private javax.swing.JMenuItem mPreferencias;
    private javax.swing.JMenuItem mSalir;
    // End of variables declaration//GEN-END:variables
}
