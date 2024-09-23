package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;


public class ArrayListGyak {
    //20db számgenerálás [10-20] és 1 db arraylistába tárolni.

    //csak private static final lehet mert a new drága!
    private static final Random rnd = new Random();
    private static ArrayList<Integer> szamLista;
    private static HashMap<Integer, Integer> statisztika;
    
    public static void main(String[] args) {
        
        szamLista = new ArrayList();
        HashSet<Integer> halmazok = new HashSet();
        
        
        
        for (int i = 0; i < 20; i++) {
            int szamok = rnd.nextInt(10,21);
            //listában tárolas
            szamLista.add(szamok);
        }
        
        //lista kiírása
        System.out.println("Teljes lista:");
        System.out.println(szamLista.toString());
        
        //páratlanok törlése
        //fordított forciklus
        for (int j = szamLista.size()-1; j >= 0; j--) {
            if (szamLista.get(j) % 2 == 1) {
                szamLista.remove(j);
            }
        }
        //kiirás páratlan nélkül
        System.out.println("Csak parosak:");
        System.out.println(szamLista.toString());
        
        //különböző számok , melyik számból mennyi?
        //halmaz kell, amelyhez pedig hashset
        //gyors megoldás: kulonbozoek = new HashSet<>(szamLista);
        System.out.println("Kulonbozo elemek:");
        halmazok.addAll(szamLista);
        System.out.println(halmazok.toString());
        
        //megszámlálás miből mennyi van és eltárolás
        //asszociativ tömb kell
        //HashMap szerkezet = kulcs érték párokat tartalmazó szerkezet
        //Mik a különbözőek? HashSet || Melyikből mennyi van? HashMap
        melyikbolMennyi();
        kiIrHashMap();
        
    }
    
     //megszámlálás miből mennyi van és eltárolás
        //asszociativ tömb kell
        //HashMap szerkezet = kulcs érték párokat tartalmazó szerkezet
        //Mik a különbözőek? HashSet || Melyikből mennyi van? HashMap
    private static void melyikbolMennyi() {
        //kacsacsőr: generikus halmaz
        statisztika = new HashMap<>();
        for (int szam : szamLista) {
            int kulcs = szam;
            if (statisztika.containsKey(kulcs)) {
                //olyat kell keresni aminek a paraméterében 1 kulcsot és 1 értéket meg tudunk adni
                int ertek = statisztika.get(kulcs);// meg van az érték
                //a meglévő értéket növeljük
                statisztika.put(kulcs, ++ertek);
            } else{
                //létrehozzuk a kulcsot 1 értékkel
                statisztika.put(kulcs, 1);
                
            }
        }
    }

    private static void kiIrHashMap() {
        
        /*
        for (változó : érték) {    
        }*/
        System.out.println("Melyikbol mennyi: ");
        for (Map.Entry<Integer, Integer> entry : statisztika.entrySet()){
            int kulcs = entry.getKey();
            int ertek = entry.getValue();
            String s = "[%d] = %d%n".formatted(kulcs,ertek);
            System.out.printf(s);
        }
        
        //Set<Map.Entry<Integer, Integer>> entry = statisztika.entrySet();
    }
    
}
