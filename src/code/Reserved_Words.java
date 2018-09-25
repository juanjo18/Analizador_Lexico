package code;
import java.util.*;

public class Reserved_Words 
{
    private Hashtable<String, String> reservedWords = new Hashtable<String, String>();

    public Reserved_Words()
    {
        this.init();
    }

    /**
     * Esta parte solo para dar de alta las palabras reservadas
     */
    public void init() 
    {
        reservedWords.put("PRIF", "if");
        reservedWords.put("PRFOR", "for");
        reservedWords.put("PRWHILE", "while");
        reservedWords.put("PRELSE", "else");
        reservedWords.put("PRBEGIN", "inicio");
        reservedWords.put("PREND", "fin");
        reservedWords.put("PRMAIN", "main");
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
        Enumeration<String> data = reservedWords.elements();
        while (data.hasMoreElements()) {
            System.out.println("" + "hashtable valores: " + data.nextElement());
        }
    }

    public Hashtable<String, String> getReservedWord(){ return this.reservedWords;}

    public static void main(String[] args) 
    {
        Reserved_Words pw = new Reserved_Words();
        pw.showReservedWords();
    }
}
