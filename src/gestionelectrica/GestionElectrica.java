/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gestionelectrica;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;

/**
 *
 * @author Fran
 */
public class GestionElectrica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JDialog dialog = new JDialog();
        dialog.setUndecorated(true);
        JLabel label = new JLabel( new ImageIcon("electriclogo.jpg") );
        //label.setIcon(new ImageIcon("electriclogo.jpg"));
        dialog.add( label );
        dialog.pack();
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
        
        try {
            //label.setIcon(new ImageIcon("gameofthrones_c.jpg"));
            Thread.sleep(1000);
            dialog.dispose();
            Thread.sleep(500);
        } catch (InterruptedException ex) {
            Logger.getLogger(GestionElectrica.class.getName()).log(Level.SEVERE, null, ex);
        }
        //dialog.dispose();
        File f = new File(System.getProperty("java.io.tmpdir") + "\\chart.jpg");
        if(f.exists())
            System.out.println("El archivo sigue existiendo.");
        else
            System.out.println("El archivo ya no existe.");
        new VentanaPrincipal();
    }
    
}
