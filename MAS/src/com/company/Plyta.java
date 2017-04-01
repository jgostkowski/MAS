package com.company;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Kuba on 2017-04-01.
 */
public class Plyta implements Serializable{

    private String tytul;
    private Date dataWydania;

    private static ArrayList<Plyta> ekstensja = new ArrayList<>();

    //Atrybut powtarzalny do tytułów
    private ArrayList<String> titleList = new ArrayList<>();

    //konstruktor
    public Plyta(String tytul, Date dataWydania,String... titles) throws Exception {
        setTytul(tytul);
        setTitles(titles);
        setDataWydania(dataWydania);

        ekstensja.add(this);
    }
    //Getter dla listy tytułów
    public ArrayList<String> getTitles(){
        return titleList;
    }
    //setter dal tytułów
    public void setTitles(String... titleArr)throws Exception{
        if(titleArr == null)
            throw new Exception("Tytuly nie mogą być puste");
        if(titleArr.length==0)
            throw new Exception("Musisz podac przynajmniej jeden tytul");

        for(String title : titleArr){
            titleList.add(title);
        }
    }
    //dodajemy nazwy plyt do ekstensji ?
    public void setTitles(ArrayList<String> titles) throws Exception{
        if(titles==null)
            throw new Exception("Tytuly nie moga byc puste");
        this.titleList= new ArrayList<>(titles);
    }

    public String getTytul(){
        return tytul;
    }
    public void setTytul(String tytul)throws Exception{
        if(tytul==null)
            throw new Exception("Tytul nie moze byc pusty");
        this.tytul = tytul;
    }
    public Date getDataWydania(){
        return dataWydania;
    }
    //atrybut zlozony
    public void setDataWydania(Date dataWydania)throws Exception{
        if(dataWydania == null)
            throw new Exception("Data wydania ne moze byc pusta");
        this.dataWydania = dataWydania;
    }
    //pokazujemy ekstensje
    public static void showEkstensja(){
        System.out.println(ekstensja.toString());
    }
    //przeciazona metoda string builder bo wyswietlenia ekstensji ?
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        builder.append(" ");
        builder.append(tytul);
        builder.append(" ");
        SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
        for(String title :titleList){
            builder.append(title);
            builder.append(" ");
        }
        builder.append(simple.format(dataWydania.getTime()));
        return builder.toString();
    }

}
