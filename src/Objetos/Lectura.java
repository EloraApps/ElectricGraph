/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Betelgeuse
 */
public class Lectura {
    
    String id;
    String day, month, year;
    String hour;
    
    String Ec, Ev, Rc, Rv, Cc, Cv;
    
    String coseno;
    
    public Lectura(String i, String d, String m, String y, String h, String l1, String l2, String l3, String l4, String l5, String l6, String s) {
        id = i;
        day = d;
        month = m;
        year = y;
        hour = h;
        Ec = l1;
        Ev = l2;
        Rc = l3;
        Rv = l4;
        Cc = l5;
        Cv = l6;
        coseno = s;
    }
    
    public String getId() { return id; }
    public String getDay() { return day; }
    public String getMonth() { return month; }
    public String getYear() { return year; }
    public String getHour() { return hour; }
    public String getEc() { return Ec; }
    public String getEv() { return Ev; }
    public String getRc() { return Rc; }
    public String getRv() { return Rv; }
    public String getCc() { return Cc; }
    public String getCv() { return Cv; }
    public String getCos() { return coseno; }
    
    @Override
    public String toString () {
        String s = "\t======= LECTURA =======\n";
        s += id + "\n";
        s += day + "/" + month + "/" + year + "\n";
        s += hour + "\n";
        s += "Ec: " + Ec + "\n";
        s += "Ev: " + Ev + "\n";
        s += "Rc: " + Rc + "\n";
        s += "Rv: " + Rv + "\n";
        s += "Cc: " + Cc + "\n";
        s += "Cv: " + Cv + "\n";
        s += "COSENO -> " + coseno + "\n";
        s += "===============================\n";
        return s;
    }
}
