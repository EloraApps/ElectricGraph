/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objetos;

import java.util.Calendar;

/**
 *
 * @author Fran
 */
public class Cliente {
    
    private boolean activo;
    private int id;
    private String empresa;
    private String nombre;
    private String email;
    private String cif;
    private String direccion;
    private String comentarios;
    private String tlf1, tlf2;
    private String fechaAlta, fechaBaja;
    
    public Cliente() {
        
    }

    public Cliente(boolean activo, int id, String nombre, String email) {
        this.activo = activo;
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }
    
    public Cliente(String empresa, String nombre, String email, String cif, String direccion, String tlf1, String tlf2) {
        this.activo = true;
        this.empresa = empresa;
        this.nombre = nombre;
        this.email = email;
        this.cif = cif;
        this.direccion = direccion;
        this.tlf1 = tlf1;
        this.tlf2 = tlf2;
        fechaAlta = getFecha();
        fechaBaja = "-";
    }
    
    public Cliente(boolean activo, String nombre, String email) {
        this.activo = activo;
        this.nombre = nombre;
        this.email = email;
    }
    
    public final String getFecha() {
        String fecha;
        
        Calendar cal = Calendar.getInstance();
        fecha = cal.get(Calendar.DAY_OF_MONTH) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR);
        
        return fecha;
    }

    //SET
    public void setActivo(boolean activo) {
        this.activo = activo;
        if(!activo) {
            fechaBaja = getFecha();
        }
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public void setCif(String cif) {
        this.cif = cif;
    }
    public void setComentarios(String txt) {
        comentarios = txt;
    }
    public void setTlf1(String tlf) {
        tlf1 = tlf;
    }
    public void setTlf2(String tlf) {
        tlf2 = tlf;
    }
    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    //GET
    public boolean isActivo() {
        return activo;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    public String getCif() {
        return cif;
    }
    public String getFechaBaja() {
        return fechaBaja;
    }
    public String getFechaAlta() {
        return fechaAlta;
    }
    public String getComentarios() {
        return comentarios;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getEmpresa() {
        return empresa;
    }
    public String getTlf1() {
        return tlf1;
    }
    public String getTlf2() {
        return tlf2;
    }
    

    @Override
    public String toString() {
        String str = "";
        
        str += "Hola me llamo " + nombre + ", mi e-mail es " + email;
        
        if(activo)
            str += " y estoy en activo.";
        else
            str += " y no estoy en activo.";
        
        return str;
    }
    
}
