package code;
import java.util.*;
import java.io.*;

public class Reserved_Words 
{
    private Hashtable<String, String> reservedWords = new Hashtable<String, String>();
    private String words;

    
    public Reserved_Words(String words)
    {
        this.words = words;
        this.init();
    }

    /**
     * Separa las lineas por ","
     * @param word es la line que va a separar
     * Ademas inserta las palabras en la tabla
     */
    private void split(String line) 
    {
        String words[];
        line = line.replaceAll("\\s","");
        words = line.split(",");
        reservedWords.put(words[0], words[1]);
    }

    /**
     * Separa la cadena en saltos de linea
     * 
     */
    public void init() 
    {
        String lines[] = words.split("\n");
        for (String line : lines)
            split(line);
    }

    /**
     * Verifica si la palabra esta en la tabla
     * @param word es la palabra que se buscara 
     * @return verdadero si esta la palabra y falso en otro caso
     */
    public boolean checkReservedWord(String word) 
    {
        return ((reservedWords.containsValue(word)));
    }

    /**
     * Solo muestra los valores de la tabla
     * si se desea ver las llaves, se cambia elements() por keys()
     */
    public void showReservedWords() 
    {
        if(!reservedWords.isEmpty()){
            Enumeration<String> data = reservedWords.elements();
            while (data.hasMoreElements()) {
                System.out.println("" + "hashtable valores: " + data.nextElement());
            }
        }
        else
        System.out.println("No hay palabras reservadas");
        
    }

    public Hashtable<String, String> getReservedWord(){ return this.reservedWords;}

    public void setWords(String words){ this.words = words;}
    public String getWords(){ return this.words;}


}
