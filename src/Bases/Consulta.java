/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Bases;

import Objetos.Cliente;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Consulta {
    Connection conexion;
    Statement consulta;
    //public final String ruta = "C:\\Users\\Fran\\Documents\\NetBeansProjects\\GestionElectrica\\base\\usuarios.db";
    public String ruta = "C:\\Users\\Betelgeuse\\Documents\\NetBeansProjects\\GestionElectrica\\base\\usuarios.db";
    JFrame frame;
    
    public Consulta(JFrame frame) {
        this.frame = frame;
    }
    
    
    public void conectar() {
        try {
            String rutaBuff = new File(".").getAbsolutePath();
            char [] rutita = new char[rutaBuff.length()-1];
            for(int i = 0; i < rutita.length; i++) {
                rutita[i] = rutaBuff.charAt(i);
            }
            rutaBuff = String.copyValueOf(rutita);
            rutaBuff += "base\\usuarios.db";
            System.out.println(rutaBuff);
            ruta = rutaBuff;
            System.out.println(ruta);
            Class.forName("org.sqlite.JDBC");
        }
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(frame, e.getMessage());
        }	 
            try {
                conexion = DriverManager.getConnection("jdbc:sqlite:" + ruta);
                consulta = conexion.createStatement();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(frame, e.getMessage());
        }
    }
    
    public void conectarTotal() {
        try {
            String rutaBuff = new File(".").getAbsolutePath();
            char [] rutita = new char[rutaBuff.length()-1];
            for(int i = 0; i < rutita.length; i++) {
                rutita[i] = rutaBuff.charAt(i);
            }
            rutaBuff = String.copyValueOf(rutita);
            rutaBuff += "base\\GestElect.db";
            System.out.println(rutaBuff);
            ruta = rutaBuff;
            System.out.println(ruta);
            Class.forName("org.sqlite.JDBC");
        }
        catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(frame, e.getMessage());
        }	 
            try {
                conexion = DriverManager.getConnection("jdbc:sqlite:" + ruta);
                consulta = conexion.createStatement();
                System.out.println("Conexión realizada.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public boolean insertarCliente(Cliente C){
        boolean valor = true;
        int activo = -1;
        
        if(C.isActivo())
            activo = 1;
        else
            activo = 0;
        
        conectar();
        String sql = "INSERT INTO CLIENTS (activo, nombre, email) VALUES (" + activo + ", '" + C.getNombre() + "', '" + C.getEmail() + "');";
        try {
            consulta.executeUpdate(sql);
        } catch (SQLException e) {
                valor = false;
                //JOptionPane.showMessageDialog(null, e.getMessage());
                JOptionPane.showMessageDialog(frame, e.getMessage(), "SQLException", JOptionPane.ERROR_MESSAGE);
        } finally {
            try{    
                consulta.close();
                conexion.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        
        return valor;
    }
    
    public boolean insertarClienteTotal(Cliente C){
        boolean valor = true;
        
        conectarTotal();
        
        String sql = "INSERT INTO Clientes (Activo, Empresa, Direccion, tlf1, tlf2, CIF, Contacto, fechaAlta, emails) VALUES (" + 1 + ", '" + C.getEmpresa() + "', '" + C.getDireccion() + "', '" +
                C.getTlf1() + "', '" + C.getTlf2() + "', '" + C.getCif() + "', '" + C.getNombre() + "', '" + C.getFechaAlta() + "', '" + C.getEmail() + "');";
        System.out.println("Procediendo con el INSERT:\n" + sql + "\n\n");
        try {
            consulta.executeUpdate(sql);
            consulta.close();
            System.out.println("INSERT realizado");
            ResultSet rs;
            rs = consulta.executeQuery("SELECT ID FROM Clientes WHERE Empresa='" + C.getEmpresa() + "';");
            int id = rs.getInt("ID");
            System.out.println("ID cogido: " + id);
            consulta.close();
            conexion.close();
            System.out.println("Antigua conexion cerrada");
            crearTabla(String.valueOf(id));
            System.out.println("Tabla creada");
        } catch (SQLException e) {
                valor = false;
                //JOptionPane.showMessageDialog(null, e.getMessage());
                JOptionPane.showMessageDialog(frame, e.getMessage(), "SQLException", JOptionPane.ERROR_MESSAGE);
                System.err.println(e.getMessage());
        } finally {
            try{    
                consulta.close();
                conexion.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        
        return valor;
    }
    
    public boolean crearTabla(String idCliente) {
        boolean res = true;
        
        conectarTotal();
        /*
        CREATE TABLE `21` (
	`ID`	INTEGER PRIMARY KEY AUTOINCREMENT,
	`YEAR`	TEXT,
	`IDLect`	TEXT,
	`FECHA`	TEXT,
	`HORA`	TEXT,
	`Lectura1`	NUMERIC,
	`Lectura2`	NUMERIC,
	`Lectura3`	NUMERIC,
	`Lectura4`	NUMERIC,
	`Lectura5`	NUMERIC,
	`Lectura6`	NUMERIC,
	`Lectura7`	NUMERIC
        );
        */
        String sql = "CREATE TABLE '" + idCliente + "' (`ID` INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "	`YEAR`	TEXT,\n" +
            "	`IDLect`	TEXT,\n" +
            "	`FECHA`	TEXT,\n" +
            "	`HORA`	TEXT,\n" +
            "	`Lectura1`	NUMERIC,\n" +
            "	`Lectura2`	NUMERIC,\n" +
            "	`Lectura3`	NUMERIC,\n" +
            "	`Lectura4`	NUMERIC,\n" +
            "	`Lectura5`	NUMERIC,\n" +
            "	`Lectura6`	NUMERIC,\n" +
            "	`Lectura7`	NUMERIC\n" +
            "        );";
        try {
            consulta.executeUpdate(sql);
        } catch (SQLException e) {
                //JOptionPane.showMessageDialog(null, e.getMessage());
                JOptionPane.showMessageDialog(frame, e.getMessage(), "SQLException", JOptionPane.ERROR_MESSAGE);
        } finally {
            try{    
                consulta.close();
                conexion.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        
        return res;
    }
    
    public boolean eliminarCliente(Cliente C){
        boolean valor = true;
        
        conectar();
        String sql = "DELETE FROM CLIENTS WHERE id=" + C.getId() + ";";
        try {
            //consulta.executeQuery(sql);
            consulta.execute(sql);
        } catch (SQLException e) {
                valor = false;
                //JOptionPane.showMessageDialog(null, e.getMessage());
                JOptionPane.showMessageDialog(frame, e.getMessage(), "SQLException", JOptionPane.ERROR_MESSAGE);
        } finally {
            try{    
                consulta.close();
                conexion.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        
        return valor;
    }
    
    public boolean eliminarCliente(int id){
        boolean valor = true;
        
        conectar();
        String sql = "DELETE FROM CLIENTS WHERE id=" + id + ";";
        try {
            consulta.execute(sql);
        } catch (SQLException e) {
                valor = false;
                //JOptionPane.showMessageDialog(null, e.getMessage());
                JOptionPane.showMessageDialog(frame, e.getMessage(), "SQLException", JOptionPane.ERROR_MESSAGE);
        } finally {
            try{    
                consulta.close();
                conexion.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        
        return valor;
    }
    
    public List<Cliente> verClientes(){
        List<Cliente> lista = new ArrayList<Cliente>();
        conectar();
        String sql = "SELECT * FROM CLIENTS;";
        Cliente CliBuf;
        try {
            ResultSet rs;
            rs = consulta.executeQuery(sql);
            while(rs.next()) {
                int act = rs.getInt("activo");
                if(act == 1) {
                    CliBuf = new Cliente(true, rs.getString("nombre"), rs.getString("email"));
                    CliBuf.setId(rs.getInt("id"));
                    lista.add(CliBuf);
                } else {
                    CliBuf = new Cliente(false, rs.getString("nombre"), rs.getString("email"));
                    CliBuf.setId(rs.getInt("id"));
                    lista.add(CliBuf);
                }
            }
        } catch (SQLException e) {
                lista = null;
                //JOptionPane.showMessageDialog(null, e.getMessage());
                JOptionPane.showMessageDialog(frame, e.getMessage(), "SQLException", JOptionPane.ERROR_MESSAGE);
        } finally {
            try{    
                consulta.close();
                conexion.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        
        return lista;
    }
}
