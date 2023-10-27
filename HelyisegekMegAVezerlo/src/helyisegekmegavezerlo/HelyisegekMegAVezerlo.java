/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package helyisegekmegavezerlo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Tanar
 */
public class HelyisegekMegAVezerlo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Helyiseg h=new Helyiseg("1. szoba",34);
        Helyiseg h2=new Helyiseg("2. szoba",20);
        Helyiseg h3=new Helyiseg("3. szoba",25);
        /*h=new Helyiseg("1. szoba",34);
        h=new Helyiseg("1. szoba",34);
       
        System.out.println(h);
        //helyisegekmegavezerlo.Helyiseg@5b480cf9 => 32 bit*/
        Vezerlo v=new Vezerlo();
        /*v.setLeolvasas(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                h.Meres();
            }
            
        });*/
        ActionListener al=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.printf("%d °C: %s, %d, %s\n", h.Meres(),e.getSource(),e.getID(),e.getActionCommand());
            }
        };
        v.setLeolvasas(al);
        al=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.printf("%d °C: %s, %d, %s\n", h2.Meres(),e.getSource(),e.getID(),e.getActionCommand());
            }
        };
        v.setLeolvasas(al);        
        al=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.printf("%d °C: %s, %d, %s\n", h3.Meres(),e.getSource(),e.getID(),e.getActionCommand());
            }
        };
        v.setLeolvasas(al);        
        Timer t=new Timer();
        t.scheduleAtFixedRate(v, 0, 2000);
    }
    
}
//A láthatósági minősítés nélküli elemek: package public minősítéssel rendelkeznek
class Helyiseg{
    private static int szamlalo=0;
    private int h_az;
    private String megnevezes;
    private int alapterulet;
    public Helyiseg(String megnevezes,int alapterulet){
       this.megnevezes=megnevezes;
       this.alapterulet=alapterulet;
       h_az=++szamlalo;
    }
    @Override
    public String toString(){
        return "{"+megnevezes+" megnevezésű Helyiseg vagyok...}";
    }
    //Mivel a NetBeans UTF-8 kódolást használ a létrejött *.class futtatásakor a Parncssort chcp 65001 paranccsal szintén UTF-8 kódolást használóra kell állítani
    public int Meres(){
        int fejvagyiras=(int)Math.round(Math.random());
        if(fejvagyiras==0){
            return Integer.MIN_VALUE;
        }else{
            int homerseklet=(int)Math.floor(Math.random()*30+10);
            return homerseklet;
        }
    }
}
class Vezerlo extends TimerTask{
    //generikus
    private List<ActionListener> leolvasasok=new ArrayList<ActionListener>();
    public void setLeolvasas(ActionListener al){
        leolvasasok.add(al);
    }

    @Override
    public void run() {
        //System.out.println("már megint eltelt 2mp");
        for(ActionListener meres:leolvasasok){
            meres.actionPerformed(new ActionEvent(meres.getClass(),1,"A"));
        }
    }
}
