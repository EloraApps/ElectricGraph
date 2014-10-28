/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author Betelgeuse
 */
public class Lector {
    String ruta;
    File carpetaPrincipal;
    String [] clientes;
    
    public Lector() {
        String ruta = new File(".").getAbsolutePath();
        char [] rutita = new char[ruta.length()-1];
        for(int i = 0; i < rutita.length; i++) {
            rutita[i] = ruta.charAt(i);
        }
        ruta = String.copyValueOf(rutita);
        ruta += "ElectricGraph.conf";
        System.out.println(ruta);
        this.ruta = ruta;
        System.out.println(ruta);
        String texto = leer();
        System.out.println(texto);
        System.out.println("Ruta de los datos: " + getRuta(texto));
        carpetaPrincipal = new File(getRuta(texto));
        clientes = listar(carpetaPrincipal);
        if(clientes == null) {
            System.err.println("NO SE PUDO LISTAR");
        }else {
            System.out.println("LISTADO DE ARCHIVOS:");
            for(int i = 0; i < clientes.length; i++)
                System.out.println(clientes[i]);
            System.out.println("====================");
        }
        
        String [] dias = extraerDias(clientes[0], "2014");
        /*
        for(int i = 0; i < dias.length; i++)
            System.out.println(dias[i]);
        */
        
        Lectura [] lecturas = tomarLecturas(dias[29]);
        
        /*
        for(int i = 0; i < lecturas.length; i++)
            System.out.println(lecturas[i].toString());
        */
        /*
        if("hola".matches("hola"))
            System.err.println("SI COINCIDEN");
        else
            System.err.println("NO COINCIDEN");
        
        */
        
        if(comprobarRepeticiones(lecturas))
            System.err.println("SI SE REPITEN");
        else
            System.err.println("NO SE REPITEN");
    }
    
    private boolean comprobarRepeticiones(Lectura [] l) {
        boolean seRepite = false;
        
        String [] ids = new String[l.length];
        for(int i = 0; i < ids.length; i++)
            ids[i] = l[i].getId();
        
        for(int i = 0; i < (ids.length - 1); i++) {
            for(int j = (i+1); j < ids.length; j++) {
                if(ids[i].matches(ids[j]))
                    return true;
            }
        }
        
        return seRepite;
    }
    
    private Lectura [] tomarLecturas(String ruta) {
        Lectura [] res = null;
        if(!new File(ruta).exists())
            return res;
        System.out.println("Se procede a la lectura del archivo: " + ruta + "\n\n");
        
        String leido = leer(ruta);
        String [] lineas = leido.split("\n");
        
        System.out.println(leido);
        System.out.println("Líneas: " + lineas.length);
        
        Lectura L = extraerLectura(lineas[0]);
        
        System.out.println(L.toString());
        
        res = new Lectura[lineas.length];
        
        for(int i = 0; i < res.length; i++) {
            res[i] = extraerLectura(lineas[i]);
        }
        
        return res;
    }
    
    private Lectura extraerLectura(String s) {
        Lectura res = null;
        
        String [] trozos = s.split("\t");
        
        System.out.println("TROZOS: " + trozos.length);
        for(int i = 0; i < trozos.length; i++)
            System.out.println(trozos[i]);
        
        String [] fechas = trozos[1].split(" ");
        String [] calendarios = fechas[0].split("/");
        String [] horarios = fechas[1].split(":");
        
        res = new Lectura(trozos[0], calendarios[0], calendarios[1], calendarios[2],
            horarios[0]+ ":" +horarios[1], trozos[2], trozos[3], trozos[4], trozos[5],  trozos[6],
            trozos[7], trozos[8]);
        return res;
    }
    
    private String [] extraerDias(String cli) {
        String [] res = null;
        
        return res;
    }
    
    private String [] extraerDias(String cli, String year) {
        String [] res = null;
        if(!new File(cli).isDirectory())
            return res;
        
        String ruta = cli + "\\" + year;
        File carpeta = new File(ruta);
        
        File [] listado = carpeta.listFiles();
        res = new String[listado.length];
        
        for(int i = 0; i < listado.length; i++)
            res[i] = listado[i].getAbsolutePath();
        
        return res;
    }
    
    private String [] listar(File f) {
        String [] res = null;
        
        if(!f.isDirectory())
            return res;
        
        File [] listado = f.listFiles();
        res = new String[listado.length];
        
        for(int i = 0; i < listado.length; i++)
            res[i] = listado[i].getAbsolutePath();
        
        return res;
    }
    
    private void getRutaaa(String s) {
        
        String [] trozos = s.split("ruta=\"");
        System.out.println("Extraidos " + trozos.length + " trozos");
        for(int i = 0; i < trozos.length; i++) {
            System.out.println("Nuevo token -> " + trozos[i]);
        }
        
        if(trozos.length == 1) {
            
        }else {
            String [] trocitos = trozos[1].split("\"");
            System.out.println("Extraidos " + trocitos.length + " trozos");
            for(int i = 0; i < trocitos.length; i++) {
                System.out.println("Nuevo token -> " + trocitos[i]);
            }
        }
    }
    
    private String getRuta(String s) {
        String [] trozos = s.split("ruta=\"");
        String [] trocitos = trozos[1].split("\"");
        return trocitos[0];
    }
    
    public String leer() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String resultado = "";

        try {
            archivo = new File (ruta);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea = br.readLine())!=null) {
                System.out.println(linea);
                resultado += linea + "\n";
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                  
            } catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
        
        return resultado;
    }
    
    public String leer(String ruta) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String resultado = "";

        try {
            archivo = new File (ruta);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea = br.readLine())!=null) {
                System.out.println(linea);
                resultado += linea + "\n";
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally{
            try{                    
                if( null != fr ){   
                    fr.close();     
                }                  
            } catch (Exception e2){ 
                e2.printStackTrace();
            }
        }
        
        return resultado;
    }
}
